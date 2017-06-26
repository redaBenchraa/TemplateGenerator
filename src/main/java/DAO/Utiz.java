package DAO; /**
 * Created by reda-benchraa on 11/05/17.
 */
/**
 * Created by reda-benchraa on 13/04/17.
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.primefaces.model.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class Utiz {
    private static String path = "uploads";
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
    public static String uploadImage(UploadedFile file){
        Random rand = new Random();
        String fileName = String.valueOf(rand.nextInt(10000))+file.getFileName();
        try{
            InputStream Input = file.getInputstream();
            Files.copy(Input, Paths.get(path,fileName), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            System.out.println(e);
        }
        return path+"/"+fileName;
    }
}