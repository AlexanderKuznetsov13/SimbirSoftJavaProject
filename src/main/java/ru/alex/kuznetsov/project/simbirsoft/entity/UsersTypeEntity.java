package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userstype")
public class UsersTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "usersTypeUsers")
    private List<UsersEntity> users;

    @OneToMany(mappedBy = "usersTypeUsersByProject")
    private List<UsersByProjectEntity> usersByProjects;

    public UsersTypeEntity(){
    }

    public UsersTypeEntity(Integer id, String name, String description, List<UsersEntity> users, List<UsersByProjectEntity> usersByProjects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
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

    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }

    public List<UsersByProjectEntity> getUsersByProjects() {
        return usersByProjects;
    }

    public void setUsersByProjects(List<UsersByProjectEntity> usersByProjects) {
        this.usersByProjects = usersByProjects;
    }
}
