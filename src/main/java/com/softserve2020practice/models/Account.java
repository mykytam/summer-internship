package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.INTEGER)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "Id")
    private long id;

    @Column(name = "Role", insertable = false, updatable = false)
    private byte role;

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
