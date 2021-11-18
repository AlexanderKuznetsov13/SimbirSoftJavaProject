package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeResponseDto;

import java.util.List;

public interface IUserTypeService {
    /**
     * get all UserType
     * @return list UserType
     */
    List<UserTypeResponseDto> getAll();

    /**
     * get UserType by his id
     * @param id id UserType
     * @return UserType
     */
    UserTypeResponseDto getById(Integer id);

    /**
     * create new UserType
     * @param requestDto properties new UserType
     * @return new UserType
     */
    UserTypeResponseDto create(UserTypeRequestDto requestDto);

    /**
     * update old UserType new values
     * @param requestDto new values UserType
     * @return UserType
     */
    UserTypeResponseDto update(UserTypeRequestDto requestDto);

    /**
     * delete UserType by his id
     * @param id id UserType
     */
    void deleteById(Integer id);
}

