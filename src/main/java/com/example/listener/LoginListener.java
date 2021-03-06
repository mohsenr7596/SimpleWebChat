package com.example.listener; /**
 * Created on 26/03/2017 in SimpleWebChat.
 */

import com.example.G;
import com.example.Global;
import com.example.entry.LogEntry;
import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener()
public class LoginListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public LoginListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */

        sce.getServletContext().setAttribute(G.GLOBAL, new Global());
        G.logger().log(Level.INFO, "Chat Application Initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        // clear drivers
        while (drivers.hasMoreElements()) {

            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (SQLException e) {
                Logger.getAnonymousLogger().log(Level.SEVERE, null, e);
            }
        }

        // MySQL driver leaves around a thread. This static method cleans it up.
        AbandonedConnectionCleanupThread.checkedShutdown();

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    @Override
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */

        LogEntry.guestLogin();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */

        Global global = (Global) se.getSession().getServletContext().getAttribute(G.GLOBAL);
        String username = (String) se.getSession().getAttribute(G.USERNAME);
        global.UserList().remove(username);
        G.logger().log(Level.INFO, "%s logout!", username);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is added to a session.
      */

        if (G.LOGIN.equalsIgnoreCase(sbe.getName())) {

            LogEntry.userLogin((String) sbe.getSession().getAttribute(G.USERNAME));
        } else if (G.USERNAME.equalsIgnoreCase(sbe.getName())) {

            String value = (String) sbe.getValue();
            Global attribute = (Global) sbe.getSession().getServletContext().getAttribute(G.GLOBAL);
            attribute.UserList().add(value);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
