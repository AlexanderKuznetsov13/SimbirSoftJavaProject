package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "taskstatus")
public class TaskStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "taskStatusTask")
    private List<TaskEntity> tasks;

    public TaskStatusEntity(){
    }

    public TaskStatusEntity(Integer id, String name, List<TaskEntity> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
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

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
