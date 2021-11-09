package ru.alex.kuznetsov.project.simbirsoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
public class BoardTaskRequestDto {

    @Schema(description = "Идентификатор задачи")
    private Integer id;

    @Schema(description = "Краткое описание задачи")
    private String title;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Статус задачи")
    private Integer taskStatus;

    @Schema(description = "ID релиза")
    private Integer releaseId;

    @Schema(description = "Автор задачи")
    private Integer authorId;

    @Schema(description = "Исполнитель задачи")
    private Integer contractorId;

    public BoardTaskRequestDto() {
    }

    public BoardTaskRequestDto(Integer id, String title, String description, Integer taskStatus, Integer releaseId, Integer authorId, Integer contractorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.releaseId = releaseId;
        this.authorId = authorId;
        this.contractorId = contractorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getContractorId() {
        return contractorId;
    }

    public void setContractorId(Integer contractorId) {
        this.contractorId = contractorId;
    }
}
