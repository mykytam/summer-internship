package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "mentor")
@PrimaryKeyJoinColumn(name = "account_id")
public class Mentor extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "mentors")
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(mappedBy = "mentors")
    private Set<StudentGroup> groups = new HashSet<>();

    @OneToMany(mappedBy = "mentor")
    private Set<Lesson> lessons;

}
