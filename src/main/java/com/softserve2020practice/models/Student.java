package com.softserve2020practice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "account_id")
public class Student extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "students")
    private List<StudentGroup> groupStudents;

    @OneToMany(mappedBy = "student")
    private List<Visit> studentVisit;

}
