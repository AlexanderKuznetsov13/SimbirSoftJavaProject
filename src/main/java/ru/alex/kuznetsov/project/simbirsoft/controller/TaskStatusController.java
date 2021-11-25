package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksStatusServise;

import java.io.IOException;

@Tag(name = "Статус Задачи")
@RestController
@RequestMapping("/taskStatus")
public class TaskStatusController {

    @Autowired
    ITasksStatusServise tasksStatusService;

    @Operation(summary = "Создать статус задачу")
    @PostMapping(value = "/create")
    public ResponseEntity<TaskStatusResponseDto> createTaskStatus(@RequestBody TaskStatusRequestDto requestDto) {
        TaskStatusResponseDto responseDto = tasksStatusService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить статус задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskStatusResponseDto> updateTaskStatus(@PathVariable Integer id, @RequestBody TaskStatusRequestDto requestDto) {
        requestDto.setId(id);
        TaskStatusResponseDto responseDto = tasksStatusService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить статус задачи")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTaskStatus(@PathVariable Integer id) {
        tasksStatusService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}



