package org.day8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class GroupProd {

	public static WebDriver driver;
	
	@Test(groups= {"smoke","browser"},priority=1)
	private void Launch() {
		
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.findElement(By.name("username")).sendKeys("MrKingOfCloud");
		driver.findElement(By.id("password")).sendKeys("Mega@199800");
		driver.findElement(By.xpath("//input[@type='Submit']")).click();
		
		}
	
	@Test(groups= {"smoke","regression"},priority=2,dependsOnGroups="browser")
	private void Search() {
		
		WebElement loc = driver.findElement(By.xpath("//select[@name='location']"));
		Select s= new Select(loc);
		s.selectByIndex(5);
		WebElement hotel = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select s1 = new Select(hotel);
		s1.selectByIndex(2);
		WebElement rt = driver.findElement(By.xpath("//select[@name='room_type']"));
		Select s2 = new Select(rt);
		s2.selectByIndex(1);
		WebElement rno = driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select s3 = new Select(rno);
		s3.selectByIndex(1);
		WebElement checkin = driver.findElement(By.xpath("(//input[@class='date_pick'])[1]"));
		checkin.sendKeys("15/05/2025");
		WebElement checkout = driver.findElement(By.xpath("(//input[@class='date_pick'])[2]"));
		checkout.sendKeys("16/05/2025");
		WebElement adults = driver.findElement(By.name("adult_room"));
		Select s4 = new Select(adults);
		s4.selectByIndex(1);
		WebElement child = driver.findElement(By.xpath("//select[@name='child_room']"));
		Select s5 =new Select(child);
		s5.selectByIndex(0);
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
		
}
	
	@Test(groups= {"sanity"},priority=3,dependsOnGroups= "smoke")
	private void Enter() {

		driver.findElement(By.name("radiobutton_0")).click();
		driver.findElement(By.name("continue")).click();
		
	}
	
	@Test(groups= {"payment"},priority=4,dependsOnGroups="sanity")
	
	private void BookHotel() {

		WebElement fn = driver.findElement(By.xpath("(//input[@class='reg_input'])[1]"));
		fn.sendKeys("Raj");
		WebElement ln = driver.findElement(By.xpath("(//input[@class='reg_input'])[2]"));
		ln.sendKeys("N");
		WebElement bill = driver.findElement(By.className("txtarea"));
		bill.sendKeys("ajkdhy");
		WebElement cc = driver.findElement(By.xpath("(//input[@class='reg_input'])[3]"));
		cc.sendKeys("2451368954721634");
		WebElement cct = driver.findElement(By.xpath("//select[@name='cc_type']"));
		Select s6=new Select(cct);
		s6.selectByIndex(2);
		WebElement em = driver.findElement(By.xpath("(//select[@class='select_combobox2'])[1]"));
		Select s7=new Select(em);
		s7.selectByIndex(3);
		WebElement ey = driver.findElement(By.xpath("(//select[@class='select_combobox2'])[2]"));
		Select s8=new Select(ey);
		s8.selectByIndex(3);
		WebElement cvv = driver.findElement(By.xpath("(//input[@class='reg_input'])[4]"));
		cvv.sendKeys("2451");
		driver.findElement(By.id("book_now")).click();
		
	}
	
	
	
	
	

	
}
