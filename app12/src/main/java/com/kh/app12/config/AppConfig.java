package com.kh.app12.config;

import com.kh.app12.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor mi;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mi)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/admin/login"
                        ,"/login"
                        ,"/js/**"
                        ,"/css/**"
                )
                .order(1)
                ;
    }
}
