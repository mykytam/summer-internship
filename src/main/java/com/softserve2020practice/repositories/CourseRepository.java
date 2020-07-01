package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
