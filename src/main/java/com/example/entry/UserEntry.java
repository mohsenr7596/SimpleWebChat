package com.example.entry;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 26/03/2017 in SimpleWebChat.
 */
public class UserEntry {

    private static final String USER = "root";
    private static final String PASS = "toor";

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/SimpleWebChat";

    private static Logger logger = Logger.getAnonymousLogger();


    public static String getUser(String username) {

        //language=MySQL
        String sql = "SELECT * FROM Users WHERE username=?";

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, null, e);
        }//end ClassForName try block

        logger.log(Level.INFO, "Connecting to database...");
        logger.log(Level.INFO, "Creating statement...");

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            String password = rs.getString("password");

            rs.close();

            logger.log(Level.INFO, "Received password...");

            if (password.isEmpty()) {
                throw new SQLException();
            }

            logger.log(Level.INFO, "Return User...");
            return password;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
            logger.log(Level.INFO, "User not found...");
            return "";
        }//end finally try
    }//end getUser

    private UserEntry() {
    }
}//end UserEntry
