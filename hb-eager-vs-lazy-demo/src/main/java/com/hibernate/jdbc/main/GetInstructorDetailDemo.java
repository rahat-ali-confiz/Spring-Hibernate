package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Instructor;
import com.hibernate.jdbc.dto.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
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

            // get the instructor detail object
            int theId = 2;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class,theId);

            // print the instructor detail
            System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

            // print the associated instructor
            System.out.println("The associated instructor: "
                    + tempInstructorDetail.getInstructor());
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            session.close();

            sessionFactory.close();
        }
    }
}
