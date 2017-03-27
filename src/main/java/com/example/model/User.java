package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created on 26/03/2017 in SimpleWebChat.
 */
@Entity
@Table(name = "Users")
public class User {

    @Column(nullable = false)
    @Id
    private String username;
    @Column(nullable = false)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {//need for hibernate
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
