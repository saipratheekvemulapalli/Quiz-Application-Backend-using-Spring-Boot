package com.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class AnswerByUser {
	
	
	private int id;
	private String answerByUser;
	
	public AnswerByUser() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswerByUser() {
		return answerByUser;
	}

	public void setAnswerByUser(String answerByUser) {
		this.answerByUser = answerByUser;
	}

	public AnswerByUser(int id, String answerByUser) {
		super();
		this.id = id;
		this.answerByUser = answerByUser;
	}

	@Override
	public String toString() {
		return "AnswerByUser [id=" + id + ", answerByUser=" + answerByUser + "]";
	}
	
	
	
	
	
	
	
}
