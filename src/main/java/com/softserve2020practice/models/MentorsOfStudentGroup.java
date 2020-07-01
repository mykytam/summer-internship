package com.softserve2020practice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "MentorsOfStudentGroups")
@NoArgsConstructor
@AllArgsConstructor
public class MentorsOfStudentGroup implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdStudentGroup")
    private StudentGroup studentGroup;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMentor")
    private Account mentorAccount;

    @Column(name = "Comments")
    private String comment;

}
