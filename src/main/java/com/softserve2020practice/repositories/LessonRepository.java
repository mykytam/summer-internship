package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
