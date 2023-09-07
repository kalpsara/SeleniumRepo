package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class DuplicateLeadPage extends ProjectSpecificMethod{

	
	public ViewLeadPage clickCreateLeadToDuplicate() {
		
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}

}
