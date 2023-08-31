package week6.day2.assignments;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lead extends LeadBase {
	SoftAssert softassert=new SoftAssert();
	@Test(dataProvider = "dataProvider", priority = -3, invocationCount = 2, enabled = true, groups = "Smoke")
	public void createLead(String... data) {

		driver.findElement(By.linkText("Create Lead")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Create Lead | opentaps CRM";
		//String expectedTitle = "Create Lead";
		//Assert.assertEquals(actualTitle, expectedTitle);//hard assertion
		softassert.assertEquals(actualTitle, expectedTitle);//soft assertion
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(data[0]);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(data[1]);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(data[2]);
		driver.findElement(By.name("submitButton")).click();
		softassert.assertAll();
	}

	@Test(dataProvider = "dataProvider", priority = -2, enabled = true, dependsOnMethods = {
			"createLead" }, groups = "Smoke")
	public void editLead(String... data) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.name("submitButton")).click();

	}

	@Test(dataProvider = "dataProvider", priority = -1, enabled = true, dependsOnMethods = { "createLead" })
	public void duplicateLead(String... data) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();

	}

	@Test(dataProvider = "dataProvider", priority = 1, enabled = true, dependsOnMethods = {
			"createLead" }, groups = "Rgression", dependsOnGroups = "Smoke")
	public void deleteLead(String... data) throws InterruptedException {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}

	}

	@BeforeTest(alwaysRun = true)
	private void setFileName() {

		setFileName("Lead.xlsx");

	}
}
