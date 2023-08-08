package week2.day2.assignments.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginAcme {
	/*
	 * 1. Load url "https://acme-test.uipath.com/login"
	 * 2. Enter email as
	 * "kumar.testleaf@gmail.com"
	 * 3. Enter Password as "leaf@12"
	 * 4. Click login button
	 * 5. Get the title of the page and print
	 * 6. Click on Log Out
	 * 7. Close the
	 * browser (use -driver.close())
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);
		String title=driver.getTitle();
		
		System.out.println("Title displayed is "+title);
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
	
		
		Thread.sleep(2000);
		System.out.println(title);
		driver.close();
		

	}

}
