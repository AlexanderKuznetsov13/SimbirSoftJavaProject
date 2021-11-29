package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.UsersByProjectEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.UsersByProjectRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IUsersByProjectService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersByProjectServiceImpl implements IUsersByProjectService {

    private final Logger logger = LoggerFactory.getLogger(UsersByProjectServiceImpl.class);

    private final UsersByProjectRepository usersByProjectRepository;

    public UsersByProjectServiceImpl(UsersByProjectRepository usersByProjectRepository) {
        this.usersByProjectRepository = usersByProjectRepository;
    }

    @Override
    public UsersByProjectResponseDto getById(Integer id) {
        logger.debug(String.format("getById - get task with %id",id));
        UsersByProjectEntity usersByProject = usersByProjectRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("userByProject with ID = %d not found", id)));
        return CommonMapper.fromUsersByProjectEntityToUserByProjectResponseDto(usersByProject);
    }

    @Override
    public UsersByProjectResponseDto create(UsersByProjectRequestDto requestDto) {
        logger.debug(String.format("create - create userByProject"));
        UsersByProjectEntity usersByProject = CommonMapper.fromUsersByProjectRequestDtoToUsersByProjectEntity(requestDto);
        return CommonMapper.fromUsersByProjectEntityToUserByProjectResponseDto(usersByProjectRepository.save(usersByProject));
    }

    @Override
    public UsersByProjectResponseDto update(UsersByProjectRequestDto requestDto) {
        UsersByProjectEntity usersByProject = CommonMapper.fromUsersByProjectRequestDtoToUsersByProjectEntity(requestDto);
        logger.debug(String.format("update - update userByProject with %id", usersByProject.getId()));
        return CommonMapper.fromUsersByProjectEntityToUserByProjectResponseDto(usersByProjectRepository.save(usersByProject));
    }

    @Override
    public List<UsersByProjectResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all userByProject"));
        return usersByProjectRepository.findAll().stream().map(CommonMapper::fromUsersByProjectEntityToUserByProjectResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        usersByProjectRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - UserByProject with ID = %d not found", id));
            return new NoEntityException(String.format("UserByProject with ID = %d not found", id));
        });
        usersByProjectRepository.deleteById(id);
    }
}
