package week6.day1.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;


public class CreateLead extends LeadBase {

    @Test(dataProvider = "dataProvider")
    public void createLeadTest(String... data) {
        System.out.println(Thread.currentThread().getId());
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys(data[0]);
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys(data[1]);
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys(data[2]);
        driver.findElement(By.name("submitButton")).click();

    }

    @BeforeTest
    private void setFileName() {
        setFileName("Lead.xlsx");
    }


}






