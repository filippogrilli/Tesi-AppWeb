package com.exprivia.scaladivalutazione.Model;

public class Scl_modelQuestionDTO {

	 private Integer id;
	 //protected Scl_modelGrouping modelGrouping;
	 private String header;
	 private String text;
	 private Integer position;
	 private Integer renderAnswers;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*public Scl_modelGrouping getModelGrouping() {
		return modelGrouping;
	}
	public void setModelGrouping(Scl_modelGrouping modelGrouping) {
		this.modelGrouping = modelGrouping;
	}*/
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
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getRenderAnswers() {
		return renderAnswers;
	}
	public void setRenderAnswers(Integer renderAnswers) {
		this.renderAnswers = renderAnswers;
	}
}
