package com.exprivia.scaladivalutazione.Model;

import java.util.HashSet;
import java.util.Set;

public class Scl_modelGroupingDTO {

	private Integer id;
	  //protected Scl_modelVersion modelVersion;
	  private String header;
	  private String description;
	  private Integer position;
	  private Boolean showScoring;
	  private String scoringLabel;
	  //protected Set<Scl_modelQuestionDTO> modelQuestions = new HashSet<Scl_modelQuestionDTO>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Boolean getShowScoring() {
		return showScoring;
	}
	public void setShowScoring(Boolean showScoring) {
		this.showScoring = showScoring;
	}
	public String getScoringLabel() {
		return scoringLabel;
	}
	public void setScoringLabel(String scoringLabel) {
		this.scoringLabel = scoringLabel;
	}
	/*public Set<Scl_modelQuestionDTO> getModelQuestions() {
		return modelQuestions;
	}
	public void setModelQuestions(Set<Scl_modelQuestionDTO> modelQuestions) {
		this.modelQuestions = modelQuestions;
	}*/
	  
	  
}
