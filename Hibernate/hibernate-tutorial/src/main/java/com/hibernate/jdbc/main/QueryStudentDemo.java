package com.hibernate.jdbc.main;

import com.hibernate.jdbc.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate-cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {


            // start the session
            session.beginTransaction();

            // query students
            List<Student> studentList = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(studentList);

            // query students : lastName = 'Ali'

            studentList = session.createQuery("from Student s where s.lastName ='Ali' ").getResultList();

            // display the students
            System.out.println("\n\nStudents who have last name of Ali");
            displayStudents(studentList);

            // query students: lastName = 'Ali' OR firstName ='Yasim'
            studentList =
                    session.createQuery("from Student s where s.lastName ='Ali' " +
                            "OR s.firstName = 'Yasim' ").getResultList();

            // display the students
            System.out.println("\n\nStudents who have last name of Ali OR first name Yasim");
            displayStudents(studentList);

            // query students: where email LIKE '%gmail.com'
            studentList = session.createQuery("from Student s where s.email LIKE" +
                    "'%gmail.com'").getResultList();

            // display the students
            System.out.println("\n\nStudents who have emails ends with gmail.com");
            displayStudents(studentList);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student tempStudent : studentList){
            System.out.println(tempStudent);
        }
    }
}
