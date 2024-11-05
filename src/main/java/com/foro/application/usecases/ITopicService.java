package com.foro.application.usecases;

import com.foro.infrastructure.rest.dto.TopicDto;

import java.util.List;

public interface ITopicService {
    List<TopicDto> findAll();
    TopicDto addTopic(TopicDto topicDto);
}
