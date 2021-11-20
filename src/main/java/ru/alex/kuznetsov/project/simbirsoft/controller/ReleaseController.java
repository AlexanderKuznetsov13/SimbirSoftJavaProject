package ru.alex.kuznetsov.project.simbirsoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(ReleaseController.class);

    @Autowired
    IReleaseService releaseService;


    @Operation(summary = "Количество задач незавершенных в заданный релиз")
    @GetMapping(value = "/{id}/countuncompletedtasks")
    public ResponseEntity<Integer> getQtyUncompletedTasksById(@PathVariable Integer id) {
       logger.info(String.format("GET /release/{id}/countuncompletedtasks id = %d", id));
       return ResponseEntity.ok().body(releaseService.getQtyUncompletedTasksById(id));
    }


    @Operation(summary = "Создать релиз")
    @PostMapping(value = "/create")
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        logger.info("POST /release/create");
        logger.debug("ReleaseRequestDto {}", requestDto);
        ReleaseResponseDto responseDto = releaseService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить релиз")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> updateRelease(@PathVariable Integer id, @RequestBody ReleaseRequestDto requestDto) {
        logger.info(String.format("PUT /release/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        ReleaseResponseDto responseDto = releaseService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить релиз")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReleaseResponseDto> getReleaseById(@PathVariable Integer id) {
        logger.info(String.format("GET /release id = %d %d", id));
        ReleaseResponseDto responseDto = releaseService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все релизы")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ReleaseResponseDto>> getAllRelease() {
        logger.info("GET All releases /all");
        List<ReleaseResponseDto> list =  releaseService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRelease(@PathVariable Integer id) {
        logger.info(String.format("DELETE /release/delete id = %d", id));
        releaseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().build();
    }
}
