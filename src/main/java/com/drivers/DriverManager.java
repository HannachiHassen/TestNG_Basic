package com.drivers;

import org.openqa.selenium.WebDriver;
import java.util.Objects;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 *
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see Driver
 */

public final class DriverManager {
	/**
	 * private constructor to avoid external instantiation
	 */
	private  DriverManager() {}

	private static ThreadLocal<WebDriver> dr=new ThreadLocal<>();
	

	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 * @author Hassen
	 * Sep 10, 2022
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 */
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	/**
	 * Set the WebDriver instance to thread local variable
	 * @author Hassen
	 * Sep 10, 2022
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.
	 */

	static void setDriver(WebDriver driverref) {
		if (Objects.nonNull(driverref)) {
			dr.set(driverref);			
		}		 
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Hassen
	 * Sep 10, 2022
	 */

	static void unload() {
		dr.remove(); 
	}	
}
