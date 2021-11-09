package ru.alex.kuznetsov.project.simbirsoft.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "projectRelease")
    private List<Release> releases;

    @OneToMany(mappedBy = "projectUsersByProject")
    private List<UsersByProject> usersByProjects;

    public Project() {
    }

    public Project(Integer id, String name, String description, List<Release> releases, List<UsersByProject> usersByProjects) {
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

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public List<UsersByProject> getUsersByProjects() {
        return usersByProjects;
    }

    public void setUsersByProjects(List<UsersByProject> usersByProjects) {
        this.usersByProjects = usersByProjects;
    }
}
