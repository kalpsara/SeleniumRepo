package week7.day2.assignments.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week7.day2.assignments.base.ProjectSpecificMethod;
import week7.day2.assignments.pages.LoginPage;

public class LoginTC extends ProjectSpecificMethod {
	
	LoginPage lp=new LoginPage();
	@Test
	
	public void runLogin() {
		lp.enterUsername().enterPassword().clickLogin().clickCRMSFA();
		
	}

}
