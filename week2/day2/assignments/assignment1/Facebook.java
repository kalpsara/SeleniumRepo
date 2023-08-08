package week2.day2.assignments.assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("kalp");
		driver.findElement(By.name("lastname")).sendKeys("kalp");
		driver.findElement(By.id("password_step_input")).sendKeys("welcome123");
		driver.findElement(By.name("reg_email__")).sendKeys("kalp");

		WebElement birthdayday = driver.findElement(By.name("birthday_day"));
		Select bdd = new Select(birthdayday);
		bdd.selectByIndex(28);
		Thread.sleep(2000);
		WebElement birthdaymonth = driver.findElement(By.name("birthday_month"));
		Select bdm = new Select(birthdaymonth);
		bdm.selectByIndex(7);
		Thread.sleep(2000);
		WebElement birthdayyear = driver.findElement(By.name("birthday_year"));
		Select bdy = new Select(birthdayyear);
		bdy.selectByVisibleText("1985");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
