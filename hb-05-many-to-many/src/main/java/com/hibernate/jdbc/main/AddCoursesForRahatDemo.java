package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForRahatDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{


            // start a transaction
            session.beginTransaction();

            // get the student Rahat from student
            int theId = 3;
            Student theStudent = session.get(Student.class,theId);

            System.out.println("\nLoaded student: " + theStudent);
            System.out.println("Courses related to loaded student: " + theStudent.getCourses());

            // create more courses
            Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");

            // add student to courses
            tempCourse1.addStudent(theStudent);
            tempCourse2.addStudent(theStudent);

            // save the courses
            System.out.println("\nSaving the courses ...");

            session.save(tempCourse1);
            session.save(tempCourse2);

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
