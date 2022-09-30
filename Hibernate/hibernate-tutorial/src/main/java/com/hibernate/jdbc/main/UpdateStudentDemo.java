package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate-cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            int studentId = 1;

            // now get a new session and start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the is: primary key
            System.out.println("\nGetting student with id: "+ studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating Student...");
            myStudent.setFirstName("Nazim");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = factory.getCurrentSession();

            session.beginTransaction();

            // update Email for all Students
            System.out.println("Update email fro all students");
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();



            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
