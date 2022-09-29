package com.hibernate.jdbc.practiceActivity8;

import com.hibernate.jdbc.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployeeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-cfg.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // create a employee object
            System.out.println("Creating new employee object...");

            Employee tempEmployee1 = new Employee("Faizan", "<Murtaza", "i2c Co.");
            Employee tempEmployee2 = new Employee("Umair ", "Tariq", "Ibex Ltd");
            Employee tempEmployee3 = new Employee("Afaq", "Saeed", "Curemd Ltd");
            // start a transaction
            session.beginTransaction();

            // save the employee object
            System.out.println("Saving the employee...");
            session.save(tempEmployee1);
            session.save(tempEmployee2);
            session.save(tempEmployee3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();
        }
    }
}
