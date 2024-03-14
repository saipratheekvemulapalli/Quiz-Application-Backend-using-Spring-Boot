package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.pojo.Question;
import com.demo.repo.Questionrepo;

@Service
public class QuestionService {

	@Autowired
	Questionrepo questionrepo;
	

	public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionrepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        
		
   }
	

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionrepo.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Question> addQuestion(Question question) {
    	try {
    		 questionrepo.save(question);
    		 return new ResponseEntity<>(HttpStatus.CREATED);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

   
    }
    
    public  ResponseEntity< String> deleteById(int id) {
    	try {
  		  questionrepo.deleteById(id);
    		return new ResponseEntity<>("deleted",HttpStatus.OK);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<>("not deleted",HttpStatus.BAD_REQUEST);
    	
   }
}
