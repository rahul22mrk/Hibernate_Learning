package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

		// creating Question
		Question ques1 = new Question();
		ques1.setQuestion("What is Java ?");
		// ques1.setQuestionId(102);

		// creating answer
		Answer ans1 = new Answer();
		ans1.setAnswer("Java is Programming Language.");
		// ans1.setAnswerId(12);

		ques1.setAnswer(ans1);
		ans1.setQuestion(ques1);

		// session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(ques1);
		transaction.commit();
		session.close();

		factory.close();
	}

}
