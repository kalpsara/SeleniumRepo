package week6.day1.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class EditLead extends LeadBase {

    @Test(dataProvider = "dataProvider")
    public void editLeadTest(String... data) throws InterruptedException {

        driver.findElement(By.linkText("Find Leads")).click();
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[3]);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
        driver.findElement(By.name("submitButton")).click();

    }


    @BeforeTest
    private void setFileName() {
        setFileName("Lead.xlsx");
    }
}






