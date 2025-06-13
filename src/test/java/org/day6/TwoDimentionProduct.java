package org.day6;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoDimentionProduct {

public static WebDriver driver;
	
	
	@Test(dataProvider="productData")
	private void meth1(String name, String model) {
		try {
			driver = new ChromeDriver();
			Robot r = new Robot();
			driver.get("https://www.flipkart.com/");
			WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
			search.sendKeys(name);
			search.sendKeys(Keys.chord(Keys.CONTROL,"a"),model);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.xpath("//img[@loading='eager']"));
		for(WebElement li:list) {
			String text = li.getText();
			boolean contains = text.contains(model);

			
			if (contains==false) {
				System.out.println(text);
				System.out.println(contains);
			}
		
			
		}
		
		}
	
	
	
	@DataProvider(name="productData")
	private Object[][] data() {
		return new Object[][] {
			
			{
				"Bike","Ampere"
			
			},
			{
				"Pendrive","HP"
			},

			{
				"Phone","Vivo"
			}
			
			
			
		};
	}
	
}
	
	

