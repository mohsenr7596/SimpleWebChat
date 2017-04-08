package com.example.entry;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 26/03/2017 in SimpleWebChat.
 */
public class UserEntry {

    private static final UserProperties PROPERTIES = new UserProperties("connector.properties");
    private static Logger logger = Logger.getAnonymousLogger();

    private UserEntry() {
    }


    public static String getUser(String username) {

        //language=MySQL
        String sql = "SELECT * FROM Users WHERE username=?";

        try {
            Class.forName(PROPERTIES.getJDBC_DRIVER());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, null, e);
        }//end ClassForName try block

        logger.log(Level.INFO, "Connecting to database...");
        logger.log(Level.INFO, "Creating statement...");

        try (Connection connection = DriverManager.getConnection(
                PROPERTIES.getDB_URL(),
                PROPERTIES.getUSER(),
                PROPERTIES.getPASS());

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
            logger.log(Level.INFO, "User not found error to connect database...");
            return "";
        }//end finally try
    }//end getUser
}//end UserEntry
