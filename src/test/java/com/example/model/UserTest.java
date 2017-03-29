package com.example.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 28/03/2017 in SimpleWebChat.
 */
public class UserTest {

    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";

    private User user;

    @Before
    public void setUp() throws Exception {

        user = new User(USERNAME, PASSWORD);
    }

    @Test
    public void getUsername() throws Exception {

        assertEquals(USERNAME, user.getUsername());
    }

    @Test
    public void getPassword() throws Exception {

        assertEquals(PASSWORD, user.getPassword());

    }


}