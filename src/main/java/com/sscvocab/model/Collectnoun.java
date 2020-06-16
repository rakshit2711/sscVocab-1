package com.sscvocab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the collectnoun database table.
 * 
 */
@Entity
@NamedQuery(name="Collectnoun.findAll", query="SELECT c FROM Collectnoun c")
public class Collectnoun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String collection;

	private String noun;

	public Collectnoun() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollection() {
		return this.collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getNoun() {
		return this.noun;
	}

	public void setNoun(String noun) {
		this.noun = noun;
	}

}