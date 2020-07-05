package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //Student findByEmail(String email);

}
