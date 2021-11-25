package ru.alex.kuznetsov.project.simbirsoft.service.impl;


import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.TaskRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements ITasksService {

    private final TaskRepository taskRepository;
    public TasksServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public BoardTaskResponseDto getById(Integer id) {
        System.out.println(String.format("getById - get task with %id",id));
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Task with ID = %d not found", id)));
        return CommonMapper.fromTaskEntityToBoardTaskResponseDto(task);
    }

    @Override
    public BoardTaskResponseDto create(BoardTaskRequestDto requestDto) {
        System.out.println(String.format("create - create task"));
        TaskEntity task = CommonMapper.fromTaskRequestDtoToTaskEntity(requestDto);
        return CommonMapper.fromTaskEntityToBoardTaskResponseDto(taskRepository.save(task));
    }

    @Override
    public BoardTaskResponseDto update(BoardTaskRequestDto requestDto) {
        TaskEntity task = CommonMapper.fromTaskRequestDtoToTaskEntity(requestDto);
        System.out.println(String.format("update - update task with %id", task.getId()));
        return CommonMapper.fromTaskEntityToBoardTaskResponseDto(taskRepository.save(task));
    }

    @Override
    public List<BoardTaskResponseDto> getAll() {
        System.out.println(String.format("getAll - retrieve all tasks"));
        return taskRepository.findAll().stream().map(CommonMapper::fromTaskEntityToBoardTaskResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.findById(id).orElseThrow(() -> {
            System.out.println(String.format("deleteById - Task with ID = %d not found", id));
            return new NoEntityException(String.format("Task with ID = %d not found", id));
        });
        taskRepository.deleteById(id);
    }
}
