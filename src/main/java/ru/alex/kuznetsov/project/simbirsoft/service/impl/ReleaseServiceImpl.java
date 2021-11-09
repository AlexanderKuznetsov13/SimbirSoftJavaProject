package ru.alex.kuznetsov.project.simbirsoft.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.exception.NoEntityException;
import ru.alex.kuznetsov.project.simbirsoft.repository.ReleaseRepository;
import ru.alex.kuznetsov.project.simbirsoft.service.IReleaseService;
import ru.alex.kuznetsov.project.simbirsoft.util.CommonMapper;

@Service
public class ReleaseServiceImpl implements IReleaseService {

    private final ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    public ReleaseResponseDto getById(Integer id) {
        releaseRepository.findById(id).orElseThrow(() -> new NoEntityException("Release not found"));
        return CommonMapper.fromReleaseEntityToReleaseResponseDto(releaseRepository.getById(id));
    }

    @Override
    public ReleaseResponseDto create(ReleaseRequestDto requestDto) {
        return null;
    }

    @Override
    public ReleaseResponseDto update(ReleaseRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
