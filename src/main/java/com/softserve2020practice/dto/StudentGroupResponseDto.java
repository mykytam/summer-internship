package com.softserve2020practice.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupResponseDto {

    @NotNull
    private Long id;

    @NotBlank
    private String groupName;

    @NotNull
    private List<Long> mentorIds;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate finishDate;

}
