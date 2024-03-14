package com.demo.pojo;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@ManyToMany
	private List<Question> questions;
	
	public Quiz() {
		
	}
	

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


	public Quiz(int id, List<Question> questions) {
		super();
		this.id = id;
		this.questions = questions;
	}



	@Override
	public String toString() {
		return "Quiz [id=" + id + ", questions=" + questions + "]";
	}

	
	
	
	
}
