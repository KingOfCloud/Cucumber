package org.day8;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Shopping {
	public static WebDriver driver;
	
	@Test(priority=1,groups= {"smoke","launch"})
		private void launch() {
		driver=new ChromeDriver();
		driver.get("https://advantageonlineshopping.com/");
		//driver.manage().window().maximize();
		driver.findElement(By.id("menuUser")).click();
	}
	@Test(priority=2,groups= {"smoke","username"},dependsOnGroups="launch")
	private void username() {
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("MrKingOfCloud");
				
	}
	@Test(priority=3,groups= {"regression","password"},dependsOnGroups="username")
	private void password() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("password")).sendKeys("Mega@199800");
	}
	@Test(priority=4,groups= {"regression","login"},dependsOnGroups="password")
	private void login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("sign_in_btn")).click();
	}
	@Test(priority=5,groups= {"sanity","product"},dependsOnGroups="login")
	private void product() {
	
		driver.findElement(By.xpath("//div[@id='laptopsImg']")).click();
		driver.findElement(By.xpath("(//img[@class='imgProduct'])[2]")).click();

	}
	@Test(priority=6,groups= {"sanity","addtocart"},dependsOnGroups="product")
		private void addtocart() {
		WebElement e = driver.findElement(By.xpath("(//h1[text()=' HP CHROMEBOOK 14 G1(ES) '])[2]"));
		String expected = e.getText();
		System.out.println("Expected Product Name :"+expected);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement cart = driver.findElement(By.name("save_to_cart"));
		cart.click();
		driver.findElement(By.id("menuCart")).click();
		
		WebElement a = driver.findElement(By.xpath("//label[text()='HP CHROMEBOOK 14 G1(ES)']"));
		String actual = a.getText();
		System.out.println("Actual Product Name :"+actual);
		if (actual.equals(expected)) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("checkOutButton")).click();
			System.out.println("Our Product is correct");
			
		} 
		else {
			driver.findElement(By.xpath("//a[text()='REMOVE']")).click();
			System.out.println("Product is Wrong so I remove from cart");
		}
		driver.findElement(By.id("next_btn")).click();
	}
	@Test(priority=7,groups= {"final","address"},dependsOnGroups="addtocart")
	private void address() {
		WebElement user = driver.findElement(By.name("safepay_username"));
		WebElement pass = driver.findElement(By.name("safepay_password"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test(priority=8,groups= {"finish","payment"},dependsOnGroups="address")
	private void payment() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("pay_now_btn_SAFEPAY")).click();
		System.out.println("payment is Done");

	}
	
	}
	
	
	
	

