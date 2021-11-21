package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectStatusResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.IProjectStatusService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Статус Проекта")
@RestController
@RequestMapping("/projectStatus")
public class ProjectStatusController {

    private final Logger logger = LoggerFactory.getLogger(ProjectStatusController.class);

    @Autowired
    IProjectStatusService projectStatusService;

    @Operation(summary = "Создать статус проект")
    @PostMapping(value = "/create")
    public ResponseEntity<ProjectStatusResponseDto> createProjectStatus(@RequestBody ProjectStatusRequestDto requestDto) {
        logger.info("POST /projectStatus/create");
        logger.debug("ProjectStatusRequestDto {}", requestDto);
        ProjectStatusResponseDto responseDto = projectStatusService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить статус проекта")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectStatusResponseDto> updateProject(@PathVariable Integer id, @RequestBody ProjectStatusRequestDto requestDto) {
        logger.info(String.format("PUT /projectStatus/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        ProjectStatusResponseDto responseDto = projectStatusService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить статус проекта")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProject(@PathVariable Integer id) {
        logger.info(String.format("DELETE /projectStatus/delete id = %d", id));
        projectStatusService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получить все статусы проектов")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ProjectStatusResponseDto>> getAllProjectsStatus() {
        logger.info("GET All project /all");
        List<ProjectStatusResponseDto> list =  projectStatusService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}


