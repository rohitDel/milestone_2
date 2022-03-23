package com.hashedIn.milestone_2.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hashedIn.milestone_2.interceptor.NetflixInterceptor;

@Configuration
public class NetflixConfig implements WebMvcConfigurer {

    @Autowired
    NetflixInterceptor netflixInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(netflixInterceptor);
    }

}

