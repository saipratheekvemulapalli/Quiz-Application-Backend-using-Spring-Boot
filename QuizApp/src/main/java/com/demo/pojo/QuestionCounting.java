package com.demo.pojo;

import java.util.List;

public class QuestionCounting {
	
	
	private int count;
	private List<Question> question;
	
	@Override
	public String toString() {
		return "QuestionCounting [count=" + count + ", question=" + question + "]";
	}
	public QuestionCounting(int count, List<Question> question) {
		super();
		this.count = count;
		this.question= question;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = (List<Question>) question;
	}
	
	
}
