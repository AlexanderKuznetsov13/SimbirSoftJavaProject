package ru.alex.kuznetsov.project.simbirsoft.service;


import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectResponseDto;

import java.util.List;

public interface IUsersByProjectService {
    /**
     * get all UsersByProject
     * @return list UsersByProject
     */
    List<UsersByProjectResponseDto> getAll();

    /**
     * get UsersByProject by his id
     * @param id id UsersByProject
     * @return UsersByProject
     */
    UsersByProjectResponseDto getById(Integer id);

    /**
     * create new UsersByProject
     * @param requestDto properties new UsersByProject
     * @return new UsersByProject
     */
    UsersByProjectResponseDto create(UsersByProjectRequestDto requestDto);

    /**
     * update old UsersByProject new values
     * @param requestDto new values UsersByProject
     * @return UsersByProject
     */
    UsersByProjectResponseDto update(UsersByProjectRequestDto requestDto);

    /**
     * delete UsersByProject by his id
     * @param id id UsersByProject
     */
    void deleteById(Integer id);
}
