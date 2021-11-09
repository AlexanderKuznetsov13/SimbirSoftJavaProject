package ru.alex.kuznetsov.project.simbirsoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь проекта")
public class UsersByProjectResponseDto {

    @Schema(description = "ID  пользователя проекта")
    private int id;

    @Schema(description = "ID  пользователя")
    private int userId;

    @Schema(description = "ID  типа пользователя")
    private int usertypeId;

    @Schema(description = "ID  проекта")
    private int projectId;

    public UsersByProjectResponseDto() {
    }

    public UsersByProjectResponseDto(int id, int userId, int usertypeId, int projectId) {
        this.id = id;
        this.userId = userId;
        this.usertypeId = usertypeId;
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "UsersByProjectRequest{" +
                "id=" + id +
                ", userId=" + userId +
                ", usertypeId=" + usertypeId +
                ", projectId=" + projectId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUsertypeId() {
        return usertypeId;
    }

    public void setUsertypeId(int usertypeId) {
        this.usertypeId = usertypeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }


}
