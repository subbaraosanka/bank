package com.jwt.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import java.util.List;

import com.jwt.hibernate.bean.Registration;

public class RegistrationDAO {

	public void addUserDetails(int accno,String userName, String password, String email,
			String phone, String city,String accounttype,int balance) {
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			Registration user = new Registration();
			user.setAccno(accno);
			user.setUserName(userName);
			user.setPassword1(password);
			user.setEmail(email);
			user.setCity(city);
			user.setPhone(phone);
			user.setAccounttype(accounttype);
			user.setBalance(balance);
			session.save(user);
			transaction.commit();
			System.out.println("\n\n Details Added Successfully to Hello Table\n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}


public void retriveEmployee()

{
	
	Configuration configuration = new Configuration().configure();

	SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = ((Session) sessionFactory).getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        List HELLO = session.createQuery("from HELLO").list();

        for (Iterator iterator = HELLO.iterator(); iterator.hasNext();) {
            Registration employee1 = (Registration) iterator.next();
            System.out.println(employee1.getUserName() + "  "
                    + employee1.getCity() + "  " + employee1.getEmail()
                    + "   " + employee1.getPhone());
        }
        transaction.commit();

    } catch (HibernateException e) {

        transaction.rollback();

        e.printStackTrace();

    } finally {

        session.close();

    }
}
}
