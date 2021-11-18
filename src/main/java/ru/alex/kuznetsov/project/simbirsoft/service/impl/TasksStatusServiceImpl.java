package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.TaskStatusRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksStatusServise;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;

@Service
public class TasksStatusServiceImpl implements ITasksStatusServise {

    private final TaskStatusRepository taskStatusRepository;

    public TasksStatusServiceImpl(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    public TaskStatusResponseDto getById(Integer id) {
        taskStatusRepository.findById(id).orElseThrow(() -> new NoEntityException("TaskStatus not found"));
        return CommonMapper.fromTaskStatusEntityToTaskStatusResponseDto(taskStatusRepository.getById(id));
    }

    @Override
    public TaskStatusResponseDto create(TaskStatusRequestDto requestDto) {        return null;    }

    @Override
    public TaskStatusResponseDto update(TaskStatusRequestDto requestDto) {        return null;    }

    @Override
    public List<TaskStatusResponseDto> getAll() {        return null;    }


    @Override
    public void deleteById(Integer id) {    }
}
