package week4.day1.assignments.assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
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
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Merge Contacts")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img[1]")).click();
		Set<String> windHandle = driver.getWindowHandles();

		List<String> windowList = new ArrayList<String>(windHandle);

		Thread.sleep(2000);

		driver.switchTo().window(windowList.get(1));

		driver.findElement(
				By.xpath("//span[text()='Contact List']/following::table[2]//div[contains(@class,'partyId')]/a"))
				.click();

		driver.switchTo().window(windowList.get(0));

		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img[1]")).click();
		Thread.sleep(2000);
		Set<String> toWindHandle = driver.getWindowHandles();

		List<String> toWindowList = new ArrayList<String>(toWindHandle);

		Thread.sleep(2000);
		driver.switchTo().window(toWindowList.get(1));
		driver.findElement(
				By.xpath("//span[text()='Contact List']/following::table[3]//div[contains(@class,'partyId')]/a"))
				.click();
		driver.switchTo().window(windowList.get(0));
		driver.findElement(By.linkText("Merge")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());

		
	}

}
