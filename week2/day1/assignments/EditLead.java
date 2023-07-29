package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf_Version4");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("kalpana");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("venkatraman");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("kalps");
		driver.findElement(By.name("departmentName")).sendKeys("QA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium tester editing");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("venkatraman.kalpana@gmail.com");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Leading editing is done");
		//driver.findElement(By.name("submitButton")).click();
		//Since both update and add button have same locator class,name ,used cssSelector to differentiate
		driver.findElement(By.cssSelector("input[class=smallSubmit][name=submitButton][value=Update]")).click();
		
		System.out.println(driver.getTitle()	);
		
		//submitButton
		
		//updateLeadForm_description

	}

}
