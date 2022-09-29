package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {

            // create 3 student object
            System.out.println("Creating new student object....");
            Student student = new Student("Yasim","Iqbal","yasim@gmail.com");
            Student student1 = new Student("Ali","HAfeez","ali@gmail.com");
            Student student2 = new Student("Shahid","Ali","shahid@gmail.com");

            // start the session
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(student);
            session.save(student1);
            session.save(student2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }

    }
}
