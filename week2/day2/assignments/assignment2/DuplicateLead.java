package week2.day2.assignments.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DuplicateLead {
	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
	 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Click on Email
	 * ////span[text()='Email'] 9 Enter Email //input[@name='emailAddress'] 10 Click
	 * find leads button
	 * driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 * Thread.sleep(2000); 11 Capture name of First Resulting lead
	 * 
	 * 12 Click First Resulting lead 13 Click Duplicate Lead 14 Verify the title as
	 * 'Duplicate Lead' 15 Click Create Lead 16 Confirm the duplicated lead name is
	 * same as captured name 17 Close the browser (Do not log out)
	 * 
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
		Thread.sleep(2000);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("venkatraman.kalpana@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String firstName = driver.findElement(By.xpath(
				"(//div[@id='findLeads']//a[contains(text(),'venkatraman.kalpana@gmail.com')])[1]/ancestor::tr/td[3]//a"))
				.getText();
		System.out.println("First Lead name is" + firstName);
		driver.findElement(By.xpath(
				"(//div[@id='findLeads']//a[contains(text(),'venkatraman.kalpana@gmail.com')])[1]/ancestor::tr/td[3]//a"))
				.click();

		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);
		String expectedTitle = "Duplicate Lead | opentaps CRM";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);
		String firstName_sp = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if (firstName_sp.equals(firstName))
			System.out.println("Duplicated");
		else
			System.out.println("not duplicated");
		Thread.sleep(2000);
		driver.close();

	}

}
