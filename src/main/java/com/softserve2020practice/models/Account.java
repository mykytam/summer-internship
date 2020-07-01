package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @OneToMany(
            mappedBy = "mentorAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    private Set<MentorOfCourses> courses = new HashSet<>();

    @OneToMany(
            mappedBy = "mentorAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    private Set<MentorsOfStudentGroup> groups = new HashSet<>();

    public void addCourse(Course course, String comment) {
        MentorOfCourses mentorCourses = new MentorOfCourses(course, this, comment);
        courses.add(mentorCourses);
        course.getMentors().add(mentorCourses);
    }

}
