package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {
	public LeadsPage clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new LeadsPage();
	}

}
