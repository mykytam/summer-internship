package com.softserve2020practice.models;

import com.softserve2020practice.models.enums.Role;

import javax.persistence.AttributeConverter;

public class RoleConverter implements AttributeConverter<Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Role role) {
        return role.getValue();
    }

    @Override
    public Role convertToEntityAttribute(Integer aByte) {
        for (Role role : Role.values()) {
            if (role.getValue() == aByte) {
                return role;
            }
        }
        throw new RuntimeException();
    }
}
