package ru.alex.kuznetsov.project.simbirsoft.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserService;

import java.io.IOException;

@Tag(name = "Пользователь")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Operation(summary = "Создать пользователя")
    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDto> createUserType(@RequestBody UserRequestDto requestDto) {
        UserResponseDto responseDto = userService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить  пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto) {
        requestDto.setId(id);
        UserResponseDto responseDto = userService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}

