package com.foro.infrastructure.adapter.mapper;

import com.foro.domain.model.Topic;
import com.foro.infrastructure.adapter.entity.TopicEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITopicMapper {
    TopicEntity toTopicEntity(Topic topic);

    Topic toTopic(TopicEntity entity);

    List<Topic> toTopicList(List<TopicEntity> entityList);
}
