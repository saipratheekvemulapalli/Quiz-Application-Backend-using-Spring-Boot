package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.AnswerByUser;
import com.demo.pojo.Question;
import com.demo.pojo.QuestionforDisplay;
import com.demo.service.Quizservice;

@RestController
@RequestMapping("Quiz")
public class Quizcontroller {
	@Autowired
	Quizservice quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category) {
		return quizService.create(category);	
	}
	
	@GetMapping("getQuiz/{id}")
	public ResponseEntity< List<QuestionforDisplay> >getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id);
		
	}
	
	@PostMapping("Response/{id}")
	public ResponseEntity< Integer > Response(@PathVariable int id,@RequestBody List<AnswerByUser> answerByUser ) {
		return quizService.getResponse(id,answerByUser);
	}
	
}
