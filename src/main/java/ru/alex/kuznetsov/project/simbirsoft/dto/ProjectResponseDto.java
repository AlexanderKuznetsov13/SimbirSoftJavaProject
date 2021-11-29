package ru.alex.kuznetsov.project.simbirsoft.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectResponseDto {

    @Schema(description = "ID проекта")
    private Integer id;

    @Schema(description = "Название проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private String description;

    @Schema(description = "ID статуса проекта")
    private Integer projectStatusId;

    public ProjectResponseDto() {
    }

    public ProjectResponseDto(Integer id, String name, String description, Integer projectStatusId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projectStatusId = projectStatusId;
    }

    public Integer getProjectStatusId() {
        return projectStatusId;
    }

    public void setProjectStatusId(Integer projectStatusId) {
        this.projectStatusId = projectStatusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProjectRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", projectStatusId=" + projectStatusId +
                '}';
    }
}
