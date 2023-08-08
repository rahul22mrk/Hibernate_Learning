package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

		Student student1 = new Student();
		student1.setCity("Mumbai");
		student1.setName("XYZ");

		Certificate certificate = new Certificate();
		certificate.setCourse("Hibernate");
		certificate.setDuration("1 Months");

		student1.setCertificate(certificate);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student1);
		transaction.commit();

		factory.close();
	}

}
