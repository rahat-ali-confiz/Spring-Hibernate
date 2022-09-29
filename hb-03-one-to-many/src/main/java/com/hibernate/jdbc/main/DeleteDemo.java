package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Instructor;
import com.hibernate.jdbc.dto.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // get instructor by primary key / id
            int theId = 1;

            Instructor tempInstructor = session.get(Instructor.class,theId);
            System.out.println("Found Instructor: " + tempInstructor);

            // delete the instructors
            if (tempInstructor !=null){

                System.out.println("Deleting: " + tempInstructor);

                // Note: this will ALSO delete associated "details" object
                // because of CascadeType.ALL
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }
}
