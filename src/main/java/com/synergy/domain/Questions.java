package com.synergy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Questions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;	
	private String question;
	
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
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questions(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}
	

}