package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "taskstatus")
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    public TaskStatus(){

    }

    public TaskStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
