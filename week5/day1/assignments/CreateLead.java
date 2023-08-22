package week5.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;


public class CreateLead extends LeadBase{

    @Test
    public void createLeadTest() {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kalpana");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Venkatraman");
        driver.findElement(By.name("submitButton")).click();

    }
}






