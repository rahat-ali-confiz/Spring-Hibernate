package com.hibernate.jdbc.practiceActivity8;

import com.hibernate.jdbc.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // create a employee object
            System.out.println("Creating new employee object...");
            Employee tempEmployee = new Employee("Joseph", "Davis", "Alpha Testing Inc");

            // start a transaction
            session.beginTransaction();

            // save the employee object
            System.out.println("Saving the employee...");
            System.out.println(tempEmployee);
            session.save(tempEmployee);

            // commit transaction
            session.getTransaction().commit();

            // MY NEW CODE

            // find out the employee's id: primary key
            System.out.println("Saved employee. Generated id: " + tempEmployee.getId());

            // now get a new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retrieve employee based on the id: primary key
            System.out.println("\nGetting employee with id: " + tempEmployee.getId());

            Employee myEmployee = session.get(Employee.class, tempEmployee.getId());

            System.out.println("Get complete: " + myEmployee);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();
        }
    }
}
