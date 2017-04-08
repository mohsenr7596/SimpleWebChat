package com.example.entry;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 08/04/2017 in SimpleWebChat.
 */
public class UserProperties {


    private final String DB_URL;
    private final String JDBC_DRIVER;
    private final String USER;
    private final String PASS;

    public UserProperties(String name) {
        Properties config = new Properties();
        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(name));
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, null, e);
        }

        DB_URL = config.getProperty("DB_URL");
        JDBC_DRIVER = config.getProperty("JDBC_DRIVER");
        USER = config.getProperty("USER");
        PASS = config.getProperty("PASS");

        Logger.getAnonymousLogger().log(Level.INFO, USER);
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }
}
