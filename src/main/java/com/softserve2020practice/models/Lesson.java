package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup studentGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @Column(name = "lesson_date")
    private LocalDateTime lessonDate;

    @OneToMany(mappedBy = "lesson")
    private Set<Visit> visits = new HashSet<>();

}
