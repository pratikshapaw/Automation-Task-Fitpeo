package com.fitpeo.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

	@FindBy(xpath="//*[@class='satoshi MuiBox-root css-5ty6tm' and text()='Revenue Calculator']")private WebElement revenueCalculator;


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void clickOnRevenueCalculator()
	{
		revenueCalculator.click();
	}
	
}
