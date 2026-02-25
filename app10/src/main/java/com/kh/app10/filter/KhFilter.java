package com.kh.app10.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

public class KhFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("필터 동작함 ~~~");
        filterChain.doFilter(servletRequest,servletResponse);
        ((HttpServletResponse)servletResponse).sendRedirect("/home");
    }
}
