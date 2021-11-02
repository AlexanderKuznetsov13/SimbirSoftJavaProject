package ru.alex.kuznetsov.project.simbirsoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Статус задач")
public class TaskStatusRequestDto {

    @Schema(description = "ID статуса")
    private int id;

    @Schema(description = "Название статуса")
    private String name;

    public TaskStatusRequestDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TaskStatusRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaskStatusRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
