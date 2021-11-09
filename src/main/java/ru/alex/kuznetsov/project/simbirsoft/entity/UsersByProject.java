package ru.alex.kuznetsov.project.simbirsoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usersbyproject")
public class UsersByProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users usersUsersByProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usertype_id", nullable = false)
    private UsersType usersTypeUsersByProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project projectUsersByProject;




}
