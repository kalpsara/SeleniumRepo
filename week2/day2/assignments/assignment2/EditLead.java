package week2.day2.assignments.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {
	/*http://leaftaps.com/opentaps/control/main
	
	* 1	Launch the browser
	* 2	Enter the username
	* 3	Enter the password
	* 4	Click Login
	* 5	Click crm/sfa link
	* 6	Click Leads link
	* 7	Click Find leads
	* 8	Enter first name
	* 9	Click Find leads button
	* 10 Click on first resulting lead
	* 11 Verify title of the page
	* 12 Click Edit
	* 13 Change the company name
	* 14 Click Update
	* 15 Confirm the changed name appears
	* 16 Close the browser (Do not log out)*/

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//div[@id='findLeads']//input[@name='firstName']")).sendKeys("Kalpana");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='findLeads']//a[contains(text(),'kalpana')])[1]/ancestor::tr/td[1]//a")).click();
		String expectedTitle="View Lead | opentaps CRM";
		String actualTitle=driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);
		String latestCompanyName="Testleaf software solutions";
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(latestCompanyName);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedeCompanayName=driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		if(updatedeCompanayName.contains(latestCompanyName))
			System.out.println("Updated Company name appears");
		else
			System.out.println("Company name not updated properly");
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
