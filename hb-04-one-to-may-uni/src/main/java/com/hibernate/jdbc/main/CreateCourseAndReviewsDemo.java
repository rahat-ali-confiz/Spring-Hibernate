package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Course;
import com.hibernate.jdbc.dto.Instructor;
import com.hibernate.jdbc.dto.InstructorDetail;
import com.hibernate.jdbc.dto.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{


            // start a transaction
            session.beginTransaction();


            // create a course
            Course tempCourse = new Course("Pacman - How To score Million Points");


            // add some reviews
            tempCourse.addReview(new Review("Great Course ... Loved it"));
            tempCourse.addReview(new Review("Cool Course ... Job well done"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot"));

            // save the course ... and leverages the cascade all :-)
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();

            sessionFactory.close();
        }
    }
}
