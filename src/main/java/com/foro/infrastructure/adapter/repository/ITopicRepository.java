package com.foro.infrastructure.adapter.repository;


import com.foro.infrastructure.adapter.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITopicRepository extends JpaRepository<TopicEntity, Long> {
    Optional<TopicEntity> findByTitleAndMessage(String title, String message);

}
