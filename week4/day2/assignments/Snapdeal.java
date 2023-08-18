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

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement mensFashion = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(mensFashion).perform();

		// In chrome console
		// setTimeout(function(){debugger;},5000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement sportsShoes = driver
				.findElement(By.xpath("//div[@id='category1Data']//span[contains(text(),'Sports Shoes')]"));
		Actions sportShoesClickAction = new Actions(driver);
		sportShoesClickAction.moveToElement(sportsShoes).click().build().perform();
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Sort by')]")).click();

		List<WebElement> listItems = driver.findElements(By.xpath("//li[contains(@class,'search-li')]"));
		for (WebElement e : listItems) {
			//System.out.println("Sort by: " + e.getText());
			if (e.getText().equals("Price Low To High")) {
				System.out.println("Sort by: " + e.getText());
				e.click();
				
				break;
			}
		}

		List<WebElement> productSection = driver.findElements(By.xpath("//div[@id='products']//section"));
		Thread.sleep(2000);
		for (WebElement p : productSection) {
			
			List<WebElement> spanElements = p
					.findElements(By.xpath(".//span[contains(@class,'lfloat product-price')]"));
			Thread.sleep(2000);
			spanElements.stream().forEach(e -> System.out.println(e.getText()));

		}

		/*
		 * WebElement priceRangeSlider = driver .findElement(By.
		 * xpath("//div[contains(@class,'filter-price-slider ui-slider')]"));
		 * 
		 * Actions move = new Actions(driver);
		 * move.dragAndDropBy(priceRangeSlider,1,0).perform();
		 */
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("600", Keys.TAB);
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("999");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn btn-line btn-theme-secondary')]"))
				.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();

		Thread.sleep(10000);
		List<WebElement> allFilters = driver
				.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']"));
		System.out.println("*** All applied filters ***");
		for (WebElement f : allFilters) {

			System.out.println(f.getText());

		}

		WebElement quickView = driver
				.findElement(By.xpath("//picture/source[@title='Columbus Navy Training Shoes']/ancestor::div[2]"));

		Actions hover = new Actions(driver);
		hover.moveToElement(quickView).perform();
		quickView.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listofHandles = new ArrayList<>(windowHandles);
		driver.switchTo().window(listofHandles.get(1));
		Thread.sleep(2000);
		List<WebElement> priceDetails = driver
				.findElements(By.xpath("//div[@class='disp-table']//span/span/parent::span"));
		System.out.println("***  Price Details ***");
		for (WebElement pd : priceDetails) {

			System.out.println(pd.getText());
		}

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snapdeal.png");
		FileUtils.copyFile(source, dest);

		driver.switchTo().window(listofHandles.get(1)).close();
		Thread.sleep(2000);
		driver.switchTo().window(listofHandles.get(0)).close();

	}

}
