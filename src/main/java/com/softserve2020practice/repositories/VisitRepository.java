package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Lesson;
import com.softserve2020practice.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    Set<Visit> findAllByLesson(Lesson lesson);

}
