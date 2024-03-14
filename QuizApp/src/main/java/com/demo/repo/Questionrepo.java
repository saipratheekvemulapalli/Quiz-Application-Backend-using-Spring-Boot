package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.pojo.Question;
import com.demo.pojo.Quiz;

import org.springframework.data.jpa.repository.Query;


@Repository
public interface Questionrepo extends JpaRepository<Question, Integer> {
	
	public List<Question> findByCategory(String category);
	
	public Question deleteById(int id);
	
	
	@Query(value="select * from Question q where q.category=:category",nativeQuery=true)
	public List<Question> findQuestionByCategory(String category) ;

	public void save(Quiz quiz);
	
	@Query(value = "select COUNT(q) from Question q")
	public  int findTotalNoOfQuestions();
		
	
}
