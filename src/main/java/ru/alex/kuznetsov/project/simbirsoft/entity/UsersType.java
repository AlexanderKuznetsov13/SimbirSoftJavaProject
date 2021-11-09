package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userstype")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "usersTypeUsers")
    private List<Users> users;

    @OneToMany(mappedBy = "usersTypeUsersByProject")
    private List<UsersByProject> usersByProjects;

    public UsersType(){
    }


}
