package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;

@Entity
@Table(name="task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskstatus_id", nullable = false)
    private TaskStatusEntity taskStatusTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id", nullable = false)
    private ReleaseEntity releaseTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private UsersByProjectEntity authorUsersByProjectTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", nullable = false)
    private UsersByProjectEntity contractorUsersByProjectTask;

    public TaskEntity() {
    }

    public TaskEntity(Integer id, String title, String description, TaskStatusEntity taskStatusTask, ReleaseEntity releaseTask, UsersByProjectEntity authorUsersByProjectTask, UsersByProjectEntity contractorUsersByProjectTask) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskStatusTask = taskStatusTask;
        this.releaseTask = releaseTask;
        this.authorUsersByProjectTask = authorUsersByProjectTask;
        this.contractorUsersByProjectTask = contractorUsersByProjectTask;
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

    public TaskStatusEntity getTaskStatusTask() {
        return taskStatusTask;
    }

    public void setTaskStatusTask(TaskStatusEntity taskStatusTask) {
        this.taskStatusTask = taskStatusTask;
    }

    public ReleaseEntity getReleaseTask() {
        return releaseTask;
    }

    public void setReleaseTask(ReleaseEntity releaseTask) {
        this.releaseTask = releaseTask;
    }

    public UsersByProjectEntity getAuthorUsersByProjectTask() {
        return authorUsersByProjectTask;
    }

    public void setAuthorUsersByProjectTask(UsersByProjectEntity authorUsersByProjectTask) {
        this.authorUsersByProjectTask = authorUsersByProjectTask;
    }

    public UsersByProjectEntity getContractorUsersByProjectTask() {
        return contractorUsersByProjectTask;
    }

    public void setContractorUsersByProjectTask(UsersByProjectEntity contractorUsersByProjectTask) {
        this.contractorUsersByProjectTask = contractorUsersByProjectTask;
    }
}
