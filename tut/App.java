package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started!");
		Configuration configuration = new Configuration();
		configuration.configure(" ");

		SessionFactory factory = configuration.buildSessionFactory();

		// Creating Student
		Student student = new Student();
		student.setName("Ravi");
		student.setCity("Rewa");
		System.out.println(student);

		// Creating Object of address Class
		Address address = new Address();
		address.setStreet("street1");
		address.setOpen(true);
		address.setCity("Delhi");
		address.setCreatedDate(new Date());
		address.setX(1225.23);

		// Reading Image
		FileInputStream fis = new FileInputStream("src/main/java/com/tut/1.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);

		Session session = factory.openSession();

		try {

			Transaction transaction = session.beginTransaction();
			session.save(student);
			session.save(address);
			transaction.commit();
			System.out.println(student + " Saved in DB");
			System.out.println("Address Saved in DB");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Saving");
		}

		session.close();
		factory.close();
		fis.close();
	}
}
