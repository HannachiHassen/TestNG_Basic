package com.assertJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AssertJDemo {
	
	@Test
	public void stringTest() {
		String temp="Hello World";
		String a = "";
		String b= "  ";
		
		Assertions.assertThat(temp)
			.isNotNull()
			.as("String is actually empty").isNotEmpty()
			.as("String is actually blank").isNotBlank()
			.isEqualTo("Hello World")
			.contains("Hello")
			.doesNotContain("Hi")
			.containsWhitespaces()
			.containsIgnoringCase("world")
			.matches("\\w.*"+"World")
			.doesNotContainPattern("\\d.*")
			.hasSize(11)
			.hasSizeGreaterThanOrEqualTo(10)
			.hasSizeLessThan(20)
			.hasSizeBetween(10,20)
			.endsWith("World")
			.isInstanceOf(String.class);
	}
	
	@Test
	public void numberTest() {
		int a=10;
		
		Assertions.assertThat(a)
		.isEqualByComparingTo(null)
		.isEqualTo(10)
		.isCloseTo(14, Offset.offset(5))
		.isInstanceOf(Integer.class)
		.isBetween(null, null)
		.isCloseTo(12, Percentage.withPercentage(30))
		.isNotCloseTo(15, Percentage.withPercentage(30))
		.isPositive()
		.isEven()
		.isGreaterThan(5)
		.isLessThan(3)
		.isLessThanOrEqualTo(20);		
	}
	@Test
	public void listTest() {
		List<String> list= Arrays.asList("Testing","Mini","Bytes");
		List<String> list2=Arrays.asList("Testing","Mini");
		List<String> list3=Arrays.asList("Automation","selenium");
		
		Assertions.assertThat(list)
		.hasSize(2)
		.hasAtLeastOneElementOfType(String.class)
		.isNotEmpty()
		.contains("Testing")
		.doesNotContain("Automation")
		.startsWith("Testing")
		.containsExactlyInAnyOrder("Mini","Testing","Bytes")
		.containsAll(list2)
		.doesNotContainAnyElementsOf(list3)
        .withFailMessage(()-> "String is not having size less than 3").allMatch(s->s.length(3));
	}
	@Test
	public void mapTest() {
		Map<String, String> map= new HashMap<>();
		
		map.put("Testing","Mini");
		map.put("channel","Testing mini bytes");
		
		Assertions.assertThat(map)
		.hasSize(3)
		.containsEntry("name", "Amuthan")
		.isNotEmpty()
		.doesNotContainEntry("fav","football")
		.doesNotContainKey("Game")
		.containsKeys("channel")
		.containsValue("cricket");
	}
	@Test
	public void customerClassTest() {
		Employee emp1= new Employee(25, "sachin", 100);
		Employee emp2= new Employee(25, "sachin", 100);
		
		Assertions.assertThat(emp1)
		.isEqualToComparingFieldByField(emp2)
		.isNotNull()
		.isInstanceOf(Employee.class)
		.hasFieldOrProperty("age")
		.hasFieldOrPropertyWithValue("name", "sachin")
		.extracting(e -> e.age).isNotEqualTo(24);		
	}
}
