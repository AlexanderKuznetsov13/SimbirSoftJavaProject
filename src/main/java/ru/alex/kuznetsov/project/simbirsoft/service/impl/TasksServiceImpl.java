package ru.alex.kuznetsov.project.simbirsoft.service.impl;


import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.TaskRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;

@Service
public class TasksServiceImpl implements ITasksService {

    @Override
    public List<BoardTaskResponseDto> getAll() {return null;}


    private final TaskRepository taskRepository;
    public TasksServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public BoardTaskResponseDto getById(Integer id) {
        taskRepository.findById(id).orElseThrow(() -> new NoEntityException("Task not found"));
        return CommonMapper.fromTaskEntityToBoardTaskResponseDto(taskRepository.getById(id));
    }

    @Override
    public BoardTaskResponseDto create(BoardTaskRequestDto requestDto) {return null;}

    @Override
    public BoardTaskResponseDto update(BoardTaskRequestDto requestDto) {return null;}

    @Override
    public void deleteById(Integer id) { }
}
