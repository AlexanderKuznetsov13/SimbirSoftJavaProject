package ru.alex.kuznetsov.project.simbirsoft.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.IProjectService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление проектами")
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    IProjectService projectService;

    @Operation(summary = "Создать проект")
    @PostMapping(value = "/create")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        logger.info("POST /project/create");
        logger.debug("ProjectRequestDto {}", requestDto);
        ProjectResponseDto responseDto = projectService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить проект")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Integer id, @RequestBody ProjectRequestDto requestDto) {
        logger.info(String.format("PUT /project/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        ProjectResponseDto responseDto = projectService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить список задач проекта")
    @GetMapping(value = "/{id}/tasks")
    public ResponseEntity<List<BoardTaskResponseDto>> getTasksProject(@PathVariable Integer id) {
        logger.info(String.format("GET /project/{id}/tasks id = %d", id));
        return ResponseEntity.ok().body(projectService.getTasksProject(id));
    }


    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProject(@PathVariable Integer id) {
        logger.info(String.format("DELETE /project/delete id = %d", id));
        projectService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получить все проекты")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        logger.info("GET All project /all");
        List<ProjectResponseDto> list =  projectService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}

