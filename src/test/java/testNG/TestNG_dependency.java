package testNG;

import org.testng.annotations.Test;

public class TestNG_dependency {
	@Test
	public void login() {
		System.out.println("Login page");
	}

	@Test(dependsOnMethods = "login")
	public void home() {
		System.out.println("Home page");

	}
}
