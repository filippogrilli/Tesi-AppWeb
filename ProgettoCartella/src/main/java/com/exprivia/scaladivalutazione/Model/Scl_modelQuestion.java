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
@Table(name="scl_model_question", schema="cce")
@JsonTypeName("ScaleModelQuestion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Scl_modelQuestion.class)
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Scl_modelQuestion  implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6932774064572649395L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_scl_model_question_gen")
  @SequenceGenerator(name = "seq_scl_model_question_gen", sequenceName = "SCL_MODEL_QUESTION_SEQ", allocationSize = 1, initialValue = 1)
  @Column(name = "SQ_ID", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinColumn(name = "SG_ID", nullable = false) //dovrebbe essere false ma da errore, forse perchè viene presa in input e non capisce che non sarà null
  protected Scl_modelGrouping modelGrouping;

  @Column(name = "SQ_HEADER", nullable = true)
  private String header;

  @Column(name = "SQ_TEXT", nullable = true)
  private String text;

  @Column(name = "SQ_POSITION", nullable = true)
  private Integer position;

  /**
   * 1 = dropdown 2 = radio button verticale 3 = radio button orizzontale 4
   * =text
   */
  @Column(name = "SQ_RENDER_ANSWERS", nullable = true)
  private Integer renderAnswers;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "modelQuestion", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @OrderBy("position ASC")
  protected Set<Scl_modelAnswer> modelAnswers = new HashSet<Scl_modelAnswer>();


  @Column(name = "CLASSFIELD")
  private String classField;
  
  
  @Column(name = "REGEX_EXPR")
  private String regexExpr;
  
  @Column(name = "REGEX_ERROR_DESCRIPTION")
  private String regexErrorDescription;
  
  public Scl_modelQuestion() {
    super();
  }

  public Scl_modelQuestion(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Scl_modelGrouping getModelGrouping() {
    return modelGrouping;
  }

  public void setModelGrouping(Scl_modelGrouping modelGrouping) {
    this.modelGrouping = modelGrouping;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getRenderAnswers() {
    return renderAnswers;
  }

  public void setRenderAnswers(Integer renderAnswers) {
    this.renderAnswers = renderAnswers;
  }

  public Set<Scl_modelAnswer> getModelAnswers() {
    return modelAnswers;
  }

  public void setModelAnswers(Set<Scl_modelAnswer> modelAnswers) {
    this.modelAnswers = modelAnswers;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public String getClassField() {
    return classField;
  }

  public void setClassField(String classField) {
    this.classField = classField;
  }

  public String getRegexExpr() {
    return regexExpr;
  }

  public void setRegexExpr(String regexExpr) {
    this.regexExpr = regexExpr;
  }

  public String getRegexErrorDescription() {
    return regexErrorDescription;
  }

  public void setRegexErrorDescription(String regexErrorDescription) {
    this.regexErrorDescription = regexErrorDescription;
  }
  
  public static Scl_modelQuestion toScl_modelQuestionEntity(Scl_modelQuestionDTO request) {
		// TODO Auto-generated method stub
		Scl_modelQuestion scl_modelQuestion = new Scl_modelQuestion();
		
		scl_modelQuestion.setId(request.getId());
		scl_modelQuestion.setPosition(request.getPosition());
		scl_modelQuestion.setRenderAnswers(request.getRenderAnswers());
		scl_modelQuestion.setHeader(request.getHeader());
		scl_modelQuestion.setText(request.getText());
		
		//videocall.setIdEvento(createVideoCallRequest.getIdEvento());
		return scl_modelQuestion;
	}

}