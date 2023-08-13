package week4.day1.assignments.assignment2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BuyTheValue {

	/*
	 * 1. Load https://buythevalue.in/ 2. Click on first product (eg: Hamdard Hing -
	 * 50GM) 3. Enter the pincode 4. Click on Check 5. Click on ADD TO CART 6. Click
	 * on View 7. Click on CHECK OUT //Handle alert 8. Accept the alert
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);

		/*
		 * driver.findElement( By.
		 * xpath("//div[contains(@class,'owl-item active')]//a[contains(text(),'URBAN FIT X SMART WATCH')]"
		 * )) .click();
		 */

		driver.findElement(By.xpath(
				"//h3[contains(text(),'Today Offers')]/following::div[1]//div[contains(@class,'owl-item active')][1]//a[@class='product-title']"))
				.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Enter Zipcode']")).sendKeys("600126");

		driver.findElement(By.xpath("//input[@value='Check']")).click();
		driver.findElement(By.xpath("//button[@value='Add to Cart']")).click();
		Thread.sleep(2000);

		try {
			driver.findElement(By.xpath("//div/a[@href='/cart']")).click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div/a[@href='/cart']")));
		}
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String alertTxt = alert.getText();
		System.out.println(alertTxt);
		Thread.sleep(2000);
		alert.accept();

	
	}

}
