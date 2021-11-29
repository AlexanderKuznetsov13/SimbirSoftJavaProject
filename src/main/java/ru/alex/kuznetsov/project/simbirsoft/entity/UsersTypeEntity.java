package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.Set;

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
    private Set<UsersEntity> users;

    @OneToMany(mappedBy = "usersTypeUsersByProject")
    private Set<UsersByProjectEntity> usersByProjects;

    public UsersTypeEntity(){
    }

    public UsersTypeEntity(Integer id, String name, String description, Set<UsersEntity> users, Set<UsersByProjectEntity> usersByProjects) {
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

    public Set<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UsersEntity> users) {
        this.users = users;
    }

    public Set<UsersByProjectEntity> getUsersByProjects() {
        return usersByProjects;
    }

    public void setUsersByProjects(Set<UsersByProjectEntity> usersByProjects) {
        this.usersByProjects = usersByProjects;
    }
}
