package com.sscvocab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sscvocab.model.Vocab;
import com.sscvocab.repo.VocabRepo;

@Service
public class VoacabServiceImpl implements VocabService {
	
		@Autowired
		VocabRepo vocabrepo;
		
		@Override
		public List<Vocab> getAllVocab() {
			return vocabrepo.findAll();
		}
		
		@Override
		public void saveVocab(Vocab vocab) {
			vocabrepo.save(vocab);
		}

		@Override
		public Vocab findByWord(String word) {
			List<Vocab> list = vocabrepo.findAll();
			for(Vocab a:list) {
				if(word.equalsIgnoreCase(a.getWord())) return a;
			}
			return null;
		}
}
