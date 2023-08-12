package com.exprivia.scaladivalutazione.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exprivia.scaladivalutazione.Model.Scl_modelGrouping;
import com.exprivia.scaladivalutazione.Model.Scl_modelQuestion;

public interface Scl_modelQuestionRepository extends JpaRepository<Scl_modelQuestion, Integer>{

	@Query("SELECT smq FROM Scl_modelQuestion smq WHERE smq.id = :sg_id")
	public Scl_modelQuestion getScl_modelQuestionbyIDSingle(Integer sg_id);
	
	@Query("SELECT smq FROM Scl_modelQuestion smq JOIN FETCH smq.modelGrouping smg WHERE smg.id = :sg_id")
	public List<Scl_modelQuestion> getScl_modelQuestionbyIDmodel(Integer sg_id);
}
