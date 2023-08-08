package com.map.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer_MTO")
public class AnswerMTO {
	@Id
	@Column(name = "answer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answerId;
	private String answer;

	@ManyToOne
	private QuestionOTM questionOTM;

	public AnswerMTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerMTO(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public QuestionOTM getQuestionOTM() {
		return questionOTM;
	}

	public void setQuestionOTM(QuestionOTM questionOTM) {
		this.questionOTM = questionOTM;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.answerId + " : " + this.answer + ".\n";
	}

}
