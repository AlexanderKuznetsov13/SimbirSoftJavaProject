package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.UserRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersEntity;

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
     * get UserEntity by its login
     * @param login
     * @return
     */
    UsersEntity findByLogin(String login);

    /**
     * get UserEntity by its login and password
     * @param login
     * @param password
     * @return
     */
    UsersEntity findByLoginAndPassword(String login, String password);

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
