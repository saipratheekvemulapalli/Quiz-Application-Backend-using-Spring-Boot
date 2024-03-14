package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pojo.Question;
import com.demo.pojo.QuestionforDisplay;
import com.demo.pojo.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

	public void save(QuestionforDisplay qfd);
	
	
	

//	public List<Question> getQuesrandomByCategory(String category, int noOfQues) {
//		
//		return ;
//	}
	
	
	
	
	
}
