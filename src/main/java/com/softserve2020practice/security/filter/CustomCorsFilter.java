package com.softserve2020practice.security.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomCorsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS");
        response.setHeader("Access-Control-Expose-Headers", "x-token");
        response.setHeader("Access-Control-Allow-Headers", "x-token, Content-Type, Accept, Origin, Access-Control-Expose-Headers, jwt");
        response.setHeader("Access-Control-Max-Age", "3600");

        if (!"OPTIONS".equals(request.getMethod())) {
            filterChain.doFilter(request, response);
        }
    }
}
