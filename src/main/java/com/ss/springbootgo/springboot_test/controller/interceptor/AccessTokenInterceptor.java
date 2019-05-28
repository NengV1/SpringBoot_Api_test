package com.ss.springbootgo.springboot_test.controller.interceptor;


import com.ss.springbootgo.springboot_test.exception.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class AccessTokenInterceptor extends HandlerInterceptorAdapter {

    private final String xAccessToken = "x-Access-Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return validate(request.getHeader(xAccessToken));
    }

    private boolean validate(String accessToken) {
        if (StringUtils.isEmpty(accessToken)) throw new UnauthorizedException("Access-Token is empty.");

        // Mocked data
        List<String> list = Arrays.asList("27bb0a9c", "7432485b");
        if (!list.contains(accessToken)) throw new UnauthorizedException("Invalid access-token.");
        // Another some process to validate access token value (jwt,jwe,check on redis, etc.)

        return true;
    }


}
