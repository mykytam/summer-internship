package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
