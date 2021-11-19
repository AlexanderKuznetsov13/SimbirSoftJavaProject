package ru.alex.kuznetsov.project.simbirsoft.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.IUsersByProjectService;

import java.io.IOException;

@Tag(name = "Пользователь в проекте")
@RestController
@RequestMapping("/userByProject")
public class UserByProjectController {

    @Autowired
    IUsersByProjectService usersByProjectService;

    @Operation(summary = "Создать тип пользователя в проекте")
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createUserByProject(@RequestBody UsersByProjectRequestDto requestDto) {
        UsersByProjectResponseDto responseDto = usersByProjectService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить тип пользователя в проекте")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsersByProjectResponseDto> updateUserByProject(@PathVariable Integer id, @RequestBody UsersByProjectRequestDto requestDto) {
        requestDto.setId(id);
        UsersByProjectResponseDto responseDto = usersByProjectService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить тип пользователя в проекте")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUserByProject(@PathVariable Integer id) {
        usersByProjectService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}


