package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("from Student");

		// implementing pagination using hibernate
		query.setFirstResult(17);
		query.setMaxResults(7);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student);
		}

		session.close();
		factory.close();
	}
}
