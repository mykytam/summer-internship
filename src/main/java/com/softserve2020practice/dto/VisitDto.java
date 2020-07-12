package com.softserve2020practice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VisitDto {

    private Long studentId;

    private byte studentMark;

    private boolean presence;

    private String comment;

}
