package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String args[]) {
		// get & load

		Configuration cnfg = new Configuration();
		cnfg.configure("/com/tut/hibernate.cfg.xml");

		SessionFactory factory = cnfg.buildSessionFactory();
		Session session = factory.openSession();
		// get-student:2
		int id = 2;
		session.get(Student.class, id);
		session.get(Student.class, id);

		// load-student:2
		int loadId = 3;
		session.load(Student.class, loadId);

		session.load(Student.class, loadId);

		factory.close();
	}

}
