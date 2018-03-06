package com.jwt.hibernate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.Balance;

public class BalanceDAO {

	public void addMarksDetails(int accno,String type,int amount) 
	{
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			Balance bal = new Balance();
			bal.setAccno(accno);
			bal.setType(type);
			bal.setAmount(amount);
			session.save(bal);
			transaction.commit();
			System.out.println("\n\n Details Added Successfully to Balance Table \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}
	
	public Balance searchAccount(String ROLL_NO)
    {
        
       //Transaction tx = null;
	 //marks account = null;
	 try {
		 
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@mnipdmkatukoori.modeln.com:1521:mndb11g","system","oracle");
		 PreparedStatement stmt=con.prepareStatement("select ROLL_NO from MARKS where ROLL_NO='"+ROLL_NO+"'");
		 ResultSet rs=stmt.executeQuery();
		 
               // Configuration configuration = new Configuration().configure();

    			// 2. create sessionfactory
    			//SessionFactory sessionFactory = configuration.buildSessionFactory();

    			// 3. Get Session object
    			//Session session1 = sessionFactory.openSession();
		 //tx = session1.getTransaction();
		 //tx.begin();
		 	//Query query = session1.createQuery("from MARKS where ROLL_NO='"+ROLL_NO+"'");
		 	//PreparedStatement ps;
		 	//List<marks> query = new ArrayList<marks>();
		 	//query = (ArrayList<marks>) session1.createQuery("from marks where ROLL_NO='"+ROLL_NO+"'").list();
		    //session1.getTransaction().commit();
		    //account = (marks)((Query) query).uniqueResult();
		 //tx.commit();
		 while (rs.next()) {
			   
			    System.out.println(rs.getString(1));
			}
	 } catch (Exception e) {
		 //if (tx != null) {
			// tx.rollback();
		 }
		 //e.printStackTrace();
	 //}
	 Balance rs = null;
	return rs;
    }
}
