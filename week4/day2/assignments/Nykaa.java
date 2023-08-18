package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement brandMenu = driver.findElement(By.xpath("//header//a[contains(text(),'brands')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(brandMenu).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		// setTimeout(function(){debugger;},5000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("title matching!");
		} else {
			System.out.println("Title not matching!!");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Sort By')]"))).click().perform();

		driver.findElement(By
				.xpath("//label[contains(@for,'radio_customer top rated')]/div[contains(@class,'control-indicator')]"))
				.click();

		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Category']//following::span[text()='Hair']")).click();
		driver.findElement(By.xpath(
				"//span[text()='Category']/parent::div/following-sibling::ul//span[contains(text(),'Hair Care')]"))
				.click();

		driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]/parent::div/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();

		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		driver.findElement(
				By.xpath("//img[contains(@alt,'Paris Colour Protect Shampoo With UVA & UVB For Colour-Treated Hair')]"))
				.click();

		// new window

		Set<String> windHandle = driver.getWindowHandles();

		List<String> windowList = new ArrayList<String>(windHandle);
		driver.switchTo().window(windowList.get(1));

		driver.findElement(By.xpath("//span[text()='180ml']")).click();

		String price = driver.findElement(By.xpath(
				"//div[contains(text(),'inclusive of all taxes')]/preceding-sibling::div//span[contains(text(),'₹')]"))
				.getText();

		System.out.println(price);

		driver.findElement(By.xpath(
				"//div[contains(text(),'inclusive of all taxes')]/following-sibling::div//button/span[contains(text(),'Add to Bag')]"))
				.click();

		driver.findElement(By.xpath("//span[contains(@class,'cart-count')]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);

		WebElement frameElement = driver
				.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(frameElement);

		String grandTotal = driver
				.findElement(By.xpath("//span[contains(text(),'Grand Total')]/parent::div/preceding-sibling::div/span"))
				.getText();

		System.out.println("Grand total is " + grandTotal);

		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Continue as guest')]")).click();
		driver.findElement(By.xpath("//p[text()='New Address']/parent::div/preceding-sibling::div//img")).click();
		driver.switchTo().defaultContent();

		String guestGrandTotal = driver
				.findElement(By.xpath("//p[contains(text(),'Price Details')]/parent::div/following-sibling::p"))
				.getText();

		System.out.println("Grand total for guest is " + guestGrandTotal);

		if (grandTotal.equals(guestGrandTotal)) {
			System.out.println("The price is same for guest as well.");
		} else {
			System.out.println("The price differs for guest");
		}
		driver.quit();
	}

}
