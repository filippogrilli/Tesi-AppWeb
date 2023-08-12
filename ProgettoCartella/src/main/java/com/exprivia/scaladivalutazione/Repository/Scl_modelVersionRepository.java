package com.exprivia.scaladivalutazione.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exprivia.scaladivalutazione.Model.Scl_modelVersion;

public interface Scl_modelVersionRepository extends JpaRepository<Scl_modelVersion, Integer>{

	@Query("SELECT smv FROM Scl_modelVersion smv JOIN smv.model m WHERE m.sm_id = :sm_id ORDER BY smv.id")
	public List<Scl_modelVersion> getScl_modelVersionbyIDmodel(Integer sm_id);
	//lista
	
	//non la uso perchè non trovo un modo per fare limit 1
	@Query("SELECT smv FROM Scl_modelVersion smv JOIN smv.model m WHERE m.sm_id = :sm_id ORDER BY smv.id")	//dovrei prendere però solo l'ultima versione		
	public Scl_modelVersion getScl_modelVersionbyIDSinglemodel(Integer sm_id);
	
	//join fetch per recuperare i dati anche della tabella che "viene joinata"
}
