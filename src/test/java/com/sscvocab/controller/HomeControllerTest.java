package com.sscvocab.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHome() {
		assertEquals("home", new HomeController().home().getViewName());
	}

	@Test
	void testVocab() {
		assertEquals("vocab", new HomeController().vocab().getViewName());
	}

	@Test
	void testQuestionVocab() {
		assertEquals("questions", new HomeController().questionVocab().getViewName());
	}

}
