package com.sscvocab;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SscVocab1ApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(()->{
			SscVocab1Application.main(new String[] {});
		});
	}

}
