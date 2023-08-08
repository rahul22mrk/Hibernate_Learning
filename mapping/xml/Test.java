package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();
		Person person = new Person();
		person.setName("Ram");
		person.setAddress("Ayodhya");
		person.setPhone("9985236596");

		factory.openSession();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		session.close();
		factory.close();
	}
}
