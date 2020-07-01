package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Lessons")
public class Lesson {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> mentors = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private Set<StudentGroup> studentGroups = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Theme> themes = new HashSet<>();

    @Column(name = "LessonDate")
    private LocalDateTime lessonDate;

}
