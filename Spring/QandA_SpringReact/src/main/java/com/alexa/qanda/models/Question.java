package com.alexa.qanda.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, max=1024, message="Question can't be blank.")
	private String text;
	
	public Question() {
		
	}

	public Question(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
