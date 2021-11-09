package ru.alex.kuznetsov.project.simbirsoft.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "release")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project projectRelease;

    @Column(name = "start_work_time")
    private LocalDateTime startWorkTime;

    @Column(name = "complete_work_time")
    private LocalDateTime completeWork_time;


}
