package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class LessonByStudentIdResponseDto {

    @NotBlank
    private String themeName;

    @NotNull
    private Long id;

    private boolean presence;

    @NotNull
    private byte mark;

    @NotBlank
    private String comment;

    @NotNull
    private Long studentGroupId;

    private LocalDateTime localDate;
}
