package com.exprivia.scaladivalutazione.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exprivia.scaladivalutazione.Model.Scl_model;
import com.exprivia.scaladivalutazione.Model.Scl_modelGrouping;
import com.exprivia.scaladivalutazione.Model.Scl_modelVersion;


@Repository
public interface Scl_modelRepository extends JpaRepository<Scl_model, Integer> {
	@Query("from Scl_model sm join fetch Scl_modelVersion smv")
	List<Scl_model> finddomande2();
	
	@Query("from Scl_modelVersion smv")	
	List<Scl_modelVersion> prova2();

	@Query("from Scl_modelGrouping smv")
	List<Scl_modelGrouping> prova4();
}
