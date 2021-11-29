package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.TaskStatusResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskStatusEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.TaskStatusRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.ITasksStatusServise;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksStatusServiceImpl implements ITasksStatusServise {

    private final Logger logger = LoggerFactory.getLogger(TasksStatusServiceImpl.class);

    private final TaskStatusRepository taskStatusRepository;

    public TasksStatusServiceImpl(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    public TaskStatusResponseDto getById(Integer id) {
        logger.debug(String.format("getById - get taskStatus with %id",id));
        TaskStatusEntity taskStatus = taskStatusRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("TaskStatus with ID = %d not found", id)));
        return CommonMapper.fromTaskStatusEntityToTaskStatusResponseDto(taskStatus);
    }

    @Override
    public TaskStatusResponseDto create(TaskStatusRequestDto requestDto) {
        logger.debug(String.format("create - create taskStatus"));
        TaskStatusEntity taskStatus = CommonMapper.fromTaskStasusRequestDtoToTaskStatusEntity(requestDto);
        return CommonMapper.fromTaskStatusEntityToTaskStatusResponseDto(taskStatusRepository.save(taskStatus));
    }

    @Override
    public TaskStatusResponseDto update(TaskStatusRequestDto requestDto) {
        TaskStatusEntity taskStatus = CommonMapper.fromTaskStasusRequestDtoToTaskStatusEntity(requestDto);
        logger.debug(String.format("update - update taskStatus with %id", taskStatus.getId()));
        return CommonMapper.fromTaskStatusEntityToTaskStatusResponseDto(taskStatusRepository.save(taskStatus));
    }

    @Override
    public List<TaskStatusResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all taskStatus"));
        return taskStatusRepository.findAll().stream().map(CommonMapper::fromTaskStatusEntityToTaskStatusResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        taskStatusRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - TaskStatus with ID = %d not found", id));
            return new NoEntityException(String.format("TaskStatus with ID = %d not found", id));
        });
        taskStatusRepository.deleteById(id);
    }
}
