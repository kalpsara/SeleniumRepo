package marathon2;

import io.github.sukgu.Shadow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArchitectCertification {


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
      List<WebElement> roles=driver.findElements(By.xpath("  //div[contains(@class,'roleMenu-item')]//div"));
        System.out.println("Salesforce Architect Summary");
        System.out.println("-----------------------------");
        for(WebElement e:roles){

            if(e.getText().contains("Architect")){
                e.click();
                break;
            }
        }

            List<WebElement> summary=driver.findElements(By.xpath(" //div[@class='slds-container--center slds-container--medium slds-p-vertical--large']"));

            //div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']
        for(WebElement s:summary){
            System.out.println(s.getText());
            System.out.println("");
            if(s.getText().contains("Salesforce Certified Solution Architects")){
                break;
            }


            }
        List<WebElement> certificationList=driver.findElements(By.xpath("  //div[@class='slds-container--center slds-container--x-large slds-p-top--small']//div[contains(@class,'credentials-card_type')]/following-sibling::div/a"));
        System.out.println("Architect certification list");
        System.out.println("-----------------------------");
        for(WebElement c:certificationList){
            System.out.println(c.getText());


        }
        for(WebElement c:certificationList) {
            if (c.getText().contains("Application Architect")) {
                c.click();
                 break;
            }
        }

        System.out.println(" ");
        System.out.println("Application Architect certification list");
        System.out.println("-----------------------------");
        List<WebElement> architectCertificationList=driver.findElements(By.xpath(" //div[contains(text(),'Related Credentials')]/preceding::div[@class='credentials-card_title']"));

        for(WebElement c:architectCertificationList) {
            System.out.println(c.getText());
        }
       WebElement screenshotElement= driver.findElement(By.xpath("//div[contains(text(),'Earn your Prerequisites')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", screenshotElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("window.scrollBy(0,330)", "");
        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/ApplicationArchitectCertification.png");
        FileUtils.copyFile(source, dest);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().window(windowList.get(1)).close();
        driver.switchTo().window(windowList.get(0)).close();

    }
}
