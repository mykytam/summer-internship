package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "course")
    private Set<StudentGroup> studentGroups;

    @ManyToMany(mappedBy = "courses")
    @EqualsAndHashCode.Exclude
    private Set<Mentor> mentors = new HashSet<>();
}
