package com.example;

import java.util.logging.Logger;

/**
 * Created on 29/03/2017 in SimpleWebChat.
 */
public class G {

    private static final Logger anonymousLogger = Logger.getAnonymousLogger();

    private G() {
    }

    public static Logger logger() {
        return anonymousLogger;
    }

}
