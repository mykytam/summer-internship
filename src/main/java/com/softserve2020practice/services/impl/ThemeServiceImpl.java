package com.softserve2020practice.services.impl;

import com.softserve2020practice.models.Theme;
import com.softserve2020practice.repositories.ThemeRepository;
import com.softserve2020practice.services.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    @Override
    public List<String> getAllThemes() {
        return themeRepository.findAll()
                .stream()
                .map(Theme::getName)
                .collect(Collectors.toList());
    }
}