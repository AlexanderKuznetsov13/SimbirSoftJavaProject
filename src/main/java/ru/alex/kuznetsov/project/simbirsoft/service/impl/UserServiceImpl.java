package ru.alex.kuznetsov.project.simbirsoft.service.impl;


import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.UsersRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserResponseDto getById(Integer id) {
        usersRepository.findById(id).orElseThrow(() -> new NoEntityException("User not found"));
        return CommonMapper.fromUserEntityToUserResponseDto(usersRepository.getById(id));
    }

    @Override
    public UserResponseDto create(UserRequestDto requestDto) {
        return null;
    }

    @Override
    public UserResponseDto update(UserRequestDto requestDto) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
