package com.softserve2020practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.softserve2020practice.models.enums.Role.Constants.STUDENT_VALUE;

@Entity
@DiscriminatorValue(STUDENT_VALUE)
public class Student extends Account {
}
