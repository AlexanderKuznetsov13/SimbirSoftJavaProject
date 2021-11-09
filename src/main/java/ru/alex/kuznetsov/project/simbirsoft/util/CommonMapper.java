package ru.alex.kuznetsov.project.simbirsoft.util;

import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseRequestDto;
import ru.alex.kuznetsov.project.simbirsoft.dto.ReleaseResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.entity.ReleaseEntity;

public class CommonMapper {

    public static ReleaseEntity fromReleaseRequestDtoToReleaseEntity(ReleaseRequestDto requestDto) {
        ReleaseEntity release = new ReleaseEntity();
        release.setId(requestDto.getId());
        release.setCompleteWorkTime(requestDto.getCompleteWorkTime());
        release.setStartWorkTime(requestDto.getStartWorkTime());
        return release;
    }

    public ReleaseResponseDto fromReleaseEntityToReleaseResponseDto(ReleaseEntity release) {
        ReleaseResponseDto responseDto = new ReleaseResponseDto();
        responseDto.setId(release.getId());
        responseDto.setStartWorkTime(release.getStartWorkTime());
        responseDto.setCompleteWorkTime(release.getCompleteWorkTime());
        responseDto.setProjectId(release.getProjectRelease().getId());
        return responseDto;
    }


}

