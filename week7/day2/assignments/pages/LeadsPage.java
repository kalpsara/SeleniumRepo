package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class LeadsPage extends ProjectSpecificMethod{
	
	public CreateLeadPage createLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();
	}
	public FindLeadPage findLead() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadPage();
		
	}
	public MergeLeadPage mergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLeadPage();
	}

}
