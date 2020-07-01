package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "Id")
    private long id;

    @NotNull
    @Column(name = "Role")
    private byte role;

    @NotBlank
    @Column(name = "FirstName")
    private String firstName;

    @NotBlank
    @Column(name = "LastName")
    private String lastName;

    @NotBlank
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Column(name = "Password")
    private String password;

    @NotBlank
    @Column(name = "Salt")
    private String salt;

    @Column(name = "Active")
    private boolean active;

    @OneToMany(mappedBy = "mentorAccount")
    private Set<MentorOfCourses> studentGroupSet = new HashSet<>();

    @OneToMany
    @JoinTable(name = "MentorOfCourses")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "mentor")
    private Set<MentorsOfStudentGroup> mentors = new HashSet<>();

}
