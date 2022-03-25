package com.hashedIn.milestone_2.interceptor;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.time.Duration;
import java.time.LocalTime;

@Component
public class NetflixInterceptor extends HandlerInterceptorAdapter { //interceptor for AuthToken
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("*****Inside PreHandle Interceptor********");
        String token = request.getHeader("X-Auth-Token"); //getting header
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        if(token==null || token.isEmpty()) { //checking token values
            response.setContentType("application/json");
            response.setStatus(401);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        System.out.println("*******Inside postHandle interceptor******");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) {
        System.out.println("*********Inside afterCompletion iterceptor********");

    }
}

