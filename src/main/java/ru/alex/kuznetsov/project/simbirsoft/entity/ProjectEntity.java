package ru.alex.kuznetsov.project.simbirsoft.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "projectRelease")
    private Set<ReleaseEntity> releases;

    @OneToMany(mappedBy = "projectUsersByProject")
    private Set<UsersByProjectEntity> usersByProjects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectstatus_id", nullable = false)
    private ProjectStatusEntity projectStatusProject;

    public ProjectEntity() {
    }

    public ProjectEntity(Integer id, String name, String description, Set<ReleaseEntity> releases, Set<UsersByProjectEntity> usersByProjects, ProjectStatusEntity projectStatusProject) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releases = releases;
        this.usersByProjects = usersByProjects;
        this.projectStatusProject = projectStatusProject;
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

    public Set<ReleaseEntity> getReleases() {
        return releases;
    }

    public void setReleases(Set<ReleaseEntity> releases) {
        this.releases = releases;
    }

    public Set<UsersByProjectEntity> getUsersByProjects() {
        return usersByProjects;
    }

    public void setUsersByProjects(Set<UsersByProjectEntity> usersByProjects) {
        this.usersByProjects = usersByProjects;
    }

    public ProjectStatusEntity getProjectStatusProject() {
        return projectStatusProject;
    }

    public void setProjectStatusProject(ProjectStatusEntity projectStatusProject) {
        this.projectStatusProject = projectStatusProject;
    }
}
