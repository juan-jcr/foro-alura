package com.foro.application.service;

import com.foro.application.usecases.ITopicService;
import com.foro.domain.exception.AlreadyExistsException;
import com.foro.domain.exception.ResourceNotFoundException;
import com.foro.domain.model.Topic;
import com.foro.domain.port.ITopicPersistence;
import com.foro.infrastructure.rest.dto.TopicDto;
import com.foro.infrastructure.rest.dto.TopicResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicManagementService implements ITopicService {

    private final ITopicPersistence topicPersistence;
    private final ModelMapper modelMapper;

    @Autowired
    public TopicManagementService(ITopicPersistence topicPersistence, ModelMapper modelMapper) {
        this.topicPersistence = topicPersistence;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TopicResponse> findAll() {
        List<Topic> topics = (List<Topic>) topicPersistence.findAll();
        return topics.stream().map(topic -> modelMapper.map(topic, TopicResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public TopicResponse addTopic(TopicDto topicDto) {
        Optional<Topic> existingTopic = topicPersistence
                .findByTitleAndMessage(topicDto.getTitle(), topicDto.getMessage());
        if(existingTopic.isPresent()){
            throw new AlreadyExistsException("Ya existe un Topico");
        }
        Topic topic = modelMapper.map(topicDto, Topic.class);
        LocalDate date = LocalDate.now();
        topic.setDateOfCreation(date);
        topic.setTopicalStatus(true);
        Topic topicSaved = topicPersistence.save(topic);
        return modelMapper.map(topicSaved, TopicResponse.class);
    }

    @Override
    public String deleteTopic(Long id) {
        topicPersistence.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe tópico"));
        topicPersistence.deleteById(id);
        return "Eliminado con exito";
    }

    @Override
    public TopicResponse updateTopic(Long id, TopicDto topicDto) {
        Topic topic = topicPersistence.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic no existe") );

        Optional<Topic> findTopic = topicPersistence.findByTitleAndMessage(topicDto.getTitle(), topicDto.getMessage());
        if(findTopic.isPresent() && !findTopic.get().equals(topic)){
            throw new ResourceNotFoundException("Ya existe un topico con ese mismo nombre");
        }
        LocalDate date = LocalDate.now();
        topic.setTitle(topicDto.getTitle());
        topic.setMessage(topicDto.getMessage());
        topic.setDateOfCreation(date);
        topic.setTopicalStatus(true);
        topic.setCourse(topicDto.getCourse());

        Topic topicSaved = topicPersistence.save(topic);
        return modelMapper.map(topicSaved, TopicResponse.class);

    }

    @Override
    public TopicResponse findByIdTopic(Long id) {
        Topic topic = topicPersistence.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topico no existe"));

        return modelMapper.map(topic, TopicResponse.class);
    }
}
