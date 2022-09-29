package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Instructor;
import com.hibernate.jdbc.dto.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            // create the objects
            Instructor tempInstructor =
                    new Instructor("Muhammad", "Hafeez", "hafezz@connfiz.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http//www.youtube.com",
                            "Play Cricket");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // Note: This will ALSO  save the details object
            // because of CascadeType.ALL

            System.out.println("Saving Instructor: " + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
