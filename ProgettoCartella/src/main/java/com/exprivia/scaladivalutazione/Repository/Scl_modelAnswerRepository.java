package com.exprivia.scaladivalutazione.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exprivia.scaladivalutazione.Model.Scl_modelAnswer;
import com.exprivia.scaladivalutazione.Model.Scl_modelQuestion;

public interface Scl_modelAnswerRepository extends JpaRepository<Scl_modelAnswer, Integer>{

	@Query("SELECT sma FROM Scl_modelAnswer sma WHERE sma.id = :sa_id")
	public Scl_modelAnswer getScl_modelAnswerbyIDSingle(Integer sa_id);
	
	@Query("SELECT sma FROM Scl_modelAnswer sma JOIN FETCH sma.modelQuestion smq WHERE smq.id = :sq_id")
	public List<Scl_modelAnswer> getScl_modelAnswerbyIDquestion(Integer sq_id);
}
