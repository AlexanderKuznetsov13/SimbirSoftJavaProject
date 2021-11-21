package ru.alex.kuznetsov.project.simbirsoft.entity;


import javax.persistence.*;
import java.util.List;

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
    private List<ReleaseEntity> releases;

    @OneToMany(mappedBy = "projectUsersByProject")
    private List<UsersByProjectEntity> usersByProjects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectstatus_id", nullable = false)
    private ProjectStatusEntity projectStatusProject;

    public ProjectEntity() {
    }

    public ProjectEntity(Integer id, String name, String description, List<ReleaseEntity> releases, List<UsersByProjectEntity> usersByProjects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releases = releases;
        this.usersByProjects = usersByProjects;
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

    public List<ReleaseEntity> getReleases() {
        return releases;
    }

    public void setReleases(List<ReleaseEntity> releases) {
        this.releases = releases;
    }

    public List<UsersByProjectEntity> getUsersByProjects() {
        return usersByProjects;
    }

    public void setUsersByProjects(List<UsersByProjectEntity> usersByProjects) {
        this.usersByProjects = usersByProjects;
    }
}
