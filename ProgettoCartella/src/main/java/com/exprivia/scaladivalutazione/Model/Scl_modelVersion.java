package com.exprivia.scaladivalutazione.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


//import it.exprivia.e4cure.data.model.ecore.CoreUser;

/**
 * Represents an instance of a care process as specified by a user.
 */
@Entity
@Table(name="scl_model_version", schema="cce")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@UUID", scope = Scl_modelVersion.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
@JsonInclude(Include.NON_NULL)
public class Scl_modelVersion implements java.io.Serializable { //!

  /**
   * 
   */
  private static final long serialVersionUID = -78828956663354367L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_scl_model_version_gen")
  @SequenceGenerator(name = "seq_scl_model_version_gen", sequenceName = "SCL_MODEL_VERSION_SEQ", allocationSize = 1, initialValue = 1)
  @Column(name = "SV_ID", nullable = false)
  private Integer id;
  

  @ManyToOne(fetch = FetchType.EAGER)
  //@JsonIgnore
  @JoinColumn(name = "SM_ID", nullable = false)
  protected Scl_model model;

  @Column(name = "SV_VERSION", nullable = false)
  private Integer version;

  /*@ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SV_LAST_MODIFICATION_USER", nullable = false)
  private CoreUser lastModificationUser;*/

  @Column(name = "SV_CREATION_DATE", nullable = false)
  private Date creationDate;

  @Column(name = "SV_SCORING_FORMULA", nullable = false)
  private String scoringFormula;

  @Column(name = "SV_SCORING_LABEL")
  private String scoringLabel;
  
  @Column(name = "SV_LAST_MODIFICATION_USER")
  private String lastModificationUser;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "modelVersion", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @OrderBy("position ASC")
  protected Set<Scl_modelGrouping> modelGrouping = new HashSet<Scl_modelGrouping>();

  /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "modelVersion", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  protected Set<ScaleInstance> instances = new HashSet<ScaleInstance>();*/
  /*
  @Column(name = "CUSTOM_LEGEND")
  @org.hibernate.annotations.Type(type = "org.hibernate.type.NumericBooleanType")
  protected Boolean customLegend;
  */
  @Transient 
  @JsonProperty
  private Boolean genreFilter;

  @Transient 
  @JsonProperty
  private String columnText;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Scl_model getModel() {
    return model;
  }

  public void setModel(Scl_model model) {
    this.model = model;
  }

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

  public void setScoringFormula(String scoringFormula) {
    this.scoringFormula = scoringFormula;
  }

  public String getScoringLabel() {
    return scoringLabel;
  }

  public void setScoringLabel(String scoringLabel) {
    this.scoringLabel = scoringLabel;
  }
  
  public String getlastModificationUser() {
	return lastModificationUser;
  }

  public void setlastModificationUser(String lastModificationUser) {
	this.lastModificationUser = lastModificationUser;
  }

  /*public CoreUser getLastModificationUser() {
    return lastModificationUser;
  }

  public void setLastModificationUser(CoreUser lastModificationUser) {
    this.lastModificationUser = lastModificationUser;
  }*/

  public Set<Scl_modelGrouping> getModelGrouping() {
    return modelGrouping;
  }

  public void setModelGrouping(Set<Scl_modelGrouping> modelGrouping) {
    this.modelGrouping = modelGrouping;
  }
/*
  public Boolean getCustomLegend() {
    return customLegend;
  }

  public void setCustomLegend(Boolean customLegend) {
    this.customLegend = customLegend;
  }*/

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof Scl_modelVersion))
      return false;
    Scl_modelVersion other = (Scl_modelVersion) obj;
    if (this.getId() != null && other.getId() != null) {
      return this.getId().equals(other.getId());
    }
    return false;
  }

  /////////////////////// transient

  /*@Transient
  @JsonSerialize
  protected List<Scl_modelLegend> legend;

  public List<Scl_modelLegend> getLegend() {
    return legend;
  }

  public void setLegend(List<Scl_modelLegend> legend) {
    this.legend = legend;
  }*/

  /*public Set<ScaleInstance> getInstances() {
    return instances;
  }

  public void setInstances(Set<ScaleInstance> instances) {
    this.instances = instances;
  }*/

  public Boolean getGenreFilter() {
    if(this.genreFilter == null)
      return false; 
    return genreFilter;
  }

  public void setGenreFilter(Boolean filterGenre) {
    this.genreFilter = filterGenre;
  }

  public String getColumnText() {
    return columnText;
  }

  public void setColumnText(String columnText) {
    this.columnText = columnText;
  }

public static Scl_modelVersion toScl_modelVersionEntity(Scl_modelVersionDTO request) {
	// TODO Auto-generated method stub
	Scl_modelVersion scl_modelVersion = new Scl_modelVersion();
	//scl_modelVersion.setId(request.getId());
	scl_modelVersion.setCreationDate(request.getCreationDate());
	scl_modelVersion.setScoringFormula(request.getScoringFormula());
	scl_modelVersion.setScoringLabel(request.getScoringLabel());
	scl_modelVersion.setVersion(request.getVersion());
	//videocall.setIdEvento(createVideoCallRequest.getIdEvento());
	return scl_modelVersion;
}

}
