package ru.alex.kuznetsov.project.simbirsoft.service;


import ru.alex.kuznetsov.project.simbirsoft.dto.BoardTaskResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;

import java.util.List;

public interface IProjectService {

    /**
     * get project by  id
     * @param id id project
     * @return project
     */


    ProjectResponseDto getById(Integer id);

    /**
     * create new project
     * @param requestDto properties new project
     * @return new project
     */
    ProjectResponseDto create(ProjectRequestDto requestDto);

    /**
     * update old project new values
     * @param requestDto new values project
     * @return project
     */
    ProjectResponseDto update(ProjectRequestDto requestDto);

    /**
     * get all projects
     * @return list projects
     */
    List<ProjectResponseDto> getAll();

    /**
     * get all releases by id project
     * @param id id project
     * @return list releases
     */
    List<ReleaseResponseDto> getReleasesProject(Integer id);

    /**
     * get all tasks by id project
     * @param id id project
     * @return list tasks
     */
    List<BoardTaskResponseDto> getTasksProject(Integer id);

    /**
     * delete project by his id
     * @param id id project
     */
    void deleteById(Integer id);
}

