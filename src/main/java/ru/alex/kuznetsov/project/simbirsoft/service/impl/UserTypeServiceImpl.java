package ru.alex.kuznetsov.project.simbirsoft.service.impl;


import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ReleaseRepository;
import ru.alex.kuznetsov.project.simbirsoft.repository.UsersTypeRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserTypeService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;

@Service
public class UserTypeServiceImpl implements IUserTypeService {

    private final UsersTypeRepository usersTypeRepository;

    public UserTypeServiceImpl(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }


    @Override
    public UserTypeResponseDto getById(Integer id) {
        usersTypeRepository.findById(id).orElseThrow(() -> new NoEntityException("UserType not found"));
        return CommonMapper.fromUsersTypeEntityToUserTypeResponseDto(usersTypeRepository.getById(id));
    }


    @Override
    public UserTypeResponseDto create(UserTypeRequestDto requestDto) {
        return null;
    }

    @Override
    public UserTypeResponseDto update(UserTypeRequestDto requestDto) {
        return null;
    }

    @Override
    public List<UserTypeResponseDto> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
