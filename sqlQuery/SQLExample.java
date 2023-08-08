package com.sqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// SQL Query
		String query = "select * from student";
		NativeQuery nQuery = session.createSQLQuery(query);

		List<Object[]> list = nQuery.list();
		for (Object[] student : list) {
			System.out.println(Arrays.toString(student));
		}
		session.close();
		factory.close();
	}
}
