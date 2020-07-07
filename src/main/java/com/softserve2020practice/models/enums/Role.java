package com.softserve2020practice.models.enums;

import lombok.Getter;
import lombok.Setter;

public enum Role {
    ADMIN(Constants.ADMIN_VALUE),
    MENTOR(Constants.MENTOR_VALUE),
    STUDENT(Constants.STUDENT_VALUE);

    @Setter
    @Getter
    private Integer value;

    Role(Integer value) {
        this.value = value;
    }

    public static class Constants {
        public static final Integer STUDENT_VALUE = 1;
        public static final Integer MENTOR_VALUE = 2;
        public static final Integer ADMIN_VALUE = 4;
    }
}