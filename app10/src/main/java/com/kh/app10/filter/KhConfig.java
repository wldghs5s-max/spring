package com.kh.app10.filter;

import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

@Configuration
public class KhConfig {

    @Bean
    public FilterRegistrationBean m01(){

        KhFilter khFilter = new KhFilter();
        FilterRegistrationBean x = new FilterRegistrationBean(khFilter);
        x.addUrlPatterns("/*");
        x.setOrder(1);
        return x;

    }


}
