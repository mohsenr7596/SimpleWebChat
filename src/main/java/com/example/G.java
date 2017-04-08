package com.example;

import com.example.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Created on 29/03/2017 in SimpleWebChat.
 */
public class G {//Global Class

    private static final Logger anonymousLogger = Logger.getAnonymousLogger();
    private static final Map<String, User> USER_LIST = new ConcurrentHashMap<>();


    private G() {
    }

    public static Logger logger() {
        return anonymousLogger;
    }

    public static Map<String, User> userList() {
        return USER_LIST;
    }
}
