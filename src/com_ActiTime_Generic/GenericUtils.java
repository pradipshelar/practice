package com_ActiTime_Generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.google.common.io.Files;

public class GenericUtils {
	public static void getScreenShot(WebDriver driver, String name) {
		SimpleDateFormat s1 = new SimpleDateFormat("DD-MM-YYYY");
		String date = s1.format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(src, new File("./ScreenShot/" + date + "_" + name + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public static void deselectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);

	}

	public static void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public static void deselectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public static void deselectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}

	public static void deselectAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();

	}

	public static void getAllselectedOptions(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> allopt = sel.getAllSelectedOptions();
		int count = allopt.size();
		Reporter.log("count of all selected options=" + count, true);
		Reporter.log("all selected options", true);
		for (WebElement opt : allopt) {
			String text = opt.getText();
			Reporter.log("text", true);
		}

	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundcolor");
		for (int i = 0; i < 10; i++) {
			changecolor("rgb(0,200,0)", element, driver);
			changecolor(bgcolor, element, driver);
		}

	}

	private static void changecolor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundcolor='" + color + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "');");
	}

	public static void clickByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].click();", element);
	}

	public static void refreshBrowserByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String sText = js.executeScript("return document.documentElement.innerText;").toString();
		return sText;
	}

	public static void selectDateByJs(WebElement element, WebDriver driver, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateVal + "')", element);
	}

}
