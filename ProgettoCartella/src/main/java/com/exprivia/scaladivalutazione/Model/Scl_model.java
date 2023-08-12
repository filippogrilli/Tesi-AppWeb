package com.exprivia.scaladivalutazione.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="scl_model", schema="cce")
public class Scl_model implements java.io.Serializable {
	
	/**
	 * in caso cancella
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_scl_model_gen")
	@SequenceGenerator(name = "seq_scl_model_gen", sequenceName = "SCL_MODEL_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name="SM_ID", nullable=false)
	private Integer sm_id;
	
	@Column(name="sm_description")
	private String sm_description;
	
	@Column(name="sm_external_id_template")
	private Integer sm_external_id_template;
	
	@Column(name="sm_flag_enabled")
	private Short sm_flag_enabled;
	
	public Scl_model() {
		super();
	}

	public Scl_model(String sm_description, Integer sm_external_id_template, Short sm_flag_enabled) {
		super();
		this.sm_description = sm_description;
		this.sm_external_id_template = sm_external_id_template;
		this.sm_flag_enabled = sm_flag_enabled;
	}

	public Integer getSm_id() {
		return sm_id;
	}

	public void setSm_id(Integer sm_id) {
		this.sm_id = sm_id;
	}

	public String getSm_description() {
		return sm_description;
	}

	public void setSm_description(String sm_description) {
		this.sm_description = sm_description;
	}

	public Integer getSm_external_id_template() {
		return sm_external_id_template;
	}

	public void setSm_external_id_template(Integer sm_external_id_template) {
		this.sm_external_id_template = sm_external_id_template;
	}

	public Short getSm_flag_enabled() {
		return sm_flag_enabled;
	}

	public void setSm_flag_enabled(Short sm_flag_enabled) {
		this.sm_flag_enabled = sm_flag_enabled;
	}
}