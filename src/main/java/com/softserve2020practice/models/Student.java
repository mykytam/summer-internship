package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Student")
public class Student extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "IdAccount")
    private Account idAccount;

    @ManyToMany
    @JoinTable(name = "StudentsOfGroups",
            joinColumns = @JoinColumn(name = "IdStudent"),
            inverseJoinColumns = @JoinColumn(name = "Id"))
    private List<StudentGroup> groupStudents;

    @OneToMany(mappedBy = "student")
    private List<Visit> studentVisit;

}
