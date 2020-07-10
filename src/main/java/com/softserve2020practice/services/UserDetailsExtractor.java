package com.softserve2020practice.services;

import com.softserve2020practice.security.data.JwtUser;

public interface UserDetailsExtractor {
    JwtUser extractJwtUser();
}
