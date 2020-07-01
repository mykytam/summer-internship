package com.softserve2020practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.softserve2020practice.models.enums.Role.Constants.ADMIN_VALUE;

@Entity
@DiscriminatorValue(ADMIN_VALUE)
public class Admin extends Account {
}
