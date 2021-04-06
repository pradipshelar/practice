package com_ActiTime_Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com_ActiTime_Generic.BaseTest;
import com_ActiTime_Pages.ActiTimeLoginPage;

public class ValidLOginLogout extends BaseTest
{
	@Test(priority=1)
	public void validLoginLogout()
	{
		ActiTimeLoginPage lp=new ActiTimeLoginPage(driver);
		lp.verifyTitle("actiTIME - Login");
		lp.enterUserName("admin");
		lp.enterpassword("manager");
		lp.clickOnLoginButton();
       // lp.getErrorMessage();
        lp.getVersion();
   
	}
	
	

}
