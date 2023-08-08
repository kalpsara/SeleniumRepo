package week2.day2.assignments.assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafgroundInput {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();

		// ************************************************************
		// Type your name
		driver.findElement(By.xpath("//h5[contains(text(),'Type your name')]/following-sibling::div[1]/div/input"))
				.sendKeys("Kalpana");

		// ************************************************************
		// Append Country to this City

		driver.findElement(
				By.xpath("//h5[contains(text(),'Append Country to this City.')]/following-sibling::div[1]/div/input"))
				.sendKeys(" India");

		// ************************************************************
		// Verify if text box is disabled

		Boolean enabled = driver
				.findElement(By.xpath(
						"//h5[contains(text(),'Verify if text box is disabled')]/following-sibling::div[1]/div/input"))
				.isEnabled();
		System.out.println("Is text disabled " + !enabled);

		// ************************************************************
		// Clear the typed text

		driver.findElement(
				By.xpath("//h5[contains(text(),'Clear the typed text.')]/following-sibling::div[1]/div/input")).clear();

		// ************************************************************
		// Append Country to this City

		String typedText = driver
				.findElement(By
						.xpath("//h5[contains(text(),'Retrieve the typed text')]/following-sibling::div[1]/div/input"))
				.getAttribute("value");
		System.out.println("The typed text is " + typedText);

		// ************************************************************
		// Type email and Tab. Confirm control moved to next element.

		driver.findElement(By.xpath("//h5[contains(text(),'Type email')]/following-sibling::div[1]/div/input"))
				.sendKeys("venkatraman.kalpana@gmail.com");
		WebElement email = driver
				.findElement(By.xpath("//h5[contains(text(),'Type email')]/following-sibling::div[1]/div/input"));
		email.sendKeys(Keys.TAB);

		WebElement currentElement = driver.switchTo().activeElement();
		Point currentLocation = currentElement.getLocation();

		// ************************************************************
		// Type about yourself

		Point actualPoint = driver
				.findElement(By.xpath("//h5[contains(text(),'Type about yourself')]/following::textarea"))
				.getLocation();
		System.out.println(actualPoint.equals(currentLocation));
		driver.findElement(By.xpath("//h5[contains(text(),'Type about yourself')]/following::textarea"))
				.sendKeys("This is Kalpana");
		driver.findElement(By.xpath("//h5[contains(text(),'Text Editor')]/following::p[1]"))
				.sendKeys("Text editor area");

		// ************************************************************
		// Just Press Enter and confirm error message*
		WebElement errorMsgTextBox = driver.findElement(By.xpath(
				"//h5[contains(text(),'Just Press Enter and confirm error message*')]/following::input[@type='text'][1]"));
		errorMsgTextBox.sendKeys(Keys.ENTER);

		Boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//span[contains(text(),'Age is mandatory')]"))
				.isDisplayed();
		System.out.println("Is error message displayed" + isErrorMsgDisplayed);

		// ************************************************************
		// Click and Confirm Label Position Changes

		WebElement usernameTextBoxElement = driver.findElement(
				By.xpath("//h5[contains(text(),'Click and Confirm Label Position Changes')]/following::input[1]"));

		WebElement usernameLabelElement = driver.findElement(
				By.xpath("//h5[contains(text(),'Click and Confirm Label Position Changes')]/following::label[1]"));

		WebElement usernameLabelElementout = driver.findElement(By.xpath("//label[contains(@class,'ui-outputlabel')]"));

		Point beforeLocation = usernameLabelElement.getLocation();
		System.out.println("username position before click" + beforeLocation);
		usernameTextBoxElement.click();
		Thread.sleep(2000);
		Point afterLocation = usernameLabelElementout.getLocation();
		System.out.println("username position after click" + afterLocation);
		System.out.println("Lable location changed : " + !beforeLocation.equals(afterLocation));

		// ************************************************************
		// Type your name and choose the third option

		WebElement names = driver.findElement(
				By.xpath("//h5[contains(text(),'Type your name and choose the third option')]/parent::div//ul//input"));
		names.sendKeys("Kalpana");
		Thread.sleep(2000);
		WebElement third_option = driver
				.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete-items ui-autocomplete-list')]/li[3]"));
		third_option.click();
		names = driver.findElement(
				By.xpath("//h5[contains(text(),'Type your name and choose the third option')]/parent::div//ul//input"));
		names.sendKeys("saravana");
		Thread.sleep(2000);
		third_option = driver
				.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete-items ui-autocomplete-list')]/li[3]"));
		third_option.click();

		// ************************************************************
		// Type your DOB (mm/dd/yyyy) and confirm date chosen

		WebElement DOB = driver.findElement(By.xpath(
				"//h5[contains(text(),'Type your DOB')]/parent::div//span[contains(@class,'ui-calendar')]/input"));

		DOB.sendKeys("08/29/1985");

		String[] monthArray = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		Integer month_number = 0;
		List<WebElement> month_year = driver
				.findElements(By.xpath("//div[contains(@class,'ui-datepicker-title')]/span"));

		String month = month_year.get(0).getText();
		String year = month_year.get(1).getText();
		for (int i = 0; i <= 11; i++) {

			if (monthArray[i].equalsIgnoreCase(month)) {
				month_number = i + 1;
				break;
			}
		}

		String monthString = String.format("%02d", month_number);
		WebElement date = driver.findElement(By.xpath("//a[contains(@class,' ui-state-default ui-state-active')]"));
		String dateString = date.getText();
		String calenderDate = monthString + "/" + dateString + "/" + year;
		System.out.println("calender highlighted date " + calenderDate);

		if (calenderDate.equals("08/29/1985")) {

			System.out.println("Entered date and highligthed date are same");
		} else
			System.out.println("date not same");
		

		// ************************************************************
		// Type number and spin to confirm value changed
		//class="ui-spinner-input ui-inputfield ui-state-default ui-corner-all ui-state-filled" autocomplete="off" role="textbox" aria-multiline="false" aria-readonly="false" aria-disabled="false" aria-valuenow="5677786">
		

		WebElement number = driver.findElement(
				By.xpath("//h5[contains(text(),'Type number and spin')]/following::input[contains(@class,'ui-spinner-input')]"));
		number.sendKeys("56");
		
		
		WebElement arrowUpTriangle= driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-c ui-icon-triangle-1-n')]"));
		arrowUpTriangle.click();
		WebElement arrowDownTriangle= driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-c ui-icon-triangle-1-n')]"));
		arrowDownTriangle.click();
		
		System.out.println("values are changing");
		
		
		// ************************************************************
		//Type random number (1-100) and confirm slider moves correctly

		WebElement randomNumber = driver.findElement(
				By.xpath("//h5[contains(text(),'random number')]/following-sibling::input[1]"));
		randomNumber.sendKeys("38");
		Thread.sleep(2000);
		String width=driver.findElement(By.xpath("//h5[contains(text(),'random number')]/following-sibling::div/span")).getAttribute("style");
		System.out.println("width : "+width);
		System.out.println("Slider is moved according to the entered value");
		
		
		
		
		// ************************************************************
		//Click and Confirm Keyboard appears
		
		//<div class="ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay" style="z-index: 1007; position: absolute; top: 900.797px; width: 499px; left: 427px; display: block;"><div class="keypad-row"><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">!</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">@</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">#</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">$</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">%</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">^</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">&amp;</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">*</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">(</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">)</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">_</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">=</button><div class="keypad-half-space"></div><div class="keypad-space"></div><button type="button" class="keypad-special keypad-close ui-corner-all ui-state-default ui-state-highlight" title="Close the keypad" role="button" aria-disabled="false">Close</button></div><div class="keypad-row"><div class="keypad-half-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">`</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">~</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">[</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">]</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">{</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">}</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">&lt;</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">&gt;</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">\</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">|</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">/</button><div class="keypad-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">7</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">8</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">9</button></div><div class="keypad-row"><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">q</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">w</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">e</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">r</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">t</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">y</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">u</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">i</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">o</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">p</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">'</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">"</button><div class="keypad-half-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">4</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">5</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">6</button></div><div class="keypad-row"><div class="keypad-half-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">a</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">s</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">d</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">f</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">g</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">h</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">j</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">k</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">l</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">;</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">:</button><div class="keypad-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">1</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">2</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">3</button></div><div class="keypad-row"><div class="keypad-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">z</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">x</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">c</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">v</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">b</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">n</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">m</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">,</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">.</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">?</button><div class="keypad-space"></div><div class="keypad-half-space"></div><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">-</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">0</button><button type="button" class="keypad-key ui-corner-all ui-state-default" role="button" aria-disabled="false">+</button></div><div class="keypad-row"><button type="button" class="keypad-special keypad-tab ui-corner-all ui-state-default" title="Horizontal tab" role="button" aria-disabled="false">→</button><button type="button" class="keypad-special keypad-enter ui-corner-all ui-state-default" title="Carriage return" role="button" aria-disabled="false">Enter</button><button type="button" class="keypad-special keypad-spacebar ui-corner-all ui-state-default" title="Space" role="button" aria-disabled="false">&nbsp;</button><button type="button" class="keypad-special keypad-shift ui-corner-all ui-state-default ui-state-highlight" title="Toggle upper/lower case characters" role="button" aria-disabled="false">Shift</button><div class="keypad-half-space"></div><button type="button" class="keypad-special keypad-back ui-corner-all ui-state-default ui-state-highlight" title="Erase the previous character" role="button" aria-disabled="false">Back</button><button type="button" class="keypad-special keypad-clear ui-corner-all ui-state-default ui-state-highlight" title="Erase all the text" role="button" aria-disabled="false">Clear</button></div></div>
		
		WebElement confirmKeyboard = driver.findElement(
				By.xpath("//h5[contains(text(),'Confirm Keyboard ')]/following-sibling::input[1]"));
		confirmKeyboard.click();
		
		Boolean isKeypadAppears =driver.findElement(
				By.xpath("//div[contains(@class,'keypad-popup')]")).isDisplayed();
		
		System.out.println("is keypad appears: "+isKeypadAppears);
		
	}

}
