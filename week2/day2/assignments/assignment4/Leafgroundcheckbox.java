package week2.day2.assignments.assignment4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Leafgroundcheckbox {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();

		// Basic Checkbox
		
		

		driver.findElement(By.xpath(
				"//h5[contains(text(),'Basic Checkbox')]/parent::div//span[contains(@class,'ui-chkbox-icon')]/parent::div"))
				.click();
		
		//**************************************************************************************************************

		// Notification

		driver.findElement(By.xpath(
				"//h5[contains(text(),'Notification')]/parent::div//span[contains(@class,'ui-chkbox-icon')]/parent::div"))
				.click();
		TimeUnit.SECONDS.sleep(2);

		WebElement popupElement = driver.findElement(By.xpath("//span[contains(@class,'ui-growl-title')]"));

		System.out.println(popupElement.getText());

		driver.findElement(By.xpath(
				"//h5[contains(text(),'Notification')]/parent::div//span[contains(@class,'ui-chkbox-icon')]/parent::div"))
				.click();
		TimeUnit.SECONDS.sleep(2);

		popupElement = driver.findElement(By.xpath("//span[contains(@class,'ui-growl-title')]"));

		System.out.println(popupElement.getText());
		
		//**************************************************************************************************************

		// Choose your favorite language(s)

		WebElement favouriteLangGroup = driver
				.findElement(By.xpath("//h5[contains(text(),'Choose your favorite language')]/parent::div"));
		List<WebElement> allLabelElements = favouriteLangGroup.findElements(By.xpath(".//label"));

		for (WebElement element : allLabelElements) {

			System.out.println(element.getText());
			if (!(element.getText().equalsIgnoreCase("Python"))) {
				element.click();

			}
		}

		
		//**************************************************************************************************************
		// Tri State Checkbox

		WebElement tristateCheckbox = driver
				.findElement(By.xpath("//h5[contains(text(),'Tri State Checkbox')]/parent::div"));

		WebElement noCheck = tristateCheckbox
				.findElement(By.xpath(".//span[contains(@class,'ui-chkbox-icon')]/parent::div"));

		// first click
		noCheck.click();

		Thread.sleep(2000);
		WebElement tristatePopupElement = driver
				.findElement(By.xpath("//span[contains(text(),'State has been changed')]/following-sibling::p"));

		System.out.println(tristatePopupElement.getText());

		tristateCheckbox = driver.findElement(By.xpath("//h5[contains(text(),'Tri State Checkbox')]/parent::div"));

		WebElement checkedLabel = tristateCheckbox
				.findElement(By.xpath(".//span[contains(@class,'ui-icon-check')]/parent::div"));
		// second click
		checkedLabel.click();

		Thread.sleep(5000);
		tristatePopupElement = driver
				.findElement(By.xpath("//span[contains(text(),'State has been changed')]/following-sibling::p"));

		System.out.println(tristatePopupElement.getText());
		Thread.sleep(2000);
		WebElement closecheckedLabel = driver
				.findElement(By.xpath("//span[contains(@class,'ui-icon-closethick')]/parent::div"));
		// third click
		closecheckedLabel.click();
		Thread.sleep(2000);
		tristatePopupElement = driver
				.findElement(By.xpath("//span[contains(text(),'State has been changed')]/following-sibling::p"));

		System.out.println(tristatePopupElement.getText());
		
		//**************************************************************************************************************
		//Toggle Switch
		
		driver.findElement(By.xpath(
				"//h5[contains(text(),'Toggle Switch')]/following-sibling::div[contains(@class,'ui-toggleswitch')]"))
				.click();
		TimeUnit.SECONDS.sleep(2);

		 popupElement = driver.findElement(By.xpath("//span[contains(@class,'ui-growl-title')]"));

		System.out.println(popupElement.getText());

		driver.findElement(By.xpath(
				"//h5[contains(text(),'Toggle Switch')]//following-sibling::div[contains(@class,'ui-toggleswitch-checked')]"))
				.click();
		TimeUnit.SECONDS.sleep(2);

		popupElement = driver.findElement(By.xpath("//span[contains(@class,'ui-growl-title')]"));

		System.out.println(popupElement.getText());
		
		//**************************************************************************************************************
				//Verify if check box is disabled
		//ui-selectbooleancheckbox ui-chkbox ui-widget
		
		
	Boolean isEnabled=driver.findElement(By.xpath(
				"//h5[contains(text(),'Verify if check box is disabled')]/following-sibling::div//div[contains(@class,'ui-selectbooleancheckbox')]")).isSelected();
	
	System.out.println("is check box is disabled?"+!isEnabled);
	
	
	//**************************************************************************************************************
	
	//Select Multiple
	
	//ui-selectcheckboxmenu-multiple ui-selectcheckboxmenu ui-widget ui-state-default ui-corner-all
	
	//ui-selectcheckboxmenu-items-wrapper
	
	WebElement select_multiple_dd= driver
			.findElement(By.xpath("//h5[contains(text(),'Select Multiple')]/following-sibling::div//ul[contains(@class,'ui-selectcheckboxmenu-multiple')]"));
	select_multiple_dd.click();
	//WebElement london=driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]//li[contains(@data-item-value,'London')]"));
	
	//System.out.println("--"+london.getText());
	
	//london.click();
	
	driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]//label[contains(text(),'London')]/preceding-sibling::div/div[contains(@class,'ui-chkbox-box')]")).click();
	driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]//label[contains(text(),'Paris')]/preceding-sibling::div/div[contains(@class,'ui-chkbox-box')]")).click();
	driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]//label[contains(text(),'Berlin')]/preceding-sibling::div/div[contains(@class,'ui-chkbox-box')]")).click();
	//ui-icon ui-icon-circle-close
	driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-icon-circle-close')]")).click();
	List<WebElement> all_selected_element =driver.findElements(By.xpath("//ul[contains(@data-label,'Cities')]/li"));
	
	//List<WebElement> all_selected_element = select_multiple.findElements(By.xpath(".//li"));

	
	Thread.sleep(2000);

	for (WebElement element : all_selected_element) {
		System.out.println("Selected elements are "+element.getText());
	}
	

	}
	
	
	

}
