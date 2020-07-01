package com.softserve2020practice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "MentorsOfCourses")
@NoArgsConstructor
@AllArgsConstructor
public class MentorOfCourses implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdCourse")
    private Course course;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMentor")
    private Mentor mentorAccount;

    @Column(name = "MentorComment")
    private String mentorComment;
}