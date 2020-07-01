package com.softserve2020practice.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class MentorsOfStudentGroupPK implements Serializable {

    @NotNull
    @Column(name = "IdMentor")
    private long mentorId;

    @NotNull
    @Column(name = "IdStudentGroup")
    private long studentGroupId;

}
