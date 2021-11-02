package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusResponseDto;

import java.io.IOException;

@Tag(name = "Статус Задачи")
@RestController
@RequestMapping("/taskstatus")
public class TaskStatusController {

    @Operation(summary = "Создать задачу")
    @PostMapping(value = "/create")
    public ResponseEntity<TaskStatusResponseDto> createTaskStatus(@RequestBody TaskStatusRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Изменить статус задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskStatusResponseDto> updateTaskStatus(@PathVariable Integer id, @RequestBody TaskStatusRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTaskStatus(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}



