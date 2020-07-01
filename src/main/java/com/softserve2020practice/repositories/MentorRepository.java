package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
