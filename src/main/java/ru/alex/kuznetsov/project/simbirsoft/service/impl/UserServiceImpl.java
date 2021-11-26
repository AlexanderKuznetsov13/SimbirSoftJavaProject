package ru.alex.kuznetsov.project.simbirsoft.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UserResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.UsersRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IUserService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto getById(Integer id) {
        logger.debug(String.format("getById - get user with %id", id));
        usersRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("User with ID = %d not found", id)));
        return CommonMapper.fromUserEntityToUserResponseDto(usersRepository.getById(id));
    }

    @Override
    public UserResponseDto create(UserRequestDto requestDto){
        logger.debug(String.format("create - create user"));
        UsersEntity users = CommonMapper.fromUsersRequestDtoToUsersEntity(requestDto);
        return CommonMapper.fromUserEntityToUserResponseDto(usersRepository.save(users));
    }

    @Override
    public UserResponseDto update(UserRequestDto requestDto) {
        UsersEntity users = CommonMapper.fromUsersRequestDtoToUsersEntity(requestDto);
        logger.debug(String.format("update - update user with %id", users.getId()));
        return CommonMapper.fromUserEntityToUserResponseDto(usersRepository.save(users));
    }

    @Override
    public List<UserResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all users"));
        return usersRepository.findAll().stream().map(CommonMapper::fromUserEntityToUserResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        usersRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - User with ID = %d not found", id));
            return new NoEntityException(String.format("User with ID = %d not found", id));
        });
        usersRepository.deleteById(id);
    }

    public UsersEntity findByLogin(String login) {
        return usersRepository.findUsersEntitiesByLogin(login);
    }

    public UsersEntity findByLoginAndPassword(String login, String password) {
        UsersEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
