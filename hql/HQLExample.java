package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// HQL Syntax
		String hql = "from Student where city like :city";

		Query query = session.createQuery(hql);
		query.setParameter("city", "Ayo%");
		// single - unique
		// multile - list
		List<Student> stuents = query.list();
		for (Student student : stuents) {
			System.out.println(student);
		}

		Query query2 = session.createQuery("delete from Student as s where s.city = :city");
		query2.setParameter("city", "xyz");
		int r = query2.executeUpdate();
		tx.commit();
		System.out.println(r + " rows deleted.");

		Query query3 = session.createQuery(
				"select q.question, q.questionId, a.answerId, a.answer from QuestionOTM as q inner join q.answers as a");
		List<Object[]> list = query3.getResultList();
		for (Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		session.close();
	}
}
