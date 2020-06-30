package com.softserve2020practice.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdTheme", nullable = false)
    private Lesson lesson;

}
