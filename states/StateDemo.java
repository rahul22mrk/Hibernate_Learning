package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
	public static void main(String[] args) {

		// Practical of Hibernate Object States:
		// Transient
		// Persistent
		// Detached
		// Removed
		System.out.println("Example : ");
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

		// creating student object
		Student student = new Student();
		student.setName("Ram");
		student.setCity("Ayodhya");
		student.setCertificate(new Certificate("Mahapurush", "14 yrs"));
		// student : Transient State

		Session session = factory.openSession();
		Transaction txTransaction = session.beginTransaction();
		session.save(student);
		// student: Persistent State - session,database
		student.setName("Shri Ram Chandra JI");
		session.delete(student);
		txTransaction.commit();
		session.clear();
		student.setName("Ram");
		// student : detached State
		factory.close();
	}
}
