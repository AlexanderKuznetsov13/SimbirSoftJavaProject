package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeResponseDto;

import java.io.IOException;

@Tag(name = "Тип пользователя")
@RestController
@RequestMapping("/usertype")
public class UserTypeController {

    @Operation(summary = "Создать тип пользователя")
    @PostMapping(value = "/create")
    public ResponseEntity<UserTypeResponseDto> createUserType(@RequestBody UserTypeRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Изменить тип пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserTypeResponseDto> updateUserType(@PathVariable Integer id, @RequestBody UserTypeRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Удалить тип пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUserType(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}

