package com.softserve2020practice.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MentorOfCoursesPK implements Serializable {

    @Column(name = "IdCourse")
    private long courseId;

    @Column(name = "IdMentor")
    private long mentorId;
}
