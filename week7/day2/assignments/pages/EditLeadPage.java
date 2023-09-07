package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class EditLeadPage extends ProjectSpecificMethod{
	public EditLeadPage enterCompanyName() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("SSDUM_updated");
		return this;
	}

	/*
	 * public EditLeadPage enterfirstName(String fname) {
	 * driver.findElement(By.id("updateLeadForm_firstName")).sendKeys(fname);
	 * 
	 * return this; }
	 * 
	 * public EditLeadPage enterlastName(String lname) {
	 * driver.findElement(By.id("updateLeadForm_lastName")).sendKeys(lname); return
	 * this; }
	 */
	
	public ViewLeadPage clickUpdate() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}

}
