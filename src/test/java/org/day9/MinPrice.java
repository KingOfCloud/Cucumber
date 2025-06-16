package org.day9;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MinPrice {
	
	WebDriver driver;
	int total;
	
	@Test(priority=1)
	public void Lauch() {
		
		driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	public void list() {
		driver.findElement(By.name("q")).sendKeys("Pendrive",Keys.ENTER);
		List<WebElement> productList = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
		 Map<Integer, WebElement> map = new HashMap<>();

	        for (int i = 0; i < priceList.size(); i++) {
	            String priceText = priceList.get(i).getText().trim().replaceAll("[^0-9]", "");
	                int price = Integer.parseInt(priceText);
	                map.put(price, productList.get(i));
	        }

	        		//Minimum Price
	        Set<Integer> keys = map.keySet();
	       int minPrice = Collections.min(keys);  
	        WebElement minPriceElement = map.get(minPrice);

	        System.out.println("Cheapest Product: " + minPriceElement.getText());
	        System.out.println("Minimum Price: ₹" + minPrice);

	        minPriceElement.click();
	        
	        		//Maximum Price
	        Set<Integer> keys1 = map.keySet();
		       int maxPrice = Collections.max(keys1);  
		        WebElement maxPriceElement = map.get(maxPrice);

		        System.out.println("Cheapest Product: " + maxPriceElement.getText());
		        System.out.println("Maximum Price: ₹" + maxPrice);

		        maxPriceElement.click();
		        
		        		//Average Price
		        for (int i = 0; i < priceList.size(); i++) {
		            String priceText = priceList.get(i).getText().trim().replaceAll("[^0-9]", "");
		                int price = Integer.parseInt(priceText);
		                total +=price;
		                map.put(price, productList.get(i));
		        }
		        System.out.println("Total amount of Product is:"+ total);
		        int average = total / priceList.size();
		        System.out.println("Average price is: ₹" + average);
		        
		        int nearestprice = 0;
		        int minDiff = Integer.MAX_VALUE;
		        
		        for (Integer price : map.keySet()) {
		        	int diff = price - average;
		        	if (diff<0) {
		        	diff = -diff;
		        }
		        
		        if (diff < minDiff) {
		        	minDiff = diff;
		        	nearestprice = price;
		        }			    
		    }

			   WebElement product = map.get(nearestprice);
			   System.out.println("Averag: ₹" +nearestprice);
			   System.out.println("Product Name: "+ product.getText());
	}
	
	
	}
	
	






