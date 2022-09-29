package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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


            // create a course
            Course tempCourse = new Course("Pacman - How To score Million Points");

            // save the course
            System.out.println("\nSaving the Course ...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            // create the students
            Student tempStudent1 = new Student("Rahat", "Ali","rahat.ali@confiz.com");
            Student tempStudent2 = new Student("Muhammad", "Sabih","m.sabih@confiz.com");

            // add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            // save the students
            System.out.println("\nSaving Students ...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved Students: " + tempCourse.getStudents());

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
