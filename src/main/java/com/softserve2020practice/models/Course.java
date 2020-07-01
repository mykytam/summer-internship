package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "Id")
    private Long id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdCourse", nullable = false)
    private StudentGroup studentGroup;

    @OneToMany
    @JoinTable(name = "MentorOfCourses")
    private Set<Account> accounts = new HashSet<>();
}
