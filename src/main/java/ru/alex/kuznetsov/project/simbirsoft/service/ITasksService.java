package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;

import java.util.List;

public interface ITasksService {
    /**
     * get all tasks
     * @return list tasks
     */
    List<BoardTaskResponseDto> getAll();

    /**
     * get task by him id
     * @param id id tasm
     * @return task
     */
    BoardTaskResponseDto getById(Integer id);

    /**
     * create new task
     * @param requestDto properties new task
     * @return new task
     */
    BoardTaskResponseDto create(BoardTaskRequestDto requestDto);

    /**
     * update old task new values
     * @param requestDto new values task
     * @return task
     */
    BoardTaskResponseDto update(BoardTaskRequestDto requestDto);

    /**
     * delete task by him id
     * @param id id task
     */
    void deleteById(Integer id);
}
