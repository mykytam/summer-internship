package com.softserve2020practice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softserve2020practice.converters.RoleConverter;
import com.softserve2020practice.models.enums.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    @Convert(converter = RoleConverter.class)
    private Role role;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "salt")
    private String salt;

    @Column(name = "is_active")
    private boolean active;

    @OneToMany(mappedBy = "idAccount")
    private Set<Mentor> mentors;

    @JsonIgnore
    @OneToMany(mappedBy = "idAccount")
    private Set<Student> students;

}
