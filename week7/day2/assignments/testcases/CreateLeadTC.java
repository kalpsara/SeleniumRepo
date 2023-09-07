package week7.day2.assignments.testcases;

import org.testng.annotations.Test;

import week7.day2.assignments.base.ProjectSpecificMethod;
import week7.day2.assignments.pages.LoginPage;

public class CreateLeadTC extends ProjectSpecificMethod {
	
	/*
	 * private String fileName;
	 * 
	 * @BeforeTest(alwaysRun = true) private void setFileName() {
	 * 
	 * fileName="Lead.xlsx";
	 * 
	 * }
	 */

	/*
	 * public void setFileName(String fileName) { this.fileName = fileName; }
	 */
	
     @Test(dataProvider = "dataProvider") 
	public void runCreateLead(String...data) {
		
		new LoginPage().enterUsername().enterPassword().clickLogin().clickCRMSFA().clickLeads().createLead()
		.enterCompanyName(data[0]).enterfirstName(data[1]).enterlastName(data[2]).clickCreate();
		
		
	}
	



}
