package org.day8;

import org.testng.annotations.Test;

public class GroupsEx {

	@Test(groups= {"smoke"})
	private void meth1() {
		System.out.println("Api");
	}
	
	@Test(groups= {"smoke","regression"})
	private void meth2() {
		System.out.println("Appium");
	}
	
	@Test(groups= {"sanity"})
	private void meth3() {
		System.out.println("Selenium");
	}
	
	@Test(groups= {"basic"})
	private void meth4() {
		System.out.println("Java");
	}
	
	@Test(groups= {"advanced"})
	private void meth5() {
		System.out.println("Framework");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
