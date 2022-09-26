package com.assertJ;

import org.testng.annotations.Test;
import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;


public class AssertJSoftAssertion {
	@Test
	public void assertSoftlyTest() {
		SoftAssertions softly=new SoftAssertions();
		
		softly.assertThat("Hello World")
		    .isNotEmpty()
		    .hasSize(5)
		    .contains("Hello");
		
		System.out.println("Hi");
		softly.assertAll();
	}
	
	@Test
	public void assertBDDStyleTest() {
		BDDAssertions.then("Hello World")
		.hasSize(0)
		.containsIgnoringCase("hello");	
	}
}
