package ru.alex.kuznetsov.project.simbirsoft.service;

import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;

public interface IReleaseService {

    /**
     * get release by  id
     * @param id id release
     * @return release
     */
    ReleaseResponseDto getById(Integer id);

    /**
     * create new release
     * @param requestDto properties new release
     * @return new release
     */
    ReleaseResponseDto create(ReleaseRequestDto requestDto);

    /**
     * update old release
     * @param requestDto new release
     * @return release
     */
    ReleaseResponseDto update(ReleaseRequestDto requestDto);

    /**
     * delete release by id
     * @param id id release
     */
    void deleteById(Integer id);
}
