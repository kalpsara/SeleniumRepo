package week2.day2.assignments.assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Leafgroundbutton {

	public static void main(String[] args) throws InterruptedException {
		//https://www.leafground.com/button.xhtml
		
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm title.')]/following::span[1]")).click();
		Thread.sleep(2000);
		//Click and Confirm title.
		String expectedTitle = "Dashboard";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver. navigate(). back();
		
		
		//Confirm if the button is disabled.
		String disabledValue=driver.findElement(By.xpath("//h5[contains(text(),'Confirm if the button is disabled.')]/following::button[1]")).getAttribute("disabled");
		
		System.out.println("is disabled?"+disabledValue);
		
		//position of submitButton
		Point location=driver.findElement(By.xpath("//h5[contains(text(),'Find the position of the Submit button')]/following::button[1]")).getLocation();
		
		System.out.println("Position of submit buuton is "+location);
		
		//Find the Save button color
		String background=driver.findElement(By.xpath("//h5[contains(text(),'Find the Save button color')]/following::button[1]")).getCssValue("background");
		System.out.println(background);//rgb(96, 125, 139) 
		
		
		//Find the height and width of this button
		
		System.out.println("Height and widht "+driver.findElement(By.xpath("//h5[contains(text(),'Find the height and width of this button')]/following::button[1]")).getSize());
	
		
		//Mouse over and confirm the color changed
		
		WebElement ele= driver.findElement(By.xpath("//h5[contains(text(),'Mouse over and confirm the color changed')]/following::button[1]/span"));
		
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		
		
		action.moveToElement(ele).perform();
		
		
		System.out.println(ele.getCssValue("background-color"));
		
		//Click Image Button and Click on any hidden button
		//h5[contains(text(),'Click Image Button and Click on any hidden button')]/following::button[1]/span
		driver.findElement(By.xpath("//h5[contains(text(),'Click Image Button and Click on any hidden button')]/following::button[1]/span")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Click Image Button and Click on any hidden button')]/following::img")).click();
		
		//How many rounded buttons are there?
		List<WebElement> roundButtons=driver.findElements(By.xpath("//button[contains(@class,' rounded-button')]"));
		System.out.println("round button "+roundButtons.size());
		
		
		
	}

}
