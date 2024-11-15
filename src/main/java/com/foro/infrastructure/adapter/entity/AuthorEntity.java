package com.foro.infrastructure.adapter.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<TopicEntity> topicEntities;*/
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TopicEntity> topicEntities = new ArrayList<>();

    public AuthorEntity(){}
    public AuthorEntity(Long id, String name, String email, String password, List<TopicEntity> topicEntities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.topicEntities = topicEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TopicEntity> getTopicEntities() {
        return topicEntities;
    }

    public void setTopicEntities(List<TopicEntity> topicEntities) {
        this.topicEntities = topicEntities;
    }
}

