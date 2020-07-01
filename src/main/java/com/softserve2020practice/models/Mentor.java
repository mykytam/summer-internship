package com.softserve2020practice.models;

import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static com.softserve2020practice.models.enums.Role.Constants.MENTOR_VALUE;

@Entity
@DiscriminatorValue(MENTOR_VALUE)
public class Mentor extends Account {

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
