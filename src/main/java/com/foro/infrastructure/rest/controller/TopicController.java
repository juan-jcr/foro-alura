package com.foro.infrastructure.rest.controller;

import com.foro.application.usecases.ITopicService;
import com.foro.infrastructure.rest.dto.TopicDto;
import com.foro.infrastructure.rest.dto.TopicResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
@Tag(name = "Tópico", description = "Controlador Tópico")
public class TopicController {
    private final  ITopicService topicService;

    @Autowired
    public TopicController(ITopicService topicService) {
        this.topicService = topicService;
    }

    @Operation(
            summary = "Listar tópicos",
            description = "Listar tópicos.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = TopicResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<TopicResponse>> findAll(){
        return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Registro de un nuevo tópico",
            description = "Registrar un tópico.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Solicitud de registro título mensaje y curso",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TopicDto.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201 CREATE",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TopicResponse.class)
                            )
                    )
            }
    )
    @PostMapping("/add")
    public ResponseEntity<TopicResponse> save(@RequestBody @Valid TopicDto topicDto){
        return new ResponseEntity<>(topicService.addTopic(topicDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Eliminar un tópico",
            description = "Eliminar un tópico por id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200"
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String > deleteTopic(@PathVariable Long id){
        return new ResponseEntity<>(topicService.deleteTopic(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Actualizar tópico",
            description = "Actualizar un tópico por id.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Solicitud de actualización título mensaje y curso",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TopicDto.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200 OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TopicResponse.class)
                            )
                    )
            }
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<TopicResponse> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicDto topicDto){
        return new ResponseEntity<>(topicService.updateTopic(id, topicDto), HttpStatus.OK);
    }

    @Operation(
            summary = "Listar un tópico",
            description = "Listar un tópico por",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = TopicResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/find/{id}")
    public ResponseEntity<TopicResponse> findByIdTopic(@PathVariable Long id){
        return new ResponseEntity<>(topicService.findByIdTopic(id), HttpStatus.OK);
    }
}
