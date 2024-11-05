package com.foro.domain.port;


import com.foro.domain.model.Topic;

import java.util.List;
import java.util.Optional;

public interface ITopicPersistence {
    List<Topic> findAll();
    Topic save(Topic topic);
    Optional<Topic> findByTitleAndMessage(String title, String message);
}
