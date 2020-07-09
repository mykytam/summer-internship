package com.softserve2020practice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id")
    private Account idAccount;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<StudentGroup> groupStudents;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Visit> studentVisit;

}
