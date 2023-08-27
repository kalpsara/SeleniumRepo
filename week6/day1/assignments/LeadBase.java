package week6.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class LeadBase {
    public ChromeDriver driver; //global variable

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Parameters({"url", "username", "password"})
    @BeforeMethod
    public void preCondition(String url, String username, String password) {
        System.out.println(Thread.currentThread().getId());

        System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();

    }



    @DataProvider(name = "dataProvider")
    public Object[][] sendData() throws IOException {
        Object[][] excelData=ReadExcelFile.readExcel(fileName);
        return excelData;
    }

    @AfterMethod
    public void postCondition() {
        driver.close();
    }


}
