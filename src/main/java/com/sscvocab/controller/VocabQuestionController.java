package com.sscvocab.controller;

import java.text.Normalizer.Form;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sscvocab.SscVocab1Application;
import com.sscvocab.model.Vocab;
import com.sscvocab.services.VocabService;

@RestController
public class VocabQuestionController {

	private static final Logger logger = LoggerFactory.getLogger(VocabQuestionController.class);
	
	@Autowired
	VocabService vocabService;
	@RequestMapping(value = "/vocab/question",method = RequestMethod.GET)
	public List<Vocab> getAllVocabQuestoion(){
		return vocabService.getAllVocab();
	}
	@RequestMapping(value = "/vocab/addword",method = RequestMethod.GET)
	public ModelAndView addVocabPage(){
		return new ModelAndView("/addword");
	}
	
	
	@RequestMapping(value = "/vocab/result",method = RequestMethod.GET)
	public ModelAndView reultPage(){
		return new ModelAndView("/result");
	}
	
	
	@RequestMapping(value = "/vocab/addword",method = RequestMethod.POST,
			  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addVocab(@RequestParam LinkedHashMap<String, String> model){
		Vocab vocab=new Vocab();
		vocab.setWord(toUpperFirstChar(model.get("word")));
		vocab.setMeaning(toUpperFirstChar(model.get("meaning")));
		Vocab copy=vocabService.findByWord(vocab.getWord());
		if(copy==null ) {
			vocabService.saveVocab(vocab);
			logger.info(vocab.getWord()+" will be added");
		}
		else {
			logger.info(vocab.getWord()+" will not be added");
		}
		
		return new ModelAndView("redirect:/vocab/addword");
	}
	
	private String toUpperFirstChar(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
