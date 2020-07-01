package com.softserve2020practice.models.enums;


import lombok.Getter;

public enum Role {
    ADMIN(Constants.ADMIN_VALUE),
    MENTOR(Constants.MENTOR_VALUE),
    STUDENT(Constants.STUDENT_VALUE);

    @Getter
    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static class Constants {
        public static final String ADMIN_VALUE = "4";
        public static final String MENTOR_VALUE = "2";
        public static final String STUDENT_VALUE = "1";
    }
}
