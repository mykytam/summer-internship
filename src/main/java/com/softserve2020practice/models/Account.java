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

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", insertable = false, updatable = false)
//    @Type(type="com.softserve2020practice.models.enums.EnumRole",
//            parameters={
//                    @Parameter(name="enumClassName",value="com.softserve2020practice.models.enums.Role"),
//                    @Parameter(name="recreateEnumMthd",value="recreateEnum"),
//                    @Parameter(name="recreateStringMthd",value="recreateString")
//            }
//    )
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
