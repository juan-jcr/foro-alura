package com.foro.application.usecases;

import com.foro.infrastructure.rest.dto.TopicDto;
import com.foro.infrastructure.rest.dto.TopicResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ITopicService {
    List<TopicResponse> findAll();
    TopicResponse addTopic(TopicDto topicDto);
    String deleteTopic(Long id);
    TopicResponse updateTopic(Long id, TopicDto topicDto);
    TopicResponse findByIdTopic(Long id);
}
