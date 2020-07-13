package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class LessonResponseDto {

    @NotNull
    private Long id;

    @NotBlank
    private String themeName;

    private LocalDateTime lessonDate;

}
