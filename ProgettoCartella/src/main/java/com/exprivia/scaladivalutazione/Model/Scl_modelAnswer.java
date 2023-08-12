package com.exprivia.scaladivalutazione.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Represents an instance of a care process as specified by a user.
 */
@Entity
@Table(name="scl_model_answer", schema="cce")
@JsonTypeName("ScaleModelAnswer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Scl_modelAnswer.class)
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Scl_modelAnswer implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7701305465503702326L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_scl_model_answer_gen")
  @SequenceGenerator(name = "seq_scl_model_answer_gen", sequenceName = "SCL_MODEL_answer_SEQ", allocationSize = 1, initialValue = 1)
  @Column(name = "SA_ID", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER) //invece di lazy
  @JsonIgnore
  @JoinColumn(name = "SQ_ID", nullable = false)
  protected Scl_modelQuestion modelQuestion;

  @Column(name = "SA_TEXT", nullable = false)
  private String text;

  @Column(name = "SA_SCORE", nullable = true)
  private Double score;

  @Column(name = "SA_POSITION", nullable = true)
  private Integer position;

  @Lob
  @Type(type = "org.hibernate.type.TextType")
  @Column(name = "SA_IMAGE", nullable = true)
  private String image;

  public Scl_modelAnswer() {
    super();
  }

  public Scl_modelAnswer(Integer id) {
    this.id = id;
  }

  public Scl_modelQuestion getModelQuestion() {
    return modelQuestion;
  }

  public void setModelQuestion(Scl_modelQuestion modelQuestion) {
    this.modelQuestion = modelQuestion;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public static Scl_modelAnswer toScl_modelAnswerEntity(Scl_modelAnswerDTO request) {
		// TODO Auto-generated method stub
		Scl_modelAnswer scl_modelAnswer = new Scl_modelAnswer();
		scl_modelAnswer.setId(request.getId());
		scl_modelAnswer.setPosition(request.getPosition());
		scl_modelAnswer.setImage(request.getImage());
		scl_modelAnswer.setScore(request.getScore());
		scl_modelAnswer.setText(request.getText());
		
		//videocall.setIdEvento(createVideoCallRequest.getIdEvento());
		return scl_modelAnswer;
	}

}