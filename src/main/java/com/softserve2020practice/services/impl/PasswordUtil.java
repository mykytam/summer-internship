package com.softserve2020practice.services.impl;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.StandardCharsets;

public class PasswordUtil {

    private static final String SALT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-01234567890";
    private static final Integer SALT_LENGTH = 15;
    private static final Integer PASSWORD_LENGTH = 8;

    public static String generateSalt() {
        return RandomStringUtils.random(SALT_LENGTH, SALT_ALPHABET);
    }

    public static String generatePassword() {
        return RandomStringUtils.randomAlphabetic(PASSWORD_LENGTH);
    }

    public static String hashPassword(String password, String salt) {
        return Hashing.sha256()
                .hashString(password.concat(salt), StandardCharsets.UTF_8)
                .toString();
    }
}
