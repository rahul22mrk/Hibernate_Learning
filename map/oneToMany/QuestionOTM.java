package com.map.oneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question_OTM")
public class QuestionOTM {
	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String question;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionOTM", fetch = FetchType.EAGER)
	private List<AnswerMTO> answers;

	public QuestionOTM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionOTM(int questionId, String question, List<AnswerMTO> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerMTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerMTO> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question...\n[questionId : " + questionId + ".\n question :  " + question + "]\n\nAnswers...\n["
				+ answers + "]";
	}

}
