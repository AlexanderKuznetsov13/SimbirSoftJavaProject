package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.ProjectEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ProjectRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IProjectService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponseDto getById(Integer id) {
        System.out.println(String.format("getById - get project with %id", id));
        ProjectEntity project = projectRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Project with ID = %d not found", id)));
        return CommonMapper.fromProjectEntityToProjectResponseDto(project);
    }

    @Override
    public ProjectResponseDto create(ProjectRequestDto requestDto) {
        System.out.println(String.format("create - create project"));
        ProjectEntity project = CommonMapper.fromProjectRequestDtoToProjectEntity(requestDto);
        return CommonMapper.fromProjectEntityToProjectResponseDto(projectRepository.save(project));
    }

    @Override
    public ProjectResponseDto update(ProjectRequestDto requestDto) {
        ProjectEntity project = CommonMapper.fromProjectRequestDtoToProjectEntity(requestDto);
        System.out.println(String.format("update - update project with %id", project.getId()));
        return CommonMapper.fromProjectEntityToProjectResponseDto(projectRepository.save(project));
    }

    @Override
    public List<ProjectResponseDto> getAll() {
        System.out.println(String.format("getAll - retrieve all projects"));
        return projectRepository.findAll().stream().map(CommonMapper::fromProjectEntityToProjectResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        projectRepository.findById(id).orElseThrow(() -> {
            System.out.println(String.format("deleteById - Project with ID = %d not found", id));
            return new NoEntityException(String.format("Project with ID = %d not found", id));
        });
        projectRepository.deleteById(id);
    }
}

