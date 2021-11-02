package ru.alex.kuznetsov.project.simbirsoft.dto;


import io.swagger.v3.oas.annotations.media.Schema;

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
    private Date dateStart;

    @Schema(description = "Дата конца релиза")
    private Date dateEnd;

    public ReleaseResponseDto() {
    }

    public ReleaseResponseDto(Integer id, Integer name, Integer projectId, Date dateStart, Date dateEnd) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "ReleaseRequestDto{" +
                "id=" + id +
                ", name=" + name +
                ", projectId=" + projectId +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
