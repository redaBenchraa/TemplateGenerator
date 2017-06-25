package DAO; /**
 * Created by reda-benchraa on 11/05/17.
 */
/**
 * Created by reda-benchraa on 13/04/17.
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Utiz {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new AnnotationConfiguration().configure("temGen.cfg.xml");
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Problème de configuration : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    // Renvoie une session Hibernate
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}