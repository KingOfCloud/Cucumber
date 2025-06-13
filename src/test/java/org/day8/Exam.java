package org.day8;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Exam {

	public static WebDriver driver;
	public static Scanner sc= new Scanner(System.in);
	
	@Test(groups= {"smoke","launch"},priority=1)
	private void Launch() throws InterruptedException {
		driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		WebElement login = driver.findElement(By.xpath("//a[@title='Login']"));
		a.moveToElement(login).perform();
		WebElement signin = driver.findElement(By.xpath("//span[@class='_1Mikcj']"));
		a.click().perform();
		
		
	}
	
	@Test(groups= {"regression","login"},priority=2,dependsOnGroups= {"launch"})
	private void Login() {
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("9698413982");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Lenovo",Keys.ENTER);
		driver.findElement(By.xpath("//div[@data-id='COMGSVFETYUGZUHR']")).click();
		WebElement addtocart = driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']"));
		addtocart.click();
	}
	
	@Test(groups= {"sanity"},priority=3,dependsOnGroups= {"login"})
	private void Search() {
		

		
	
	}
	
	@Test
	private void meth4() {
		
	}
	
	
	
	
	
	
	
	
	
}
