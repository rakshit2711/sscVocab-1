package com.sscvocab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sscvocab.services.VocabService;

@RestController
public class HomeController {
	
	@Autowired
	VocabService vocabService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home() {
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/vocab",method=RequestMethod.GET)
	public ModelAndView vocab(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vocabques", vocabService.getAllVocab());
		return new ModelAndView("/vocab");
	}
	
	@RequestMapping(value="/questionvocab",method=RequestMethod.GET)
	public ModelAndView questionVocab(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vocabques", vocabService.getAllVocab());
		return new ModelAndView("/questions");
	}
}
