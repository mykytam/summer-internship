package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "Visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IdStudent")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "IdLesson")
    private Lesson lessons;

    @NotNull
    @Column(name = "StudentMark")
    private byte studentMark;

    @Column(name = "Presence")
    private boolean presence;

    @NotBlank
    @Column(name = "Comments")
    private String comment;

}
