package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "MentorsOfStudentGroups")
public class MentorsOfStudentGroup implements Serializable {

    @EmbeddedId
    @NotNull
    private MentorsOfStudentGroupPK id;

    @ManyToOne
    @MapsId("mentorId")
    @JoinColumn(name = "IdMentor")
    private Account mentor;

    @ManyToOne
    @MapsId("studentGroupId")
    @JoinColumn(name = "IdStudentGroup")
    private StudentGroup studentGroup;

    @Column(name = "Comments")
    private String comment;

}
