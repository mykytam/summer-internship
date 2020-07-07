package com.softserve2020practice.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "mentor")
@PrimaryKeyJoinColumn(name = "account_id")
public class Mentor extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "mentor_of_course",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "mentors")
    private Set<StudentGroup> groups = new HashSet<>();

    @OneToMany(mappedBy = "mentor")
    @EqualsAndHashCode.Exclude
    private Set<Lesson> lessons;

    public void addCourse(Course course) {
        courses.add(course);
        course.getMentors().add(this);
    }

}
