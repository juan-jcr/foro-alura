package com.foro.infrastructure.adapter.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "topic")
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    @Column(name = "date_of_creation")
    private LocalDate dateOfCreation;
    @Column(name = "topical_status")
    private boolean topicalStatus;
    //implementar más tarde
    //private UserEntity author;
    private String course;

    public TopicEntity(){

    }

    public TopicEntity(Long id, String title, String message, LocalDate dateOfCreation, boolean topicalStatus, String course) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.dateOfCreation = dateOfCreation;
        this.topicalStatus = topicalStatus;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public boolean isTopicalStatus() {
        return topicalStatus;
    }

    public void setTopicalStatus(boolean topicalStatus) {
        this.topicalStatus = topicalStatus;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
