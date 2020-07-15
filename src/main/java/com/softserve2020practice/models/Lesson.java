package com.softserve2020practice.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup studentGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @Column(name = "lesson_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lessonDate;

    @Builder.Default
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Visit> visits = new HashSet<>();

    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setLesson(this);
    }

    public void deleteForUpdate() {
        visits.clear();
    }
}
