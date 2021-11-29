package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usersbyproject")
public class UsersByProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private UsersEntity usersUsersByProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usertype_id", nullable = false)
    private UsersTypeEntity usersTypeUsersByProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity projectUsersByProject;

    @OneToMany(mappedBy = "authorUsersByProjectTask")
    private Set<TaskEntity> authorTasks;

    @OneToMany(mappedBy = "contractorUsersByProjectTask")
    private Set<TaskEntity> contractorTasks;

    public UsersByProjectEntity() {
    }

    public UsersByProjectEntity(Integer id, UsersEntity usersUsersByProject, UsersTypeEntity usersTypeUsersByProject, ProjectEntity projectUsersByProject, Set<TaskEntity> authorTasks, Set<TaskEntity> contractorTasks) {
        this.id = id;
        this.usersUsersByProject = usersUsersByProject;
        this.usersTypeUsersByProject = usersTypeUsersByProject;
        this.projectUsersByProject = projectUsersByProject;
        this.authorTasks = authorTasks;
        this.contractorTasks = contractorTasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsersEntity getUsersUsersByProject() {
        return usersUsersByProject;
    }

    public void setUsersUsersByProject(UsersEntity usersUsersByProject) {
        this.usersUsersByProject = usersUsersByProject;
    }

    public UsersTypeEntity getUsersTypeUsersByProject() {
        return usersTypeUsersByProject;
    }

    public void setUsersTypeUsersByProject(UsersTypeEntity usersTypeUsersByProject) {
        this.usersTypeUsersByProject = usersTypeUsersByProject;
    }

    public ProjectEntity getProjectUsersByProject() {
        return projectUsersByProject;
    }

    public void setProjectUsersByProject(ProjectEntity projectUsersByProject) {
        this.projectUsersByProject = projectUsersByProject;
    }

    public Set<TaskEntity> getAuthorTasks() {
        return authorTasks;
    }

    public void setAuthorTasks(Set<TaskEntity> authorTasks) {
        this.authorTasks = authorTasks;
    }

    public Set<TaskEntity> getContractorTasks() {
        return contractorTasks;
    }

    public void setContractorTasks(Set<TaskEntity> contractorTasks) {
        this.contractorTasks = contractorTasks;
    }
}
