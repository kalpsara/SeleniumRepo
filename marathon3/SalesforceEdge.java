package marathon3;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesforceEdge extends SalesforceBase {


	@Test(dataProvider = "dataProvider")

	public void loginSalesforce(String... data) throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(data[0]);
		driver.findElement(By.id("password")).sendKeys(data[1]);

		driver.findElement(By.name("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();

		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement keyDealsTrigger = driver.findElement(By.xpath("//span[text()='View All Key Deals']/parent::a"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(keyDealsTrigger));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", keyDealsTrigger);

		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following-sibling::div/input"))
				.sendKeys(data[4]);

		driver.findElement(By.xpath("//button[contains(@aria-label,'Type')]")).click();

		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		WebElement leadSource = driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Source')]"));
		js.executeScript("arguments[0].click()", leadSource);

		WebElement partnerReferral = driver.findElement(By.xpath("//span[text()='Partner Referral']"));
		wait.until(ExpectedConditions.visibilityOf(partnerReferral));
		js.executeScript("arguments[0].click()", partnerReferral);

		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(data[5]);
		
		Date dt = new Date();
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, 1);
		dt = calendar.getTime();
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt);
		
		WebElement tomDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		tomDate.sendKeys(tommorowsDate);
		WebElement stage = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage,')]"));
		stage.click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		
		WebElement primaryCampaignSource = driver.findElement(By.xpath("//label[text()='Primary Campaign Source']/following::input"));
		wait.until(ExpectedConditions.elementToBeClickable(primaryCampaignSource));
		js.executeScript("arguments[0].click()", primaryCampaignSource);
		//primaryCampaignSource.click();
		List<WebElement> campaignList = driver.findElements(By.xpath("//ul[contains(@aria-label,'Recent Campaigns')]//span[@class='slds-truncate']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(campaignList));
		campaignList.get(0).click();
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		List<WebElement> verifyOpportunity = driver.findElements(By.xpath("//records-highlights-details-item"));
		for(WebElement e:verifyOpportunity) {
			System.out.println(e.getText());
		}
	}

	@BeforeTest
	private void setFileName() {
		setFileName("Salesforce.xlsx");
	}

}
