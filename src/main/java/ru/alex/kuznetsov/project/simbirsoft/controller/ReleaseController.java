package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.service.IReleaseService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление релизами")
@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    IReleaseService releaseService;


    @Operation(summary = "Создать релиз")
    @PostMapping(value = "/create")
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto responseDto = releaseService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить релиз")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> updateRelease(@PathVariable Integer id, @RequestBody ReleaseRequestDto requestDto) {
        requestDto.setId(id);
        ReleaseResponseDto responseDto = releaseService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить релиз")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> getReleaseById(@PathVariable Integer id) {
        ReleaseResponseDto responseDto = releaseService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все релизы")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ReleaseResponseDto>> getAllRelease() {
        List<ReleaseResponseDto> list =  releaseService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRelease(@PathVariable Integer id) {
        releaseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}
