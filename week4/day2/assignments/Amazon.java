package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		List<WebElement> productContainer = driver.findElements(By.xpath("//div[contains(@class,'s-card-container')]"));
		WebElement productCompleteName = productContainer.get(0)
				.findElement(By.xpath(".//h2/a[contains(@class,'a-link-normal')]/span"));
		String nameAttribute = productCompleteName.getAttribute("innerHTML");

		Thread.sleep(2000);
		WebElement price = productContainer.get(0).findElement(By.xpath(".//span[contains(@class,'a-price-whole')]"));

		String initialPrice = price.getText();

		WebElement rating = productContainer.get(0).findElement(By.xpath(".//span[contains(@class,'a-icon-alt')]"));
		String ratingAttribute = rating.getAttribute("innerHTML");
		System.out.println(nameAttribute + "   " + initialPrice + "   " + ratingAttribute);
		productContainer.get(0).findElement(By.xpath(".//h2/a")).click();
		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listofHandles = new ArrayList<>(windowHandles);
		driver.switchTo().window(listofHandles.get(1));
		Thread.sleep(2000);

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/amazon.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(10000);
		WebElement addToCart = driver.findElement(By.xpath("//input[contains(@title,'Add to Shopping Cart')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(addToCart).click().build().perform();

		List<WebElement> cartSubTotal = driver
				.findElements(By.xpath("//b[contains(text(),'Cart subtotal')]/ancestor::div/span/span"));

		for (WebElement t : cartSubTotal) {
			System.out.print(t.getText());
		}
		System.out.println();
		String priceSubTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		Thread.sleep(2000);
		if (priceSubTotal.equals("₹" + initialPrice.concat(".00"))) {
			System.out.println("Price is verified and same");
		} else {
			System.out.println("Price mismatch");
		}

		driver.switchTo().window(listofHandles.get(1)).close();
		driver.switchTo().window(listofHandles.get(0)).close();
	}

}
