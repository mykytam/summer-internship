package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "Role")
    private byte role;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Salt")
    private String salt;

    @Column(name = "Active")
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "StudentsOfGroups")
    private Set<StudentGroup> studentGroupSet = new HashSet<>();

    @OneToMany
    @JoinTable(name = "MentorOfCourses")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "mentor")
    private Set<MentorsOfStudentGroup> mentors = new HashSet<>();

}
