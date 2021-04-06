package com_ActiTime_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_ActiTime_Generic.BasePage;

public class ActiTimeLoginPage extends BasePage
{
@FindBy(id="username")
private WebElement unBT;
@FindBy(xpath = "//input[@name='pwd']")
private WebElement pwBT;
@FindBy(xpath="//div[.='Login ']")
private WebElement loginBT;
@FindBy(xpath="//span[.='Username or Password is invalid. Please try again.']")
private WebElement error;
@FindBy(xpath="//nobr[.='actiTIME 2020 Online']")
private WebElement version;


	public ActiTimeLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String un)
	{
		unBT.sendKeys(un);
	}
	public void enterpassword(String pw)
	{
		pwBT.sendKeys(pw);
	}
	public void clickOnLoginButton()
	{
		loginBT.click();
	}
public String getErrorMessage()
{
	verifyElement(error);
	String aErrorMsg=error.getText();
	return aErrorMsg;
}


public void getVersion()
{
	
	verifyElement(version);
	
	
}


}
