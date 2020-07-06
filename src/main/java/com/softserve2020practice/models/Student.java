package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class Student extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private Account idAccount;

    @ManyToMany(mappedBy = "students")
    private List<StudentGroup> groupStudents;

    @OneToMany(mappedBy = "student")
    private List<Visit> studentVisit;

}
