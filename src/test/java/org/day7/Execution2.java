package org.day7;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execution2 {

	@BeforeSuite
	private void BefSuite() {
		System.out.println("E2 BeforeSuite"+System.currentTimeMillis());
	}
	
	@BeforeTest
	private void BefTest() {
		System.out.println("E2 BeforeTest"+System.currentTimeMillis());
	}
	@BeforeClass
	private void BefClass() {
		System.out.println("E2 BeforeClass"+System.currentTimeMillis());
	}
	@BeforeMethod
	private void BefMethod() {
		System.out.println("E2 BeforeMethod"+System.currentTimeMillis());
	}
	
	@AfterMethod
	private void AfMethod() {
		System.out.println("E2 AfterMethod"+System.currentTimeMillis());
	}
	
	@AfterClass
	private void AfClass() {
		System.out.println("E2 AfterClass"+System.currentTimeMillis());
	}
	@AfterTest
	private void AfTest() {
		System.out.println("E2 AfterTest"+System.currentTimeMillis());
	}
	@AfterSuite
	private void AfSuite() {
		System.out.println("E2 AfterSuite"+System.currentTimeMillis());
	}
	@Test(priority =-5)
	private void meth3() {
		System.out.println("E2 print : 3"+System.currentTimeMillis());
	}
	@Test(priority =3)
	private void meth2() {
		System.out.println("E2 print : 2"+System.currentTimeMillis());
	}
	@Test(priority =2)
	private void meth1() {
		System.out.println("E2 print : 1"+System.currentTimeMillis());
	}
	
	

	
}
