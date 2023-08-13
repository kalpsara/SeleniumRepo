package week4.day1.assignments.assignment1;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafgroundWindow {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// **************************************
		// Click and Confirm new Window Opens

		driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm new Window Opens')]/following::span[1]"))
				.click();
		Set<String> openNewWindow = driver.getWindowHandles();
		List<String> listNewWindow = new ArrayList<String>(openNewWindow);
		driver.switchTo().window(listNewWindow.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(listNewWindow.get(1)).close();
		Thread.sleep(2000);
		
		
		// **************************************
		// Find the number of opened tabs
		driver.switchTo().window(listNewWindow.get(0));
		driver.findElement(By.xpath("//span[contains(text(),'Open Multiple')]")).click();
		Set<String> openMultipleWindow = driver.getWindowHandles();
		System.out.println("Number of windows opened is " + openMultipleWindow.size());
		Thread.sleep(2000);
		/*
		 * for(int i=1;i<listOpenMultipleWindow.size();i++) {
		 * driver.switchTo().window(listOpenMultipleWindow.get(i)).close();
		 * Thread.sleep(2000); }
		 */

		
		// **************************************
		// Close all windows except Primary
		driver.switchTo().window(listNewWindow.get(0));
		driver.findElement(By.xpath("//span[contains(text(),'Close Windows')]")).click();
		Set<String> secondayWindows = driver.getWindowHandles();
		List<String> listSecondayWindows = new ArrayList<>(secondayWindows);
		Thread.sleep(2000);

		for (int i = 1; i < listSecondayWindows.size(); i++) {
			driver.switchTo().window(listSecondayWindows.get(i)).close();
			Thread.sleep(2000);
		}
		driver.switchTo().window(listSecondayWindows.get(0));
		System.out.println(driver.getTitle());
		
		

		// **************************************
		// Wait for 2 new tabs to open

		driver.findElement(By.xpath("//span[contains(text(),'Open with delay')]")).click();
		Set<String> delayWindows = driver.getWindowHandles();
		List<String> listDelayWindows = new ArrayList<>(delayWindows);
		System.out.println("Delayed windows size :" + listDelayWindows.size());
		Thread.sleep(2000);
		for (int i = 1; i < listDelayWindows.size(); i++) {
			// System.out.println(driver.switchTo().window(listSecondayWindows.get(i)).getTitle());
			driver.switchTo().window(listDelayWindows.get(i)).close();
			Thread.sleep(2000);
		}
	}

}
