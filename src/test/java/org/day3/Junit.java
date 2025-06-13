package org.day3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Junit {
	public static WebDriver driver;
	@BeforeClass
	public static void SetBrowser() {
		WebDriverManager.chromedriver().setup();
	}
	@Before
	public void LaunchPage() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void Search() {
		WebElement name = driver.findElement(By.xpath("//input[@name='username']"));
		name.sendKeys("MrKingOfCloud");
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("Mega@199800");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		WebElement location = driver.findElement(By.xpath("//select[@name='location']"));
		Select s = new Select(location);
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
		driver.findElement(By.name("radiobutton_0")).click();
		driver.findElement(By.name("continue")).click();
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
	@After
	public void OrderId() {
		
		String a="9O4V6GBLK5"; 
		String e="SC7BMJK89Y";
		Assert.assertNotSame(e, a);
		System.out.println("Not Equal");
		
	}
	@AfterClass
	public static void math5() throws InterruptedException {
		Thread.sleep(3000);
		//driver.close();
	}
}
