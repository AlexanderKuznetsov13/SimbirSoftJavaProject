package ru.alex.kuznetsov.project.simbirsoft.util;

import ru.alex.kuznetsov.project.simbirsoft.dto.*;
import ru.alex.kuznetsov.project.simbirsoft.entity.*;

public class CommonMapper {

    public static ReleaseEntity fromReleaseRequestDtoToReleaseEntity(ReleaseRequestDto requestDto) {
        ReleaseEntity release = new ReleaseEntity();
        release.setId(requestDto.getId());
        release.setCompleteWorkTime(requestDto.getCompleteWorkTime());
        release.setStartWorkTime(requestDto.getStartWorkTime());
        return release;
    }

    public static ReleaseResponseDto fromReleaseEntityToReleaseResponseDto(ReleaseEntity release) {
        ReleaseResponseDto responseDto = new ReleaseResponseDto();
        responseDto.setId(release.getId());
        responseDto.setStartWorkTime(release.getStartWorkTime());
        responseDto.setCompleteWorkTime(release.getCompleteWorkTime());
        responseDto.setProjectId(release.getProjectRelease().getId());
        return responseDto;
    }

    public static ProjectEntity fromProjectRequestDtoToProjectEntity(ProjectRequestDto requestDto) {
        ProjectEntity project = new ProjectEntity();
        project.setId(requestDto.getId());
        project.setName(requestDto.getName());
        project.setDescription(requestDto.getDescription());
        return project;
    }

    public static ProjectResponseDto fromProjectEntityToProjectResponseDto(ProjectEntity project) {
        ProjectResponseDto responseDto = new ProjectResponseDto();
        responseDto.setId(project.getId());
        responseDto.setName(project.getName());
        responseDto.setDescription(project.getDescription());
        return responseDto;
    }

    public static TaskStatusEntity fromTaskStasusRequestDtoToTaskStatusEntity(TaskStatusRequestDto requestDto) {
        TaskStatusEntity taskStatus = new TaskStatusEntity();
        taskStatus.setId(requestDto.getId());
        taskStatus.setName(requestDto.getName());
        return taskStatus;
    }

    public static TaskStatusResponseDto fromTaskStatusEntityToTaskStatusResponseDto(TaskStatusEntity taskStatus) {
        TaskStatusResponseDto responseDto = new TaskStatusResponseDto();
        responseDto.setId(taskStatus.getId());
        responseDto.setName(taskStatus.getName());
        return responseDto;
    }

    public static UsersTypeEntity fromUserTypeRequestDtoToUsersTypeEntity(UserTypeRequestDto requestDto) {
        UsersTypeEntity usersType = new UsersTypeEntity();
        usersType.setId(requestDto.getId());
        usersType.setName(requestDto.getName());
        usersType.setDescription(requestDto.getDescription());
        return usersType;
    }

    public static UserTypeResponseDto fromUsersTypeEntityToUserTypeResponseDto(UsersTypeEntity usersType) {
        UserTypeResponseDto responseDto = new UserTypeResponseDto();
        responseDto.setId(usersType.getId());
        responseDto.setName(usersType.getName());
        responseDto.setDescription(usersType.getDescription());

        return responseDto;
    }

    public static UsersEntity fromUsersRequestDtoToUsersEntity(UserRequestDto requestDto) {
        UsersEntity user = new UsersEntity();
        user.setId(requestDto.getId());
        user.setName(requestDto.getName());
        user.setSurname(requestDto.getSurname());
        user.setMiddlename(requestDto.getMiddlename());
        user.setLogin(requestDto.getNickname());
        user.setPassword(requestDto.getPassword());
        return user;
    }

    public static UserResponseDto fromUserEntityToUserResponseDto(UsersEntity usersType) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(usersType.getId());
        responseDto.setName(usersType.getName());
        responseDto.setSurname(usersType.getSurname());
        responseDto.setMiddlename(usersType.getMiddlename());
        responseDto.setNickname(usersType.getLogin());
        responseDto.setPassword(usersType.getPassword());
        responseDto.setUserTypeId(usersType.getUsersTypeUsers().getId());
        return responseDto;

    }

    public static UsersByProjectEntity fromUsersByProjectRequestDtoToUsersByProjectEntity(UsersByProjectRequestDto requestDto) {
        UsersByProjectEntity usersByProject = new UsersByProjectEntity();
        usersByProject.setId(requestDto.getId());
        return usersByProject;
    }

    public static UsersByProjectResponseDto fromUsersByProjectEntityToUserByProjectResponseDto(UsersByProjectEntity usersByProject) {
        UsersByProjectResponseDto responseDto = new UsersByProjectResponseDto();
        responseDto.setId(usersByProject.getId());
        responseDto.setUserId(usersByProject.getUsersUsersByProject().getId());
        responseDto.setUsertypeId(usersByProject.getUsersTypeUsersByProject().getId());
        responseDto.setProjectId(usersByProject.getProjectUsersByProject().getId());

        return responseDto;

    }

    public static TaskEntity fromTaskRequestDtoToTaskEntity(BoardTaskRequestDto requestDto) {
        TaskEntity task = new TaskEntity();
        task.setId(requestDto.getId());
        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        return task;
    }

    public static BoardTaskResponseDto fromTaskEntityToBoardTaskResponseDto(TaskEntity task) {
        BoardTaskResponseDto responseDto = new BoardTaskResponseDto();
        responseDto.setId(task.getId());
        responseDto.setAuthorId(task.getAuthorUsersByProjectTask().getId());
        responseDto.setContractorId(task.getContractorUsersByProjectTask().getId());
        responseDto.setReleaseId(task.getReleaseTask().getId());
        responseDto.setTaskStatus(task.getTaskStatusTask().getId());

        return responseDto;

    }
}

