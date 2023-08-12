package com.exprivia.scaladivalutazione.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Represents an instance of a care process as specified by a user.
 */
@Entity
@Table(name="scl_model_grouping", schema="cce")
@JsonTypeName("ScaleModelGrouping")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Scl_modelGrouping.class)
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Scl_modelGrouping implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6738739292438152713L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_scl_model_grouping_gen")
  @SequenceGenerator(name = "seq_scl_model_grouping_gen", sequenceName = "SCL_MODEL_GROUPING_SEQ", allocationSize = 1, initialValue = 1)
  @Column(name = "SG_ID", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnore
  @JoinColumn(name = "SV_ID", nullable = false)
  protected Scl_modelVersion modelVersion;

  @Column(name = "SG_HEADER", nullable = false)
  private String header;

  @Column(name = "SG_DESCRIPTION", nullable = true)
  private String description;

  @Column(name = "SG_POSITION", nullable = true)
  private Integer position;

  @Column(name = "FLAG_SHOW_SCORING")
  @org.hibernate.annotations.Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean showScoring;

  @Column(name = "SG_SCORING_LABEL")
  private String scoringLabel;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "modelGrouping", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
  @OrderBy("position ASC")
  protected Set<Scl_modelQuestion> modelQuestions = new HashSet<Scl_modelQuestion>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Scl_modelVersion getModelVersion() {
    return modelVersion;
  }

  public void setModelVersion(Scl_modelVersion modelVersion) {
    this.modelVersion = modelVersion;
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

  public Set<Scl_modelQuestion> getModelQuestions() {
    return modelQuestions;
  }

  public void setModelQuestions(Set<Scl_modelQuestion> modelQuestions) {
    this.modelQuestions = modelQuestions;
  }

  public static Scl_modelGrouping toScl_modelGroupingEntity(Scl_modelGroupingDTO request) {
		// TODO Auto-generated method stub
		Scl_modelGrouping scl_modelGrouping = new Scl_modelGrouping();
		scl_modelGrouping.setDescription(request.getDescription());
		scl_modelGrouping.setHeader(request.getHeader());
		scl_modelGrouping.setId(request.getId());
		scl_modelGrouping.setPosition(request.getPosition());
		//scl_modelGrouping.setModelQuestions(request.getModelQuestions());
		scl_modelGrouping.setShowScoring(request.getShowScoring());
		scl_modelGrouping.setScoringLabel(request.getScoringLabel());
		
		//videocall.setIdEvento(createVideoCallRequest.getIdEvento());
		return scl_modelGrouping;
	}
}