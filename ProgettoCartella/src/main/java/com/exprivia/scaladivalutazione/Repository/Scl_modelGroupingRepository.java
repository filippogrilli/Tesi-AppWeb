package com.exprivia.scaladivalutazione.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exprivia.scaladivalutazione.Model.Scl_modelGrouping;
import com.exprivia.scaladivalutazione.Model.Scl_modelVersion;

public interface Scl_modelGroupingRepository extends JpaRepository<Scl_modelGrouping, Integer>{

	// Delete JOIN part, in case see below
	//@Query("SELECT smg FROM Scl_modelGrouping smg WHERE smg.id = :sg_id")
	//public Scl_modelGrouping getScl_modelGroupingbyIDSinglemodel(Integer sg_id);
	
	@Query("SELECT smg FROM Scl_modelGrouping smg JOIN FETCH smg.modelVersion smv WHERE smg.id = :sg_id")
	public Scl_modelGrouping getScl_modelGroupingbyIDSinglemodel(Integer sg_id);
	
	@Query("SELECT smg FROM Scl_modelGrouping smg JOIN FETCH smg.modelVersion smv WHERE smv.id = :sv_id")
	public List<Scl_modelGrouping> getScl_modelGroupingbyIDmodel(Integer sv_id);
}
