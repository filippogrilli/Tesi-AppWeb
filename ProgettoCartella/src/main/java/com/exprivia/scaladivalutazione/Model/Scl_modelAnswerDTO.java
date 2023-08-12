package com.exprivia.scaladivalutazione.Model;

public class Scl_modelAnswerDTO {

	private Integer id;
	//protected Scl_modelQuestion modelQuestion;
	private String text;
	private Double score;
	private Integer position;
	private String image;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*public Scl_modelQuestion getModelQuestion() {
		return modelQuestion;
	}
	public void setModelQuestion(Scl_modelQuestion modelQuestion) {
		this.modelQuestion = modelQuestion;
	}*/
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
	
	
}
