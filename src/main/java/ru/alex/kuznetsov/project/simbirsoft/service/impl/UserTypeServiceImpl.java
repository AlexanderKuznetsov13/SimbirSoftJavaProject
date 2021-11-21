package ru.alex.kuznetsov.project.simbirsoft.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserTypeResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersTypeEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.UsersTypeRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserTypeService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTypeServiceImpl implements IUserTypeService {

    private final Logger logger = LoggerFactory.getLogger(UserTypeServiceImpl.class);


    private final UsersTypeRepository usersTypeRepository;

    public UserTypeServiceImpl(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    @Override
    public UserTypeResponseDto getById(Integer id) {
        logger.debug(String.format("getById - get userType with %id", id));
        usersTypeRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("UserType with ID = %d not found", id)));
        return CommonMapper.fromUsersTypeEntityToUserTypeResponseDto(usersTypeRepository.getById(id));
    }

    @Override
    public UserTypeResponseDto create(UserTypeRequestDto requestDto){
        logger.debug(String.format("create - create userType"));
        UsersTypeEntity usersType = CommonMapper.fromUserTypeRequestDtoToUsersTypeEntity(requestDto);
        return CommonMapper.fromUsersTypeEntityToUserTypeResponseDto(usersTypeRepository.save(usersType));
    }

    @Override
    public UserTypeResponseDto update(UserTypeRequestDto requestDto) {
        UsersTypeEntity usersType = CommonMapper.fromUserTypeRequestDtoToUsersTypeEntity(requestDto);
        logger.debug(String.format("update - update userType with %id", usersType.getId()));
        return CommonMapper.fromUsersTypeEntityToUserTypeResponseDto(usersTypeRepository.save(usersType));
    }

    @Override
    public List<UserTypeResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all usersType"));
        return usersTypeRepository.findAll().stream().map(CommonMapper::fromUsersTypeEntityToUserTypeResponseDto).collect(Collectors.toList());
    }


    @Override
    public void deleteById(Integer id) {
        usersTypeRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - UserType with ID = %d not found", id));
            return new NoEntityException(String.format("UserType with ID = %d not found", id));
        });
        usersTypeRepository.deleteById(id);
    }
}
