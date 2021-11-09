package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usertype_id", nullable = false)
    private UsersType usersTypeUsers;

    @OneToMany(mappedBy = "usersUsersByProject")
    private List<UsersByProject> usersByProjects;

    public Users(){
    }

    public Users(Integer id, String name, String surname, String middlename, String email, String login, String password, UsersType usersTypeUsers) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.email = email;
        this.login = login;
        this.password = password;
        this.usersTypeUsers = usersTypeUsers;
    }
}
