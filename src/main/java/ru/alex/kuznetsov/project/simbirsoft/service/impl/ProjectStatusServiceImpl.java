package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectStatusResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.ProjectStatusEntity;
import ru.alex.kuznetsov.project.simbirsoft.entity.TaskStatusEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ProjectStatusRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IProjectStatusService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectStatusServiceImpl implements IProjectStatusService {

    private final static Logger logger = LoggerFactory.getLogger(ProjectStatusServiceImpl.class);

    private final ProjectStatusRepository projectStatusRepository;

    public ProjectStatusServiceImpl(ProjectStatusRepository projectStatusRepository) {
        this.projectStatusRepository = projectStatusRepository;
    }

    @Override
    public List<ProjectStatusResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all projectsStatus"));
        return projectStatusRepository.findAll().stream().map(CommonMapper::fromProjectStatusEntityToProjectStatusResponseDto).collect(Collectors.toList());
    }

    @Override
    public ProjectStatusResponseDto getById(Integer id) {
        logger.debug(String.format("getById - ProjectStatus with ID = %d not found", id));
        ProjectStatusEntity project = projectStatusRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("ProjectStatus with ID = %d not found", id)));
        return CommonMapper.fromProjectStatusEntityToProjectStatusResponseDto(project);
    }

    @Override
    public ProjectStatusResponseDto create(ProjectStatusRequestDto requestDto) {
        logger.debug(String.format("create - create projectStatus"));
        ProjectStatusEntity project = CommonMapper.fromProjectStatusRequestDtoToProjectStatusEntity(requestDto);
        return CommonMapper.fromProjectStatusEntityToProjectStatusResponseDto(projectStatusRepository.save(project));
    }

    @Override
    public ProjectStatusResponseDto update(ProjectStatusRequestDto requestDto) {
        ProjectStatusEntity projectStatus = CommonMapper.fromProjectStatusRequestDtoToProjectStatusEntity(requestDto);
        logger.debug(String.format("update - update projectStatus with %id", projectStatus.getId()));
        return CommonMapper.fromProjectStatusEntityToProjectStatusResponseDto(projectStatusRepository.save(projectStatus));

    }

    @Override
    public void deleteById(Integer id) {
        projectStatusRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - Project with ID = %d not found", id));
            return new NoEntityException(String.format("Project with ID = %d not found", id));
        });
        projectStatusRepository.deleteById(id);
    }

}

