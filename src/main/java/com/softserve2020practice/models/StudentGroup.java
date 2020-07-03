package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "StudentGroups")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToMany(mappedBy = "studentGroup")
    private Set<Course> courses = new HashSet<>();

    @NotBlank
    @Column(name = "Name")
    private String name;

    @NotEmpty
    @Column(name = "StartDate")
    private LocalDate startDate;

    @NotEmpty
    @Column(name = "FinishDate")
    private LocalDate finishDate;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "StudentsOfGroups",
            joinColumns = @JoinColumn(name = "IdStudent"),
            inverseJoinColumns = @JoinColumn(name = "IdStudentGroup")
    )
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdStudentGroup", nullable = false)
    private Lesson lesson;

    @OneToMany(
            mappedBy = "studentGroup",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    private Set<MentorsOfStudentGroup> mentors = new HashSet<>();

}
