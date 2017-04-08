package com.example.filter;

import com.example.G;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created on 26/03/2017 in SimpleWebChat.
 */
@WebFilter(filterName = "LoginFilter",
        urlPatterns = {
                "/*"
        })
public class LoginFilter implements Filter {


    Logger logger = G.logger();


    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/login") || requestURI.startsWith("/resources/") || "/".equals(requestURI)) {
            chain.doFilter(req, resp);
            return;
        }

        HttpSession session = request.getSession();
        Boolean login = (Boolean) session.getAttribute("Login");

        if (login == null || !login) {
            response.sendRedirect("/");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
