package com.sscvocab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sscvocab.services.VocabService;

@RestController
public class HomeController {
	
	@Autowired
	VocabService vocabService;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		return new ModelAndView("home");
	}
	
	@GetMapping("/vocab")
	public ModelAndView vocab() {
		return new ModelAndView("vocab");
	}
	
	@GetMapping("/vocabMeaning")
	public ModelAndView questionVocab() {
		return new ModelAndView("vocabMeaning");
	}
}
