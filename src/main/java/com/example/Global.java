package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 11/04/2017 in SimpleWebChat.
 */
public class Global {

    private final Set<String> USER_LIST;

    public Global() {
        USER_LIST = new HashSet<>();
    }

    public Set<String> UserList() {
        return USER_LIST;
    }
}
