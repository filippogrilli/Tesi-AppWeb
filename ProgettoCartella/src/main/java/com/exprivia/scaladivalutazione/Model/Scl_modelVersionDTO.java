package com.exprivia.scaladivalutazione.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Scl_modelVersionDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4002053663188167817L;
	

	//private Integer id;
	//private Scl_modelDTO model;
	private Integer version;
	private Date creationDate;
	private String scoringFormula;
	private String scoringLabel;
	private String lastModificationUser;
	//protected Set<Scl_modelGroupingDTO> modelGrouping = new HashSet<Scl_modelGroupingDTO>(); perchè non si mette?
	/*public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}*/
	/*public Scl_modelDTO getModel() {
		return model;
	}
	public void setModel(Scl_modelDTO model) {
		this.model = model;
	}*/
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getScoringFormula() {
		return scoringFormula;
	}
	public void setScoringFormula(String scouringFormula) {
		this.scoringFormula = scouringFormula;
	}
	public String getScoringLabel() {
		return scoringLabel;
	}
	public void setScoringLabel(String scouringLabel) {
		this.scoringLabel = scouringLabel;
	}
	public String lastModificationUser() {
		return scoringLabel;
	}
	public void setlastModificationUser(String lastModificationUser) {
		this.lastModificationUser = lastModificationUser;
	}
	/*public Set<Scl_modelGroupingDTO> getModelGrouping() {
		return modelGrouping;
	}
	public void setModelGrouping(Set<Scl_modelGroupingDTO> modelGrouping) {
		this.modelGrouping = modelGrouping;
	}*/
}
