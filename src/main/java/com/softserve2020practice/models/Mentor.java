package com.softserve2020practice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "mentor")
public class Mentor extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(mappedBy = "mentors")
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(mappedBy = "mentors")
    private Set<StudentGroup> groups = new HashSet<>();

    @OneToMany(mappedBy = "mentor")
    private Set<Lesson> lessons;

}
