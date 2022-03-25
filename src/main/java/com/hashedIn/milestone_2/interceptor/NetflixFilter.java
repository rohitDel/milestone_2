package com.hashedIn.milestone_2.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class NetflixFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { //filter to implement execution time functionality
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        long startTime = (Long) request.getAttribute("startTime");
//
//        long timeTaken = System.currentTimeMillis()-startTime;
//        httpServletResponse.setHeader("X-TIME-TO-EXECUTE", String.valueOf(timeTaken));
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
