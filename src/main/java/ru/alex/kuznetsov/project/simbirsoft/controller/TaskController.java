package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление задачами")
@RestController
@RequestMapping(value = "/task", produces = "application/json;charset=UTF-8")
public class TaskController {

    @Autowired
    ITasksService tasksService;

    @Operation(summary = "Получить задачу по ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<BoardTaskResponseDto> getTaskById(@PathVariable Integer id) {
           BoardTaskResponseDto responseDto = tasksService.getById(id);
           return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Создать задачу")
    @PostMapping(value = "/create")
    public ResponseEntity<BoardTaskResponseDto> createTask(@RequestBody BoardTaskRequestDto requestDto) {
        BoardTaskResponseDto responseDto = tasksService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "вывести все задачи")
    @GetMapping("/all")
    public ResponseEntity<List<BoardTaskResponseDto>> getAllTasks() {
        List<BoardTaskResponseDto> list = tasksService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Изменить задачу")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BoardTaskResponseDto> updateTask(@PathVariable Integer id, @RequestBody BoardTaskRequestDto requestDto) {
        requestDto.setId(id);
        BoardTaskResponseDto responseDto = tasksService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRelease(@PathVariable Integer id) {
         tasksService.deleteById(id);
         return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }

}
