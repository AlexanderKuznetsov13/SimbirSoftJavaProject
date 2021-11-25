package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.ReleaseEntity;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ReleaseRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IReleaseService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleaseServiceImpl implements IReleaseService {

    private final ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    public ReleaseResponseDto getById(Integer id) {
        System.out.println(String.format("getById - get release with %id", id));
        releaseRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Release with ID = %d not found", id)));
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.getById(id));
    }

    @Override
    public ReleaseResponseDto create(ReleaseRequestDto requestDto) {
        System.out.println(String.format("create - create release"));
        ReleaseEntity release = CommonMapper.fromReleaseRequestDtoToReleaseEntity(requestDto);
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.save(release));
    }

    @Override
    public ReleaseResponseDto update(ReleaseRequestDto requestDto) {
        ReleaseEntity release = CommonMapper.fromReleaseRequestDtoToReleaseEntity(requestDto);
        System.out.println(String.format("update - update release with %id", release.getId()));
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.save(release));
    }

    @Override
    public void deleteById(Integer id) {
        releaseRepository.findById(id).orElseThrow(() -> {
            System.out.println(String.format("deleteById - Release with ID = %d not found", id));
            return new NoEntityException(String.format("Release with ID = %d not found", id));
        });
        releaseRepository.deleteById(id);
    }

    @Override
    public List<ReleaseResponseDto> getAll() {
        System.out.println(String.format("getAll - retrieve all releases"));
        return releaseRepository.findAll().stream().map(CommonMapper::fromReleaseEntityToReleaseResponseDto).collect(Collectors.toList());
    }
}

