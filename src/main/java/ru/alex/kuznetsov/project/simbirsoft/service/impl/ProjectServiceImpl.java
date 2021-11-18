package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ProjectRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IProjectService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponseDto getById(Integer id) {
        projectRepository.findById(id).orElseThrow(() -> new NoEntityException("Project not found"));
        return CommonMapper.fromProjectEntityToProjectResponseDto(projectRepository.getById(id));
    }

    @Override
    public ProjectResponseDto create(ProjectRequestDto requestDto) {
        return null;
    }

    @Override
    public ProjectResponseDto update(ProjectRequestDto requestDto) {
        return null;
    }

    @Override
    public List<ProjectResponseDto> getAll() { return null;  }

    @Override
    public void deleteById(Integer id) {

    }
}

