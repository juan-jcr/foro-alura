package com.foro.infrastructure.rest.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TopicDto {
    private Long id;
    @NotBlank(message = "El titulo no puede ser nulo")
    private String title;
    @NotBlank(message = "el mensaje no puede ser nulo")
    private String message;
    @NotNull(message = "La fecha no puede ser nula")
    @FutureOrPresent(message = "La fecha debe ser hoy o una fecha futura")
    private LocalDate dateOfCreation;
    private boolean topicalStatus;
    @NotBlank(message = "el curso no puede ser nulo")
    private String course;

    public TopicDto(){}
    public TopicDto(Long id, String title, String message, LocalDate dateOfCreation, boolean topicalStatus, String course) {
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
