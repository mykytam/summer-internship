package com.softserve2020practice.models;

import com.softserve2020practice.models.enums.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Role")
    @Convert(converter = RoleConverter.class)
    private Role role;

    @NotBlank
    @Column(name = "FirstName")
    private String firstName;

    @NotBlank
    @Column(name = "LastName")
    private String lastName;

    @NotBlank
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Column(name = "Password")
    private String password;

    @NotBlank
    @Column(name = "Salt")
    private String salt;

    @Column(name = "Active")
    private boolean active;

}
