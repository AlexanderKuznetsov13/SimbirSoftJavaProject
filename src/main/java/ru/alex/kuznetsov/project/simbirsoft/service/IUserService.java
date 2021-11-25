package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.UserRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserResponseDto;

import java.util.List;

public interface IUserService {
    /**
     * get all user
     * @return list user
     */
    List<UserResponseDto> getAll();

    /**
     * get user by his id
     * @param id id user
     * @return user
     */
    UserResponseDto getById(Integer id);

    /**
     * create new user
     * @param requestDto properties new user
     * @return new user
     */
    UserResponseDto create(UserRequestDto requestDto);

    /**
     * update old user new values
     * @param requestDto new values user
     * @return user
     */
    UserResponseDto update(UserRequestDto requestDto);

    /**
     * delete user by his id
     * @param id id user
     */
    void deleteById(Integer id);
}
