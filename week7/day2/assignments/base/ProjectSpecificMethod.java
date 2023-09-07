package week7.day2.assignments.base;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week7.day2.assignments.utils.ReadExcelFile;

public class ProjectSpecificMethod {
	public static ChromeDriver driver;

	@BeforeMethod
	@Parameters({ "url" })
	public void preCondition(String url) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void postCondition() {

		driver.close();
	}

	public static String fileName;

	@BeforeMethod(alwaysRun = true)
	public void setFileName() {
		fileName = "Lead.xlsx";
	}

	@DataProvider(name = "dataProvider")
	public Object[][] sendData() throws IOException {
		Object[][] excelData = ReadExcelFile.readExcel(fileName);
		return excelData;
	}

}
