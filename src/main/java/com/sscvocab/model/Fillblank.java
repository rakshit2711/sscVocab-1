package com.sscvocab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fillblanks database table.
 * 
 */
@Entity
@Table(name="fillblanks")
@NamedQuery(name="Fillblank.findAll", query="SELECT f FROM Fillblank f")
public class Fillblank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String answer;

	private String question;

	public Fillblank() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}