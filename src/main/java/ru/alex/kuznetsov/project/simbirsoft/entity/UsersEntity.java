package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class UsersEntity {

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

    @Column(name = "account_id")
    private Integer accountId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usertype_id", nullable = false)
    private UsersTypeEntity usersTypeUsers;

    @OneToMany(mappedBy = "usersUsersByProject")
    private Set<UsersByProjectEntity> usersByProjects;

    public UsersEntity(){
    }


    public UsersEntity(Integer id, String name, String surname, String middlename, String email, String login, String password, Integer accountId, UsersTypeEntity usersTypeUsers, Set<UsersByProjectEntity> usersByProjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.email = email;
        this.login = login;
        this.password = password;
        this.accountId = accountId;
        this.usersTypeUsers = usersTypeUsers;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersTypeEntity getUsersTypeUsers() {
        return usersTypeUsers;
    }

    public void setUsersTypeUsers(UsersTypeEntity usersTypeUsers) {
        this.usersTypeUsers = usersTypeUsers;
    }

    public Set<UsersByProjectEntity> getUsersByProjects() {
        return usersByProjects;
    }

    public void setUsersByProjects(Set<UsersByProjectEntity> usersByProjects) {
        this.usersByProjects = usersByProjects;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
