package com.softserve2020practice.models.enums;

import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
//@Getter

public enum Role {
    ADMIN(Constants.ADMIN_VALUE),
    MENTOR(Constants.MENTOR_VALUE),
    STUDENT(Constants.STUDENT_VALUE);

    @Setter
    @Getter
    private String value;

    Role(String value) {
        this.value = value;
    }

    public static Role recreateEnum(String value) {
        Role enumVal = null;
        if (value != null) {
            if (value.equalsIgnoreCase(Constants.STUDENT_VALUE))
                enumVal = Role.STUDENT;
            else if (value.equalsIgnoreCase(Constants.MENTOR_VALUE))
                enumVal = Role.MENTOR;
            else if (value.equalsIgnoreCase(Constants.ADMIN_VALUE))
                enumVal = Role.ADMIN;
        }
        return enumVal;
    }

    public String recreateString() {
        return value;
    }

    public static class Constants {
        public static final String STUDENT_VALUE = "1";
        public static final String MENTOR_VALUE = "2";
        public static final String ADMIN_VALUE = "4";
    }

//    ROLE_STUDENT((byte)1),
//    ROLE_MENTOR((byte)2),
//    ROLE_ADMIN((byte)4);
//
//    private byte roleNumber;

}
