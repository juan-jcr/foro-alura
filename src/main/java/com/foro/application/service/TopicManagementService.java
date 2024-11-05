package com.foro.application.service;

import com.foro.application.usecases.ITopicService;
import com.foro.domain.exception.ResourceNotFoundException;
import com.foro.domain.model.Topic;
import com.foro.domain.port.ITopicPersistence;
import com.foro.infrastructure.rest.dto.TopicDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<TopicDto> findAll() {
        List<Topic> topics = (List<Topic>) topicPersistence.findAll();
        return topics.stream().map(topic -> modelMapper.map(topic, TopicDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TopicDto addTopic(TopicDto topicDto) {
        Optional<Topic> existingTopic = topicPersistence
                .findByTitleAndMessage(topicDto.getTitle(), topicDto.getMessage());
        if(existingTopic.isPresent()){
            throw new ResourceNotFoundException("Ya existe un Topico");
        }
        Topic topic = modelMapper.map(topicDto, Topic.class);
        Topic topicSaved = topicPersistence.save(topic);
        return modelMapper.map(topicSaved, TopicDto.class);
    }
}
