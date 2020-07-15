package com.softserve2020practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lessonDate;
}
