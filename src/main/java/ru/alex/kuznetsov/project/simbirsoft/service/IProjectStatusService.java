package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectStatusRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectStatusResponseDto;

import java.util.List;

public interface IProjectStatusService {

    /**
     * get all projectStatus
     * @return list project
     */
    List<ProjectStatusResponseDto> getAll();

    /**
     * get projectStatus by him id
     * @param id id projectStatus
     * @return projectStatus
     */
    ProjectStatusResponseDto getById(Integer id);

    /**
     * create new projectStatus
     * @param requestDto properties new projectStatus
     * @return new projectStatus
     */
    ProjectStatusResponseDto create(ProjectStatusRequestDto requestDto);

    /**
     * update old projectStatus new values
     * @param requestDto new values projectStatus
     * @return projectStatus
     */
    ProjectStatusResponseDto update(ProjectStatusRequestDto requestDto);

    /**
     * delete projectStatus by him id
     * @param id id projectStatus
     */
    void deleteById(Integer id);
}

