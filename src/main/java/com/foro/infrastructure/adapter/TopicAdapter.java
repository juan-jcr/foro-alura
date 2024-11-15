package com.foro.infrastructure.adapter;

import com.foro.domain.model.Author;
import com.foro.domain.model.Topic;
import com.foro.domain.port.ITopicPersistence;
import com.foro.infrastructure.adapter.mapper.ITopicMapper;
import com.foro.infrastructure.adapter.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TopicAdapter implements ITopicPersistence {
    private final ITopicRepository repository;
    private final ITopicMapper mapper;

    @Autowired
    public TopicAdapter(ITopicRepository repository, ITopicMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Topic> findAll() {
        return mapper.toTopicList(repository.findAll());
    }

    @Override
    public Topic save(Topic topic) {
        return mapper.toTopic(
                repository.save(mapper.toTopicEntity(topic)));
    }

    @Override
    public Optional<Topic> findByTitleAndMessage(String title, String message) {
        return repository.findByTitleAndMessage(title, message)
                .map(mapper::toTopic);
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toTopic);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
