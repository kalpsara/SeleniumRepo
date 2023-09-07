package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod{
	
	
	public LoginPage enterUsername() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		return this; 
	}
	
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}

	public WelcomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
        return new WelcomePage();
	}

}
