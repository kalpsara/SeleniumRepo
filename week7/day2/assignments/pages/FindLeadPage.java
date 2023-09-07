package week7.day2.assignments.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import week7.day2.assignments.base.ProjectSpecificMethod;

public class FindLeadPage extends ProjectSpecificMethod {

	public FindLeadPage enterFirstName() {
		WebElement firstName = driver.findElement(By.xpath(
				"//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']//input[@name='firstName']"));
		firstName.clear();
		firstName.sendKeys("k");
		return this;

	}

	public FindLeadPage findLeadWithFieldsEntered() {

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}

	public ViewLeadPage clickLeadList() throws InterruptedException {
		System.out.println("Inside clickLeadList");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement firstRecord = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		wait.until(ExpectedConditions.elementToBeClickable(firstRecord));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", firstRecord);
		//firstRecord.click();
		return new ViewLeadPage();

	}

}
