package com.example.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created on 26/03/2017 in SimpleWebChat.
 */
@Entity
@Table(name = "Log")
public class Log {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String action;

    @Column
    private String otherInformation;

    public Log(String user, String action, String... otherInformation) {
        this.user = user;
        this.action = action;
        date = new Date();

        if (otherInformation != null) {
            StringBuilder builder = new StringBuilder();
            for (String s : otherInformation) {
                builder.append(s).append("\n");
            }
            this.otherInformation = builder.toString().trim();
        }
    }

    public Log() {//default constructor
    }
}
