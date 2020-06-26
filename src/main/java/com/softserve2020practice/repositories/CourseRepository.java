package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
