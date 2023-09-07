package week7.day2.assignments.testcases;

import org.testng.annotations.Test;

import week7.day2.assignments.base.ProjectSpecificMethod;
import week7.day2.assignments.pages.LoginPage;

public class MergeLeadTC extends ProjectSpecificMethod {

	@Test
	public void runMergeLead() throws InterruptedException {

		new LoginPage().enterUsername().enterPassword().clickLogin().clickCRMSFA().clickLeads().mergeLead().selectFromLead().selectToLead().clickMergeLeadButton();

	}

}