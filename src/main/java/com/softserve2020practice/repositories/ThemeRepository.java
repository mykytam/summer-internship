package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    Theme findByName(String name);

}
