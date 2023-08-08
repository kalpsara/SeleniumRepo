package week2.day2.assignments.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * Delete Lead: 1 Launch the browser 2 Enter the username 3 Enter the password 4
	 * Click Login 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8
	 * Click on Phone 9 Enter phone number 10 Click find leads button 11 Capture
	 * lead ID of First Resulting lead 12 Click First Resulting lead 13 Click Delete
	 * 14 Click Find leads 15 Enter captured lead ID 16 Click find leads button 17
	 * Verify message "No records to display" in the Lead List. This message
	 * confirms the successful deletion 18 Close the browser (Do not log out)
	 */

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		
		String firstId = driver
				.findElement(
						By.xpath("(//div[@id='findLeads']//div[contains(text(),'1 99')])[1]/ancestor::tr/td[1]//a"))
				.getText();
		System.out.println("Frst id" + firstId);
		driver.findElement(By.xpath("(//div[@id='findLeads']//div[contains(text(),'1 99')])[1]/ancestor::tr/td[1]//a"))
				.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String actualMessage = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(actualMessage);
		String expectedMessage = "No records to display";

		if (actualMessage.contains(expectedMessage))
			System.out.println("Deleted successfully!!!");
		else
			System.out.println("Delete failure");
		Thread.sleep(2000);
		
		driver.close();
		

	}

}
