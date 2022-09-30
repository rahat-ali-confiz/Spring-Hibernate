package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate-cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {

            // create a student object
            System.out.println("Creating new student object....");
            Student student = new Student("Rahat","Ali","rahat@gmail.com");

            // start the session
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            System.out.println(student);
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

            // MY NEW CODE

            // Find out the student's id: primary key
            System.out.println("Saved Student. Generated is: "+ student.getId());

            // now get a new session and start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the is: primary key
            System.out.println("\nGetting student with id: "+ student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get Complete: "+ myStudent);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
