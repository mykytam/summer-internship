package com.softserve2020practice.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MentorsOfStudentGroupPK implements Serializable {

    @Column(name = "IdMentor")
    private long mentorId;

    @Column(name = "IdStudentGroup")
    private long studentGroupId;

}
