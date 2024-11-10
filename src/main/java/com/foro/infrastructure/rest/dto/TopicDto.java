package com.foro.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;


public class TopicDto {
    @NotBlank(message = "El titulo es obligatorio")
    private String title;
    @NotBlank(message = "el mensaje es obligatorio")
    private String message;

    @NotBlank(message = "el curso no puede ser nulo")
    private String course;

    public TopicDto(){}
    public TopicDto(String title, String message,  String course) {
        this.title = title;
        this.message = message;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
