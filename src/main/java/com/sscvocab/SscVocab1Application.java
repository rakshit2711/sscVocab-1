package com.sscvocab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sscvocab.controller.VocabQuestionController;

@SpringBootApplication
public class SscVocab1Application {
	private static final Logger logger = LoggerFactory.getLogger(SscVocab1Application.class);
	public static void main(String[] args) {
		logger.info("Starting Logger");
		SpringApplication.run(SscVocab1Application.class, args);
	}

}
