package com.example.entry;

import com.example.model.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 26/03/2017 in SimpleWebChat.
 */
public class LogEntry {

    private LogEntry() {//all method is static
    }

    public static void userLogin(String username) {

        logLogin(username, "Login to website");
    }//end userLogin

    public static void guestLogin(String... otherInformation) {

        logLogin("Guest", "New user first time open website", otherInformation);

    }//end guestLogin

    private static void logLogin(String username, String action, String... otherInformation) {

        Transaction transaction = null;
        try (Session session = MainHibernate.getSession()) {
            transaction = session.beginTransaction();

            Log log = new Log(username, action, otherInformation);
            session.save(log);

            transaction.commit();
        } catch (HibernateException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, null, ex);
            transaction.rollback();
        }
    }


}
