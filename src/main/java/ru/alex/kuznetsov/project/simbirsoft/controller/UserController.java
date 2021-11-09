package ru.alex.kuznetsov.project.simbirsoft.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserResponseDto;

import java.io.IOException;

@Tag(name = "Пользователь")
@RestController
@RequestMapping("/user")
public class UserController {

    @Operation(summary = "Создать  пользователя")
    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Изменить  пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Удалить  пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}

