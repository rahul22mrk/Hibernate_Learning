package com.map.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMapping {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setEmpName("Ram");
		emp2.setEmpName("Shyam");

		Project p1 = new Project();
		Project p2 = new Project();

		p1.setProjectName("Library ManageMent System");
		p2.setProjectName("CHATBOT");

		List<Project> projects = new ArrayList<Project>();

		List<Employee> employees = new ArrayList<Employee>();

		projects.add(p1);
		projects.add(p2);

		employees.add(emp1);
		employees.add(emp2);

		emp1.setProjects(projects);
		p2.setEmployees(employees);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);

		tx.commit();

		factory.close();
	}

}
