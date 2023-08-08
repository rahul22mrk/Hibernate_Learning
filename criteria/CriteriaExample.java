package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		// criteria.add(Restrictions.eq("certificate.course", "java"));
		// criteria.add(Restrictions.lt("id", 24));
		// criteria.add(Restrictions.like("certificate.course", "ja%"));
		// criteria.setProjection(Projections.rowCount());
		List<Student> students = criteria.list();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
		factory.close();
	}
}
