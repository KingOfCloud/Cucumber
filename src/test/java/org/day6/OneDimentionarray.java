package org.day6;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OneDimentionarray {

	public static WebDriver driver;
	
	
	@Test(dataProvider="productData")
	private void ProductSearch(String prodName) throws AWTException {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys(prodName);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='slAVV4']"));
		for (WebElement li:list) {
			String text = li.getText();
			//System.out.println(text);
			boolean contains = text.contains(prodName);
			
			if( contains == false) {
				System.out.println(text);
				//System.out.println(contains);
			}
		}
	}
	
	@DataProvider(name="productData")
	private Object[] data() {

		return new Object[] {
				"Pen","Pendrive"
				
		};
	}
	
	

	
}
