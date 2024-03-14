package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.Question;
import com.demo.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	 @Autowired
	 QuestionService questionService;

	    @GetMapping("/allQuestions")
	    public ResponseEntity<List<Question>> getAllQuestions(){
	    	//System.out.println("kjds");
	        return questionService.getAllQuestions();
	        		
	    }

	    @GetMapping("/category/{category}")
	    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
	        
	    	return questionService.getQuestionsByCategory(category);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
	          return questionService.addQuestion(question);
	         
	    }
	
	    @DeleteMapping("/deleteById/{id}")
	    public  ResponseEntity< String > deleteById(@PathVariable int id) {
	    	 return questionService.deleteById(id);
	    }
	
	
	
	
}
