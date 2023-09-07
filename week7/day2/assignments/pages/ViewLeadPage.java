package week7.day2.assignments.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class ViewLeadPage extends ProjectSpecificMethod{
	
	public LeadsPage clickDeleteLead() {
		
		driver.findElement(By.linkText("Delete")).click();
		return new LeadsPage();
	}
	
	public EditLeadPage clickEditLead() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		
		WebElement editButton = driver.findElement(By.linkText("Edit"));
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.click();
		return new EditLeadPage();
	}
	
	public DuplicateLeadPage clickDuplicateLead() {
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage();
		
	}
	
	

}
