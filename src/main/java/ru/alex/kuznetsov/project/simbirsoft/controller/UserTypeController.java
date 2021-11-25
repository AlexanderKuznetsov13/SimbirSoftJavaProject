package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserTypeService;

import java.io.IOException;

@Tag(name = "Тип пользователя")
@RestController
@RequestMapping("/usertype")
public class UserTypeController {

    private final Logger logger = LoggerFactory.getLogger(UserTypeController.class);

    private final IUserTypeService userTypeService;

    public UserTypeController(IUserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @Operation(summary = "Создать тип пользователя")
    @PostMapping(value = "/create")
    public ResponseEntity<UserTypeResponseDto> createUserType(@RequestBody UserTypeRequestDto requestDto) {
        logger.info("POST /userType/create");
        logger.debug("UserTypeRequestDto {}", requestDto);
        UserTypeResponseDto responseDto = userTypeService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить тип пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserTypeResponseDto> updateUserType(@PathVariable Integer id, @RequestBody UserTypeRequestDto requestDto) {
        logger.info(String.format("PUT /userType/update id = %d", requestDto.getId()));
        requestDto.setId(id);
       UserTypeResponseDto responseDto = userTypeService.update(requestDto);
       return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить тип пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUserType(@PathVariable Integer id) {
        logger.info(String.format("DELETE /userType/delete id = %d", id));
        userTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}

