package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class LessonCreateDto {

    @NotBlank
    private String themeName;

    @NotNull
    private Long groupId;

    private LocalDateTime lessonDate;

    private List<VisitDto> lessonVisits;

}
