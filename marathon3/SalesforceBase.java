package marathon3;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class SalesforceBase {
	public RemoteWebDriver driver; // global variable

	private String fileName;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Parameters({ "browser", "url", "username", "password" })
	@BeforeMethod(alwaysRun = true)
	public void preCondition(String browser, String url, String username, String password) {

		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			// driver=new EdgeDriver();

			System.setProperty("webdriver.edge.driver", "D:\\Kalpana\\msedgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
			edgeOptions.addArguments("--disable-notifications");
			edgeOptions.addArguments("--guest");
			driver = new EdgeDriver(edgeOptions);

			/*
			 * var options = new EdgeOptions();
			 * options.setCapability("browserstack.ie.enablePopups", false);
			 */

			// driver = new EdgeDriver(options);
			/*
			 * DesiredCapabilities caps = new DesiredCapabilities();
			 * caps.setCapability("disable-infobars", true);
			 * caps.setCapability("--disable-notifications", true);
			 * caps.setCapability("browserstack.ie.enablePopups", false);
			 */

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@DataProvider(name = "dataProvider")
	public Object[][] sendData() throws IOException {
		Object[][] excelData = ReadExcelFile.readExcel(fileName);
		return excelData;
	}

	@AfterMethod(alwaysRun = true)
	public void postCondition() {

		// driver.close();
	}

}
