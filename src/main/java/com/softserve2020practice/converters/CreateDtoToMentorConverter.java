package com.softserve2020practice.converters;

import com.softserve2020practice.dto.MentorCreateDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Mentor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateDtoToMentorConverter implements Converter<MentorCreateDto, Mentor> {

    @Override
    public Mentor convert(MentorCreateDto source) {

        Account build = Account.builder()
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .build();

        return Mentor.builder().idAccount(build)
                .build();
    }

}
