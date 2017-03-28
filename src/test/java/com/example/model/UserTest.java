package com.example.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created on 28/03/2017 in SimpleWebChat.
 */
public class UserTest {

    private final static String username = "username";
    private final static String password = "password";

    private User user;

    @Before
    public void setUp() throws Exception {

        user = new User(username, "password");
    }

    @Test
    public void getUsername() throws Exception {

        Assert.assertEquals(username, user.getUsername());
    }

    @Test
    public void getPassword() throws Exception {

        Assert.assertEquals(password, user.getPassword());

    }



}