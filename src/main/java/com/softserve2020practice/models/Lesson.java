package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "StudentsOfGroups",
            joinColumns = @JoinColumn(name = "IdStudent"),
            inverseJoinColumns = @JoinColumn(name = "IdStudentGroup")
    )
    private Set<Mentor> mentors = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private Set<StudentGroup> studentGroups = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private Set<Theme> themes = new HashSet<>();

    @Column(name = "LessonDate")
    private LocalDateTime lessonDate;

}
