package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class LessonUpdateDto {

    private String themeName;

    private LocalDateTime lessonDate;

    private List<VisitDto> lessonsVisits;

}
