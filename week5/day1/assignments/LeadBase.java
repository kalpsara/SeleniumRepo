package week5.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class LeadBase {
    public ChromeDriver driver ; //global variable

    @BeforeMethod
    public void preCondition() {
        System.out.println(Thread.currentThread().getId());

        System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();

    }


    @AfterMethod
    public void postCondition() {
        System.out.println("inside post condition" );
        driver.close();
    }

    @BeforeSuite
    public void cloudConnection() {
        System.out.println("Start cloud connection");
    }



    @BeforeClass
    public void testData() {
        System.out.println("Set the values");
    }

    @AfterClass
    public void automatedData() {
        System.out.println("The page is automated for testing..");
    }


}
