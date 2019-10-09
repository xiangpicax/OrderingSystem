package com.cjlu.filter;

import com.cjlu.model.UserPojo;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/index.html","/"},filterName = "userFilter")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servlet = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = servlet.getSession();
        UserPojo userPojo = (UserPojo) session.getAttribute("user");
        if(userPojo == null){
             response.sendRedirect("http://http://39.108.86.144:8030/login.html");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
    @Override
    public void destroy() {

    }


}
