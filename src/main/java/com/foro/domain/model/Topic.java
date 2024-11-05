package com.foro.domain.model;


import java.time.LocalDate;

public class Topic {
    private Long id;
    private String title;
    private String message;
    private LocalDate dateOfCreation;
    private boolean topicalStatus;
    private String course;

    public Topic(){}
    public Topic(Long id, String course, boolean topicalStatus, LocalDate dateOfCreation, String message, String title) {
        this.id = id;
        this.course = course;
        this.topicalStatus = topicalStatus;
        this.dateOfCreation = dateOfCreation;
        this.message = message;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isTopicalStatus() {
        return topicalStatus;
    }

    public void setTopicalStatus(boolean topicalStatus) {
        this.topicalStatus = topicalStatus;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
