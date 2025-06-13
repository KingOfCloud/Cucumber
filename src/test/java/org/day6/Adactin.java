package org.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Adactin {

	public static WebDriver driver;
	
	
	@Test(dataProvider="credentials")
	private void meth1(String user,String pass) {
		try {
			driver = new ChromeDriver();
			driver.get("https://adactinhotelapp.com/index.php");
			driver.findElement(By.id("username")).sendKeys(user);
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.id("login")).click();
			WebElement error = driver.findElement(By.className("auth_error"));
			System.out.println(error.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@DataProvider(name="credentials")
	private Object[][] cred() {
		return new Object[][] {
			
			{
				"megauser","megapass"
			},
			{
				"gayuuser","gayupass"
			},
			{
				"saiuser","saipass"
			},
			
			
			
		};
	}
}
