package com.example;

import java.util.logging.Logger;

/**
 * Created on 29/03/2017 in SimpleWebChat.
 */
public class G {//Global Class

    public static final String GLOBAL = "global";
    public static final String LOGIN = "login";
    public static final String USERNAME = "username";
    private static final Logger anonymousLogger = Logger.getAnonymousLogger();

    private G() {
    }

    public static Logger logger() {
        return anonymousLogger;
    }

}
