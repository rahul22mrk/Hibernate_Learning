package com.map.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

//		// Creating Answers
//		ArrayList<AnswerMTO> answers = new ArrayList<AnswerMTO>();
//		AnswerMTO ans1 = new AnswerMTO();
//		ans1.setAnswer("Ram is the son of the Dashrath Ji and Kaushalya JI.");
//		answers.add(ans1);
//		AnswerMTO ans2 = new AnswerMTO();
//		ans2.setAnswer("Ram is Husband of Seeta Maa.");
//		answers.add(ans2);
//		AnswerMTO ans3 = new AnswerMTO();
//		ans3.setAnswer("Ram is Father of Lav and Kush JI.");
//		answers.add(ans3);
//		AnswerMTO ans4 = new AnswerMTO();
//		ans4.setAnswer("Ram is the best Person in the world.");
//		answers.add(ans4);
//		AnswerMTO ans5 = new AnswerMTO();
//		ans5.setAnswer("Ram is a Lord of Shiva.");
//		answers.add(ans5);
//
//		// Creating Question
//		QuestionOTM ques1 = new QuestionOTM();
//		ques1.setQuestion("Who is Ram ?");
//		ques1.setAnswers(answers);
//
//		ans1.setQuestionOTM(ques1);
//		ans2.setQuestionOTM(ques1);
//		ans3.setQuestionOTM(ques1);
//		ans4.setQuestionOTM(ques1);
//		ans5.setQuestionOTM(ques1);

		Session session = factory.openSession();
		try {
			// Transaction tx = session.beginTransaction();
			// session.save(ques1);
			// tx.commit();
			// System.out.println(ques1 + " Saved Successfully!");

			// Getting the Question -1
			QuestionOTM questionOTM = session.get(QuestionOTM.class, 1);
			// System.out.println(questionOTM);
			System.out.println(questionOTM.getQuestionId());
			System.out.println(questionOTM.getQuestion());
			System.out.println(questionOTM.getAnswers());

		} catch (Exception e) {
			System.out.println("Error in Saving.\n caused by : ");
			e.printStackTrace();
		}

		factory.close();
		session.close();
	}

}
