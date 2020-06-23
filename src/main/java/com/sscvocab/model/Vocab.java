package com.sscvocab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vocab database table.
 * 
 */
@Entity
@NamedQuery(name="Vocab.findAll", query="SELECT v FROM Vocab v")
public class Vocab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String meaning;

	private String word;


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}