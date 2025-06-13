package org.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleParameters {

	public static WebDriver driver;
	
	@org.testng.annotations.Parameters({"url"})
	@Test
	private void meth1(String ul) {
		
		driver = new ChromeDriver();
		driver.get(ul);
	}
	
	@Parameters({"user","pass"})
	@Test
	private void meth2(String user,String pass) {

		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login")).click();


	}
	
	
	
}
