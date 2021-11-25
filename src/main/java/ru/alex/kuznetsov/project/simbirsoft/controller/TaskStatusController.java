package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksStatusServise;

import java.io.IOException;

@Tag(name = "Статус Задачи")
@RestController
@RequestMapping("/taskStatus")
public class TaskStatusController {

    private final Logger logger = LoggerFactory.getLogger(TaskStatusController.class);

    private final ITasksStatusServise tasksStatusService;

    public TaskStatusController(ITasksStatusServise tasksStatusService) {
        this.tasksStatusService = tasksStatusService;
    }

    @Operation(summary = "Создать статус задачу")
    @PostMapping(value = "/create")
    public ResponseEntity<TaskStatusResponseDto> createTaskStatus(@RequestBody TaskStatusRequestDto requestDto) {
        logger.info("POST /taskStatus/create");
        logger.debug("TaskStatusRequestDto {}", requestDto);
        TaskStatusResponseDto responseDto = tasksStatusService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить статус задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskStatusResponseDto> updateTaskStatus(@PathVariable Integer id, @RequestBody TaskStatusRequestDto requestDto) {
        logger.info(String.format("PUT /taskStatus/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        TaskStatusResponseDto responseDto = tasksStatusService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить статус задачи")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTaskStatus(@PathVariable Integer id) {
        logger.info(String.format("DELETE /taskStatus/delete id = %d", id));
        tasksStatusService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}



