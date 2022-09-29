package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            // delete the student
            // System.out.println("Deleting Student: " + myStudent);
            // session.delete(myStudent);

            // delete student id =2
            System.out.println("Deleting Student id=2 ");
            session.createQuery("delete from Student where id = 2")
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
