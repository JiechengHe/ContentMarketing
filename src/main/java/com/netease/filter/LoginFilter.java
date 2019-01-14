package com.netease.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hejiecheng
 * @Date 2019/1/14
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest ;
        HttpServletResponse response = (HttpServletResponse)servletResponse ;
        HttpSession session = request.getSession() ;

        String username = (String)session.getAttribute("username") ;
        if(username == null){
            response.sendRedirect("Login");
        }
        else{
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
