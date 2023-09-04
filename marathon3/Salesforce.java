package marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Salesforce extends SalesforceBase {


	@Test(dataProvider = "dataProvider")
	public void loginSalesforce(String... data) throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(data[0]);
		driver.findElement(By.id("password")).sendKeys(data[1]);

		driver.findElement(By.name("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();

		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Content");
		driver.findElement(By.xpath("//p[text()='Salesforce CRM Content']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']/parent::a"));
		wait.until(ExpectedConditions.visibilityOf(chatter));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Chatter']/parent::a")));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Chatter Home | Salesforce";

		Assert.assertEquals(actualTitle, expectedTitle);

		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(data[2]);
		driver.findElement(By.xpath("//div[@data-placeholder='If you have more to say, add details here...']"))
				.sendKeys(data[3]);
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		
		String displayedQuestion=driver.findElement(By.xpath("//div[contains(@class,'forceChatterFeedBodyQuestionWithoutAnswer')]/span[@data-aura-class='uiOutputText']")).getText();
		String questionAsked="What's your hobby?";
		Assert.assertEquals(displayedQuestion, questionAsked);
		System.out.println("*********");
	
	}

	@BeforeTest
	private void setFileName() {
		setFileName("Salesforce.xlsx");
	}

}
