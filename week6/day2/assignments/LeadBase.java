package week6.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import week6.day2.assignments.ReadExcelFile;

import java.io.IOException;
import java.time.Duration;

public class LeadBase {
    public ChromeDriver driver; //global variable

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Parameters({"url", "username", "password"})
    @BeforeMethod(alwaysRun=true)
    public void preCondition(String url, String username, String password) {
       
        ChromeOptions options = new ChromeOptions();
    
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
		/*
		 * String actualTitle=driver.getTitle(); String expectedTitle="Leaftaps";
		 * Assert.assertEquals(actualTitle, expectedTitle);
		 */
        

    }


    @DataProvider(name = "dataProvider")
    public Object[][] sendData() throws IOException {
        Object[][] excelData= ReadExcelFile.readExcel(fileName);
        return excelData;
    }


    @AfterMethod(alwaysRun=true)
    public void postCondition() {

        driver.close();
    }


}
