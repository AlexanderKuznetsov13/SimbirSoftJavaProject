package ru.alex.kuznetsov.project.simbirsoft.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "release")
public class ReleaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity projectRelease;

    @Column(name = "start_work_time")
    private LocalDateTime startWorkTime;

    @Column(name = "complete_work_time")
    private LocalDateTime completeWorkTime;

    @OneToMany(mappedBy = "releaseTask")
    private List<TaskEntity> tasks;


    public ReleaseEntity(){
    }

    public ReleaseEntity(Integer id, String name, ProjectEntity projectRelease, LocalDateTime startWorkTime, LocalDateTime completeWorkTime, List<TaskEntity> tasks) {
        this.id = id;
        this.name = name;
        this.projectRelease = projectRelease;
        this.startWorkTime = startWorkTime;
        this.completeWorkTime = completeWorkTime;
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

    public ProjectEntity getProjectRelease() {
        return projectRelease;
    }

    public void setProjectRelease(ProjectEntity projectRelease) {
        this.projectRelease = projectRelease;
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

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
