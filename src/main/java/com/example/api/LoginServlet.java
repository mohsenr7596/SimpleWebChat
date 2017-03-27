package com.example.api;

import com.example.entry.UserEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created on 23/03/2017 in SimpleWebChat.
 */
@WebServlet(name = "LoginServlet",
        urlPatterns = {
                "/login"
        })
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("uname");
        String password = UserEntry.getUser(username);

        if ("".equals(password)) {
            response.sendRedirect("/login");
            return;
        }

        if (password.equals(request.getParameter("psw"))) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("login", Boolean.TRUE);

            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");

        if ("logout".equalsIgnoreCase(action)) {

            request.getSession().removeAttribute("login");
        }

        response.sendRedirect("/login.xhtml");

    }
}
