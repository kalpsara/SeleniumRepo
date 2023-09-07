package week7.day2.assignments.testcases;

import org.testng.annotations.Test;

import week7.day2.assignments.base.ProjectSpecificMethod;
import week7.day2.assignments.pages.LoginPage;

public class DuplicateLeadTC extends ProjectSpecificMethod {

	@Test
	public void runDuplicateLead() throws InterruptedException {

		new LoginPage().enterUsername().enterPassword().clickLogin().clickCRMSFA().clickLeads().findLead()
				.enterFirstName().findLeadWithFieldsEntered().clickLeadList().clickDuplicateLead().clickCreateLeadToDuplicate();

	}

}
