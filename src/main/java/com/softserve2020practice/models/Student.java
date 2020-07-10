package com.softserve2020practice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SuperBuilder
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

    @ManyToMany(mappedBy = "students")
    private List<StudentGroup> groupStudents;

    @OneToMany(mappedBy = "student")
    private List<Visit> studentVisit;

    public void addStudentToGroup(StudentGroup studentGroup) {
        groupStudents.add(studentGroup);
        studentGroup.getStudents().add(this);
    }

    public void deleteForUpdate() {
        groupStudents.clear();
    }


}
