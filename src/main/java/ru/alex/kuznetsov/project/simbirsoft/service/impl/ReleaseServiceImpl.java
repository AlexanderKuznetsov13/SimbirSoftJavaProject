package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.ReleaseEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ReleaseRepository;
import ru.alex.kuznetsov.project.simbirsoft.repository.TaskRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IReleaseService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleaseServiceImpl implements IReleaseService {

    private final static Logger logger = LoggerFactory.getLogger(ReleaseServiceImpl.class);

    private final ReleaseRepository releaseRepository;
    private final TaskRepository taskRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository, TaskRepository taskRepository) {
        this.releaseRepository = releaseRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public ReleaseResponseDto getById(Integer id) {
        logger.error(String.format("getById - get release with %id", id));
        releaseRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Release with ID = %d not found", id)));
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.getById(id));
    }

    @Override
    public ReleaseResponseDto create(ReleaseRequestDto requestDto) {
        logger.error(String.format("create - create release"));
        ReleaseEntity release = CommonMapper.fromReleaseRequestDtoToReleaseEntity(requestDto);
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.save(release));
    }

    @Override
    public ReleaseResponseDto update(ReleaseRequestDto requestDto) {
        ReleaseEntity release = CommonMapper.fromReleaseRequestDtoToReleaseEntity(requestDto);
        logger.error(String.format("update - update release with %id", release.getId()));
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.save(release));
    }

    @Override
    public void deleteById(Integer id) {
        releaseRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("deleteById - Release with ID = %d not found", id));
            return new NoEntityException(String.format("Release with ID = %d not found", id));
        });
        releaseRepository.deleteById(id);
    }

    @Override
    public List<ReleaseResponseDto> getAll() {
        logger.error(String.format("getAll - retrieve all releases"));
        return releaseRepository.findAll().stream().map(CommonMapper::fromReleaseEntityToReleaseResponseDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer getQtyUncompletedTasksById(Integer id) {
    ReleaseEntity release = releaseRepository.findById(id).orElseThrow(() -> {
        logger.error(String.format("getQtyUncompletedTasksById - Release with ID = %d not found", id));
        return new NoEntityException(String.format("Release with %d not found", id));
        });
        if (release.getCompleteWorkTime().compareTo(LocalDateTime.now()) >= 0) {
        return 0;
        }
        return taskRepository.getQtyUncompletedTasksByReleaseId(id);
    }


}

