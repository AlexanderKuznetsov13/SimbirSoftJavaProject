package ru.alex.kuznetsov.project.simbirsoft.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projectstatus")
public class ProjectStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "projectStatusProject")
    private Set<ProjectEntity> projects;


    public ProjectStatusEntity() {
    }

    public ProjectStatusEntity(Integer id, String name, Set<ProjectEntity> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
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

    public Set<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
    }
}
