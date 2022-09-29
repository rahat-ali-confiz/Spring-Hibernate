package com.hibernate.jdbc.practiceActivity8;

import com.hibernate.jdbc.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            int employeeId = 10 ;

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retrieve employee based on the id: primary key
            System.out.println("\nGetting employee with id: " + employeeId);
            Employee myEmployee = session.get(Employee.class, employeeId);

//            System.out.println("Deleting employee ...");
//            session.delete(myEmployee);


            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // update company for all employees
            System.out.println("Delete Employee with id=11 ");

            session.createQuery("delete from Employee where id = 11")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }

        finally {
            session.close();
        }
    }
}
