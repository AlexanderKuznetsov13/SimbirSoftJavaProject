package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.UsersByProjectResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ReleaseRepository;
import ru.alex.kuznetsov.project.simbirsoft.repository.UsersByProjectRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IUsersByProjectService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;

@Service
public class UsersByProjectServiceImpl implements IUsersByProjectService {

    private final UsersByProjectRepository usersByProjectRepository;

    public UsersByProjectServiceImpl(UsersByProjectRepository usersByProjectRepository) {
        this.usersByProjectRepository = usersByProjectRepository;
    }

    @Override
    public UsersByProjectResponseDto getById(Integer id) {
        usersByProjectRepository.findById(id).orElseThrow(() -> new NoEntityException("usersByProject not found"));
        return CommonMapper.fromUsersByProjectEntityToUserByProjectResponseDto(usersByProjectRepository.getById(id));
    }

    @Override
    public UsersByProjectResponseDto create(UsersByProjectRequestDto requestDto) {
        return null;
    }

    @Override
    public UsersByProjectResponseDto update(UsersByProjectRequestDto requestDto) {
        return null;
    }

    @Override
    public List<UsersByProjectResponseDto> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
