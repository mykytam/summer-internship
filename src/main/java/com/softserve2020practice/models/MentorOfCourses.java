package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MentorsOfCourses")
public class MentorOfCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "IdCourse")
    private long courseId;

    @Column(name = "IdMentor")
    private long mentorId;

    @Column(name = "MentorComment")
    private String mentorComment;

}