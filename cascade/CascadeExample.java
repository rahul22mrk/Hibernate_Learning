package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.oneToMany.AnswerMTO;
import com.map.oneToMany.QuestionOTM;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();
		factory.openSession();
		Session session = factory.openSession();
		QuestionOTM q1 = new QuestionOTM();

		q1.setQuestion("What is Cascading?");

		AnswerMTO a1 = new AnswerMTO();
		a1.setAnswer("In Hibernate it is important concept");
		AnswerMTO a2 = new AnswerMTO();
		a2.setAnswer("Second Answer");
		AnswerMTO a3 = new AnswerMTO();
		a3.setAnswer("Third Answer");

		List<AnswerMTO> answers = new ArrayList<AnswerMTO>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);

		q1.setAnswers(answers);

		a1.setQuestionOTM(q1);
		a2.setQuestionOTM(q1);
		a3.setQuestionOTM(q1);

		Transaction tx = session.beginTransaction();
		session.save(q1);
		tx.commit();
		session.close();
		factory.close();

	}
}
