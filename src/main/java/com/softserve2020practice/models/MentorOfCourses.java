package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "MentorsOfCourses")
public class MentorOfCourses implements Serializable {

    @EmbeddedId
    @NotNull
    private MentorOfCoursesPK id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "IdCourse")
    private Course course;

    @ManyToOne
    @MapsId("mentorId")
    @JoinColumn(name = "IdMentor")
    private Account mentorAccount;

    @Column(name = "MentorComment")
    private String mentorComment;

}