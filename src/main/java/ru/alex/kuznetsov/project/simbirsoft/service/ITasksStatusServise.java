package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusResponseDto;

import java.util.List;

public interface ITasksStatusServise {


    /**
     * get all taskStatus
     * @return list tasks
     */
    List<TaskStatusResponseDto> getAll();

    /**
     * get taskStatus by him id
     * @param id id taskStatus
     * @return taskStatus
     */
    TaskStatusResponseDto getById(Integer id);

    /**
     * create new taskStatus
     * @param requestDto properties new taskStatus
     * @return new taskStatus
     */
    TaskStatusResponseDto create(TaskStatusRequestDto requestDto);

    /**
     * update old taskStatus new values
     * @param requestDto new values taskStatus
     * @return taskStatus
     */
    TaskStatusResponseDto update(TaskStatusRequestDto requestDto);

    /**
     * delete taskStatus by him id
     * @param id id taskStatus
     */
    void deleteById(Integer id);
}
