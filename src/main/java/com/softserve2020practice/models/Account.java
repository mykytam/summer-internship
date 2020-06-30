package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private byte role;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String salt;

    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "StudentsOfGroups")
    private Set<StudentGroup> studentGroupSet = new HashSet<>();

}
