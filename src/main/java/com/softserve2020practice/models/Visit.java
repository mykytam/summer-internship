package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "IdStudent")
    @ManyToOne
    private Account student;

    @Column(name = "IdLesson")
    @OneToMany
    private Set<Lesson> lessons = new HashSet<>();

    @Column(name = "StudentMark")
    private byte studentMark;

    @Column(name = "Presence")
    private boolean presence;

    @Column(name = "Comments")
    private String comment;

}
