package com.softserve2020practice.services;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.StandardCharsets;

public class PasswordGenerator {

    private static final String SALT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-01234567890";
    private static final Integer SALT_LENGTH = 15;

    public static String generateSalt() {
        return RandomStringUtils.random(SALT_LENGTH, SALT_ALPHABET);
    }

    public static String generatePassword() {
        return Hashing.sha256()
                .hashString(generateSalt(), StandardCharsets.UTF_8)
                .toString();
    }

    public static String updatePassword(String newPass) {
        return Hashing.sha256()
                .hashString(newPass.concat(generateSalt()), StandardCharsets.UTF_8)
                .toString();
    }
}
