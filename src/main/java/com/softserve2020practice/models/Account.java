package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
