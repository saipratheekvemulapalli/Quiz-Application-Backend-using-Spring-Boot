package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.pojo.AnswerByUser;
import com.demo.pojo.Question;
import com.demo.pojo.QuestionforDisplay;
import com.demo.pojo.Quiz;
import com.demo.repo.QuestionForDisplayRepo;
import com.demo.repo.Questionrepo;
import com.demo.repo.QuizRepo;


@Service
public class Quizservice {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	Questionrepo questionRepo;
	
	@Autowired
	QuestionForDisplayRepo questionForDisplayRepo;
	

	public ResponseEntity<String> create(String category) {
		List<Question> question =questionRepo.findQuestionByCategory(category);
		int totalQues = questionRepo.findTotalNoOfQuestions();
		
		Quiz quiz = new Quiz();
		
		
		
		
		quiz.setQuestions(question);
		
		questionRepo.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	public ResponseEntity<List<QuestionforDisplay>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
      //  int toFindIdOfQuestion;
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionforDisplay> questionsForUser = new ArrayList<>();
        
        for(int i=0;i<questionsFromDB.size();i++) {
        	QuestionforDisplay qfd = new QuestionforDisplay();
        	Question qui = new Question();
        	// Quiz toFindIdOfQuestion = quizRepo.getById(id);
        	//Sqfd.setIdFromQuestion(qui.getId());
        	
        	String q=	questionsFromDB.get(i).getQuestion();
        	String o1 = questionsFromDB.get(i).getOption1();
        	String o2 = questionsFromDB.get(i).getOption2();
        	String o3 = questionsFromDB.get(i).getOption3();
        	String o4 = questionsFromDB.get(i).getOption4();
        	
        	qfd.setQuestion(q);
        	qfd.setOption1(o1);
        	qfd.setOption2(o2);
        	qfd.setOption3(o3);
        	qfd.setOption4(o4);
        	
        	questionForDisplayRepo.save(qfd);
        	questionsForUser.add(qfd);
        	
        }      
//        for(Question q : questionsFromDB){
//            QuestionforDisplay qw = new QuestionforDisplay(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//            questionsForUser.add(qw);
//        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }
	
	
	
	public ResponseEntity<Integer> getResponse(int id, List<AnswerByUser> answerByUser) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> ques = quiz.get().getQuestions();
		int count=0;
		for(int i=0;i<answerByUser.size();i++) {
			if(answerByUser.get(i).getAnswerByUser().equals(ques.get(i).getAnswer())) {
				count = count+1;
			}
		}
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
		
	}
		
	
	
}

	
	
		