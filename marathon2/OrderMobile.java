package marathon2;

import io.github.sukgu.Shadow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrderMobile {


    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://dev146490.service-now.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Uouh$-9J2cIU");
        driver.findElement(By.xpath(" //button[@id='sysverb_login']")).click();

        Shadow dom = new Shadow(driver);
        dom.setImplicitWait(30);
        dom.findElementByXPath("//div[text()='All']").click();
        dom.findElementByXPath("//input[@id='filter']").click();

        dom.findElementByXPath("//span[text()='Service Catalog']").click();

        WebElement iframe = dom.findElementByXPath("//iframe");
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
        driver.findElement(By.xpath("//h2/strong[contains(text(),'Apple iPhone 13 pro')]")).click();

        //span[text()='Is this a replacement for a lost or broken iPhone?']/ancestor::div[@class = 'row sc-row']
        //input[@type='radio' and @value='yes']
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@type='radio' and @value='yes']/parent::span//label")).click();
        driver.findElement(By.xpath("//span[contains(text(),'What was the original phone number')]/parent::label/following::input[2]")).sendKeys("99");
        driver.findElement(By.xpath("//option[@value='unlimited']/parent::select")).click();
        driver.findElement(By.xpath("//option[@value='unlimited']")).click();
        driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'512')]")).click();
        driver.findElement(By.id("oi_order_now_button")).click();
        WebElement successMsg = driver.findElement(By.xpath("//div[@class='notification notification-success']//span[contains(text(),'Thank you')]"));
        System.out.println(successMsg.getText());

        WebElement requestNumber = driver.findElement(By.xpath("//dt[contains(text(),'Request Number')]/following-sibling::dd/a/b"));
        if (requestNumber.getText() != null) {
            System.out.println("request number is" + requestNumber.getText());
        }

        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/orderMobile.png");
        FileUtils.copyFile(source, dest);
        driver.close();
    }
}
