package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class TestNG_factoryClass {
	@Factory
	public Object[] factoryMethod() {
		Object[] data = new Object[5];

		data[0] = new TestNG_factory(10);
		data[1] = new TestNG_factory(20);
		data[2] = new TestNG_factory(30);
		data[3] = new TestNG_factory(40);
		data[4] = new TestNG_factory(50);
		return data;
	}

	@Factory()
	public Object[] factoryClasses() {
		Object[] tests = new Object[2];
		tests[0] = new TestNG_enable();
		tests[1] = new TestNG_priority();
		return tests;
	}

	@Factory(dataProvider = "dp")
	public Object[] getTestClasses(String s) {
		Object[] tests = new Object[1];

		tests[0] = new TestNG_factoryDataProvider(s);

		return tests;
	}

	@DataProvider
	public Object[] dp() {
		return new Object[] { "A", "B" };
	}
}
