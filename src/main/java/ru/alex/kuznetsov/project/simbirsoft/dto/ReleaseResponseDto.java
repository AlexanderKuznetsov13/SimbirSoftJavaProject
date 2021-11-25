package ru.alex.kuznetsov.project.simbirsoft.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Date;

@Schema(description = "Релиз")
public class ReleaseResponseDto {

    @Schema(description = "ID релиза")
    private Integer id;

    @Schema(description = "Название релиза")
    private Integer name;

    @Schema(description = "ID проекта")
    private Integer projectId;

    @Schema(description = "Дата начала релиза")
    private LocalDateTime startWorkTime;

    @Schema(description = "Дата конца релиза")
    private LocalDateTime completeWorkTime;

    public ReleaseResponseDto() {
    }

    public ReleaseResponseDto(Integer id, Integer name, Integer projectId, LocalDateTime startWorkTime, LocalDateTime completeWorkTime) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.startWorkTime = startWorkTime;
        this.completeWorkTime = completeWorkTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public LocalDateTime getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(LocalDateTime startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public LocalDateTime getCompleteWorkTime() {
        return completeWorkTime;
    }

    public void setCompleteWorkTime(LocalDateTime completeWorkTime) {
        this.completeWorkTime = completeWorkTime;
    }

    @Override
    public String toString() {
        return "ReleaseRequestDto{" +
                "id=" + id +
                ", name=" + name +
                ", projectId=" + projectId +
                ", startWorkTime=" + startWorkTime +
                ", completeWorkTime=" + completeWorkTime +
                '}';
    }
}
