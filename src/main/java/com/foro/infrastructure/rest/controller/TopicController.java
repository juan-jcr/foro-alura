package com.foro.infrastructure.rest.controller;

import com.foro.application.usecases.ITopicService;
import com.foro.infrastructure.rest.dto.TopicDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicController {
    private final  ITopicService topicService;

    @Autowired
    public TopicController(ITopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TopicDto>> findAll(){
        return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<TopicDto> save(@RequestBody @Valid TopicDto topicDto){
        return new ResponseEntity<>(topicService.addTopic(topicDto), HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String > deleteTopic(@PathVariable Long id){
        return new ResponseEntity<>(topicService.deleteTopic(id), HttpStatus.OK);
    }
}
