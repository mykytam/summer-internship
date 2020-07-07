package com.softserve2020practice.converters;

import com.softserve2020practice.dto.MentorResponseDto;
import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.Mentor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MentorResponseDtoConverter implements Converter<Mentor, MentorResponseDto> {

    @Override
    public MentorResponseDto convert(Mentor source) {

        Account account = source.getIdAccount();

        return MentorResponseDto.builder()
                .id(source.getId())
                .idAccount(source.getIdAccount().getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .isActive(account.getIsActive())
                .build();

    }
}
