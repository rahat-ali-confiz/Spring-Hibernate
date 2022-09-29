package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Course;
import com.hibernate.jdbc.dto.Instructor;
import com.hibernate.jdbc.dto.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{


            // start a transaction
            session.beginTransaction();


            // get the instructor from db
            int theId =1;

            Instructor tempInstructor = session.get(Instructor.class,theId);

            System.out.println("luv2Code: Instructor: " + tempInstructor);

            System.out.println("luv2Code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nThe session is now closed\n");
            // since courses are lazy loaded --- this should fail
            // get course for the instructor
            System.out.println("luv2Code: Courses: " + tempInstructor.getCourses());

            System.out.println("Done!");
        }
        finally {
            session.close();

            sessionFactory.close();
        }
    }
}
