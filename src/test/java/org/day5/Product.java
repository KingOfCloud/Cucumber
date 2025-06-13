package org.day5;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Product {

	public static WebDriver driver;
	
	@Test
	private void Data() {
		System.out.println("245");
	}
	
	@BeforeClass
	private void Search() {

		try {
			driver = new ChromeDriver();
			driver.get("https://www.snapdeal.com/");
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@org.testng.annotations.Parameters({"product"})
	@Test
	private void SearchProduct(String prodName) {
		WebElement search = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		search.sendKeys(prodName);
		driver.findElement(By.className("searchTextSpan")).click();
	}
	
	
	
	
	
	
	
	
}
