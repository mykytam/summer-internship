package com.softserve2020practice.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class MentorOfCoursesPK implements Serializable {

    @NotNull
    @Column(name = "IdCourse")
    private long courseId;

    @NotNull
    @Column(name = "IdMentor")
    private long mentorId;
}
