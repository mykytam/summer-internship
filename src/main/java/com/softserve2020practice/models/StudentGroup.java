package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "StudentGroups")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @OneToMany(mappedBy = "course") //studentCourse
    private Set<Course> courses = new HashSet<>();

    @Column(name = "Name")
    private String name;

    @Column(name = "StartDate")
    private LocalDate startDate;

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
    private Set<Account> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdStudentGroup", nullable = false)
    private Lesson lesson;

}
