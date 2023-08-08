package week2.day2.assignments.assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Leafgroundradio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(
				"//h5[contains(text(),'Your most favorite browser')]//following::label[1]//preceding-sibling::div//span"))
				.click();

		// UnSelectable
		WebElement age_radio_button_group_element = driver
				.findElement(By.xpath("//h5[contains(text(),'UnSelectable')]/parent::div"));
		List<WebElement> allLabelElements = age_radio_button_group_element.findElements(By.xpath(".//label"));

		allLabelElements.get(1).click();
		Thread.sleep(2000);
		WebElement checkedLabel = age_radio_button_group_element
				.findElement(By.xpath(".//div[contains(@class,'ui-state-active')]/following::label[1]"));

		for (WebElement element : allLabelElements) {
			if (element.equals(checkedLabel)) {
				element.click();
				break;
			}
		}
		// default select radio button

		WebElement default_select_radio_button_group_element = driver
				.findElement(By.xpath("//h5[contains(text(),'default select radio button')]/parent::div"));
		WebElement defaultBrowser = default_select_radio_button_group_element
				.findElement(By.xpath(".//div[contains(@class,'ui-state-active')]/ancestor::td/label"));
		System.out.println("Default browser : " + defaultBrowser.getText());
		defaultBrowser = driver.findElement(By.xpath(
				"//h5[contains(text(),'default select radio button')]//following::input[2]/following::label[1]"));
		System.out.println(defaultBrowser.isSelected());
		defaultBrowser.click();
		defaultBrowser = driver.findElement(By.xpath(
				"//h5[contains(text(),'default select radio button')]/parent::div//div[contains(@class,'ui-state-active')]//following::label[1]"));
		System.out.println(defaultBrowser.isSelected());
		defaultBrowser = driver.findElement(By.xpath(
				"//h5[contains(text(),'default select radio button')]//following::div[contains(@class,'ui-state-active')][1]//following::label[1]"));
		System.out.println("Default browser : " + defaultBrowser.getText());

		// Select the age group (only if not selected)

		WebElement age_radio_button_group_element2 = driver
				.findElement(By.xpath("//h5[contains(text(),'Select the age group')]/parent::div"));
		List<WebElement> allLabelElements2 = age_radio_button_group_element2.findElements(By.xpath(".//label"));
		WebElement checkedLabel2 = age_radio_button_group_element2
				.findElement(By.xpath(".//div[contains(@class,'ui-state-active')]/following::label[1]"));

		for (WebElement element : allLabelElements2) {
			if (!element.equals(checkedLabel2)) {
				element.click();
				break;
			}
		}

	}

}
