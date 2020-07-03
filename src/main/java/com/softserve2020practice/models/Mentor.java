package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Mentor")
public class Mentor extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "IdAccount")
    private Account idAccount;

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
