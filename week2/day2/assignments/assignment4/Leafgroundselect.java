package week2.day2.assignments.assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Leafgroundselect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		WebElement favouriteTool=driver.findElement(By.xpath("//h5[contains(text(),'Which is your favorite UI Automation tool?')]//following::select[1]"));
		System.out.println(favouriteTool.isEnabled());
		Select dd = new Select(favouriteTool);
		dd.selectByVisibleText("Selenium");
		//preferred country.
		
		WebElement preferredCountry=driver.findElement(By.xpath("//label[text()='Select Country']"));
		preferredCountry.click();
		driver.findElement(By.xpath("//li[text()='India']")).click();
		Thread.sleep(2000);
		

		//Confirm Cities belongs to Country is loaded
		driver.findElement(By.xpath("//label[text()='Select City']")).click();	
		driver.findElement(By.xpath("//li[text()='Bengaluru']")).click();
		
		/*WebElement citySelectElement=driver.findElement(By.xpath("//h5[contains(text(),'Confirm Cities')]//following::select[1]"));
		Select dd3 = new Select(citySelectElement);
		System.out.println("Cities belongs to Country is loaded : " + "Bengaluru".equals(dd3.getOptions().get(1).getText()));*/
		
		driver.findElement(By.xpath("//h5[contains(text(),'Choose the Course')]/following::button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		Thread.sleep(2000);
		//Choose language randomly
		driver.findElement(By.xpath("//label[text()='Select Language']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Tamil']")).click();
		Thread.sleep(2000);
		
		//Select 'Two' irrespective of the language chosen
		
		//chrome_options = WebDriver.Options;
		
		/*chrome_options.
				chrome_options.add_experimental_option('prefs', {'intl.accept_languages':'{locale}'.format(locale=language)})
				capabilities = DesiredCapabilities.CHROME
				web_driver = webdriver.Chrome(options=chrome_options, desired_capabilities=capabilities);
				
				ChromeOptions chromeOptions = new ChromeOptions();
				Map<String, Object> chrome_prefs = new HashMap<String, Object>();
				chrome_prefs.put("intl.accept_languages", language);
				chromeOptions.setExperimentalOption("prefs", chrome_prefs);
				WebDriver web_driver = new ChromeDriver(chromeOptions);*/
		
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='j_idt87:value_items']//li[2]")).click();
		//data-label

		
		
		
	}

}
