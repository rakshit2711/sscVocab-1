package com.sscvocab.services;

import java.util.List;

import com.sscvocab.model.Vocab;

public interface VocabService {

	List<Vocab> getAllVocab();

	void saveVocab(Vocab vocab);
	Vocab findByWord(String word) ;

}
