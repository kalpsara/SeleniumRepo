package week2.day2.assignments.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Contact")).click();

		driver.findElement(By.id("firstNameField")).sendKeys("kalpana");
		driver.findElement(By.id("lastNameField")).sendKeys("Saravanakumar");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("kalps");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("sara");

		driver.findElement(By.name("departmentName")).sendKeys("tester");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Selenium tester");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("venkatraman.kalpana@gmail.com");
		// driver.findElement(By.name("submitButton")).click();

		WebElement province = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select provincedd = new Select(province);
		provincedd.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();

		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Contact changes made ");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		System.out.println(driver.getTitle());

	}

}
