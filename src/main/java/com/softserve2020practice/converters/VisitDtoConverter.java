package com.softserve2020practice.converters;

import com.softserve2020practice.dto.VisitDto;
import com.softserve2020practice.models.Visit;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class VisitDtoConverter implements Converter<VisitDto, Visit> {

    @Override
    public Visit convert(VisitDto visitDto) {
        return Visit.builder()
                .studentMark(visitDto.getStudentMark())
                .presence(visitDto.isPresence())
                .comment(visitDto.getComment())
                .build();
    }
}
