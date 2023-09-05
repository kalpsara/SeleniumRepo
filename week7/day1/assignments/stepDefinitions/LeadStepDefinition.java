package week7.day1.assignments.stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import week7.day2.classroom.stepDefinition.BaseClass;

public class LeadStepDefinition extends BaseClass {
	ChromeDriver driver;
	static String mergeLeadID;
	

	@Given(value = "Launch the browser")

	public void launchBrowser() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

	}

	@Given(value = "Load the url")
	public void loadUrl() {
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	}

	@Given(value = "Enter the Username as {string}")
	public void enterUsername(String userName) {

		driver.findElement(By.id("username")).sendKeys(userName);
	}

	@Given(value = "Enter the Password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When(value = "Click on the Login button")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("WelcomePage is displayed")
	public void welcome_page_is_displayed() {
		System.out.println(driver.getTitle());

	}

	@When("Error Message is displayed")
	public void error_message_is_displayed() {
		String errorMsg = driver.findElement(By.xpath("//div[@id='errorDiv']")).getText();
		System.out.println(errorMsg);
	}

	@When("Click on CRMSFA link")
	public void click_on_crmsfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Click on Leads link")
	public void click_on_leads_link() {
		driver.findElement(By.linkText("Leads")).click();

	}

	@When("Click on CreateLead link")
	public void click_on_create_lead_link() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@When("Enter the companyName as {string}")
	public void enter_the_company_name(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}

	@When("Enter the firstName as {string}")
	public void enter_the_first_name(String fname) {

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}

	@When("Enter the lastName as {string}")
	public void enter_the_last_name(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}

	@When("Click on Create button")
	public void click_on_create_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("ViewLead page is displayed")
	public void view_lead_page_is_displayed() {
		System.out.println(driver.getTitle());
	}

	//Edit Lead
	
	
	@When("Click on Find Lead link")
	public void click_on_find_lead_link() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@Given("Enter the Lead id as {string}")
	public void enter_lead_Id_as(String leadId) {
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='id']")).sendKeys(leadId);
	}

	@Given("Enter the first name as {string}")
	public void enter_the_first_name_as(String fname) {
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[contains(@name,'firstName')]"))
				.sendKeys(fname);
	}

	@When("Click on Find Lead button")
	public void click_on_find_lead_button() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@When("Click on Lead List")
	public void click_on_lead_list() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement firstRecord = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		js.executeScript("arguments[0].click()", firstRecord);
		//firstRow.click();

	}

	@When("Click on Edit link")
	public void click_on_edit_link() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Then("Clear description")
	public void clear_description() {
		driver.findElement(By.id("updateLeadForm_description")).clear();
	}

	@Then("Edit description as {string}")
	public void edit_description_as(String desc) {
		driver.findElement(By.id("updateLeadForm_description")).sendKeys(desc);
	}

	@Then("Update lead")
	public void update_lead() {
		driver.findElement(By.cssSelector("input[class=smallSubmit][name=submitButton][value=Update]")).click();
	}

//Delete Lead

	@When("Click on Phone Tab")
	public void click_on_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Given("Enter the Phone number as {string}")
	public void enter_the_phone_number_as(String phoneNum) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);

	}

	@When("Get the Lead Id to verify")
	public String get_the_lead_id_to_verify() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		Thread.sleep(2000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();

		return leadID;
	}

	@Then("Click on Delete button")
	public void click_on_delete_button() throws InterruptedException {
		Thread.sleep(2000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement pagingInfo = driver.findElement(By.className("x-paging-info"));
		wait.until(ExpectedConditions.textToBePresentInElement(pagingInfo, "No records to display"));
		//wait.until(ExpectedConditions.visibilityOf(pagingInfo));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String elementText = (String) js.executeScript("return arguments[0].innerText;", pagingInfo);

		Thread.sleep(2000);
		if (elementText.equals("No records to display")) {
			System.out.println("Delete successful");
		} else {
			System.out.println("Delete failure");
		}
	}
	
	//Duplicate Lead
	@When("click on Duplicate lead")
	public void click_on_duplicate_lead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
	}
	
	
	//Merge Lead
	@When("Click on Merge Lead Link")
	public void click_on_merge_lead_link() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@When("From lead and To lead is selected")
	public void from_lead_and_to_lead_is_selected() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("s");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement mergeLeadID1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		wait.until(ExpectedConditions.elementToBeClickable(mergeLeadID1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		mergeLeadID = (String) js.executeScript("return arguments[0].innerText;", mergeLeadID1);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("d");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
		
		
	}
	@When("Click on Merge button")
	public void click_on_merge_button() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	
	@Then("Verify merged lead")
	public void verify_merged_lead() throws InterruptedException {
		//LeadStepDefinition st=new LeadStepDefinition();
		System.out.println("MergeLead id"+mergeLeadID);
		String leadID=mergeLeadID;
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement pagingInfo = driver.findElement(By.className("x-paging-info"));
		wait.until(ExpectedConditions.visibilityOf(pagingInfo));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String elementText = (String) js.executeScript("return arguments[0].innerText;", pagingInfo);

		Thread.sleep(2000);
		if (elementText.equals("No records to display")) {
			System.out.println("Merge successful");
		} else {
			System.out.println("Merge failure");
		}
	}
	
	

}
