package marathon2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.sukgu.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdministratorCertification {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/sarengaraj/Saravanakumar/Kalpana/TestLeaf/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf$1234");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//span[text()='Learn More']")).click();

        Set<String> windHandle = driver.getWindowHandles();

        List<String> windowList = new ArrayList<String>(windHandle);
        driver.switchTo().window(windowList.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        Shadow dom = new Shadow(driver);
        dom.setImplicitWait(10);
        dom.findElementByXPath("//span[text()='Learning']").click();

        WebElement element = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
        // Learning on Trailhead
        Actions act = new Actions(driver);

        act.moveToElement(element).perform();
        dom.findElementByXPath("//a[text()='Salesforce Certification']").click();

        driver.findElement(By.xpath(" //div[@class='credentials-card_title']//a[1]")).click();
        if ("Certification - Administrator".equals(driver.getTitle())) {
            System.out.println("Title same");
        } else {
            System.out.println("Title not matching");
        }
        List<WebElement> certificationList = driver.findElements(By.xpath("//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']//div[@class='trailMix-card-body_title']"));
        for (WebElement cert : certificationList) {
            System.out.println(cert.getText());
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/saleforce.png");
        FileUtils.copyFile(source, dest);


    }

}
