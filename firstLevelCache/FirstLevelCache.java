package com.firstLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstLevelCache {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();
		factory.openSession();
		Session session = factory.openSession();
		// by default enabled
		Student student = session.get(Student.class, 2);
		System.out.println(student);
		System.out.println("Working Something...");
		Student student1 = session.get(Student.class, 2);
		System.out.println(student1);
		System.out.println("Do You have " + student1 + " object? " + session.contains(student1));
		session.close();
		factory.close();
	}
}
