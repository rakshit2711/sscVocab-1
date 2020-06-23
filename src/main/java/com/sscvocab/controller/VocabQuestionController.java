package com.sscvocab.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sscvocab.model.Vocab;
import com.sscvocab.services.VocabService;

@RestController
public class VocabQuestionController {

	private static final Logger logger = LoggerFactory.getLogger(VocabQuestionController.class);

	@Autowired
	VocabService vocabService;

	@GetMapping("/vocab/question")
	public List<Vocab> getAllVocabQuestoion() {
		return vocabService.getAllVocab();
	}

	@GetMapping("/vocab/addword")
	public ModelAndView addVocabPage() {
		return new ModelAndView("addword");
	}

	@GetMapping("/vocab/result")
	public ModelAndView reultPage() {
		return new ModelAndView("/result");
	}

	@PostMapping(path = "/vocab/addword", consumes = "application/x-www-form-urlencoded")
	public ModelAndView addVocab(@RequestParam Map<String, String> model) {
		Vocab vocab = new Vocab();
		String word = model.get("word");
		String meaning = model.get("meaning");
		if (!word.equals("") && !meaning.equals("")) {
			vocab.setWord(toUpperFirstChar(word));
			vocab.setMeaning(toUpperFirstChar(meaning));
			Vocab copy = vocabService.findByWord(vocab.getWord());
			if (copy == null) {
				vocabService.saveVocab(vocab);
				word = String.format("%1$s will be added", vocab.getWord());
				logger.info(word);
			} else {
				word = String.format("%1$s will not be added", vocab.getWord());
				logger.info(word);
			}
		}
		else {
			word="Either word or meaning is empty";
			logger.error(word);
		}
		return new ModelAndView("redirect:/vocab/addword");
	}

	private String toUpperFirstChar(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
