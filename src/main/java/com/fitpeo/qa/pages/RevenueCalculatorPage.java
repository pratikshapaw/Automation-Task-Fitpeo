package com.fitpeo.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevenueCalculatorPage  {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng' and contains(@id,'r')]")
	private WebElement sliderInputTxtBox;
	
	@FindBy(xpath = "//*[contains(@class,'MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op')]")
	private WebElement slider;
	
//	@FindBy(xpath = "//*[contains(@class,'MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh')]")
//	private WebElement sliderMovePoint;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]")
	private WebElement sliderMovePoint;
	
	
	
	@FindBy(xpath = "//p[text()='CPT-99453']/parent::div/child::label//child::input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99453CheckBox;
	
	@FindBy(xpath = "//p[text()='CPT-99454']/parent::div/child::label//child::input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99454CheckBox;
	
	@FindBy(xpath = "//p[text()='CPT-99474']/parent::div/child::label//child::input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99474CheckBox;
	
	@FindBy(xpath = "//*[text()='Total Recurring Reimbursement for all Patients Per Month:']//parent::p[1]")
	private WebElement totalRevenue;
	
	@FindBy(xpath="//*[@type='number']")
	private WebElement sliderInputAfterMove;
	
	Actions act;
	public RevenueCalculatorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//this.driver=driver;
		 act=new Actions(driver);
	}
	
	
	public void scrollToSlider()
	{
		act.scrollToElement(slider).build().perform();
		
	}
	
	public void adjustSlider()
	{
		act.clickAndHold(sliderMovePoint).moveByOffset(93, 0).release().build().perform();
		String sliderinput = sliderInputAfterMove.getAttribute("value");
		System.out.println(sliderinput);
		if(sliderinput.equals("817"))
		{
			System.out.println("Input box value change according to slider move");
		}
	}
	
	public void updateSliderInput() throws InterruptedException
	{
		act.scrollToElement(sliderInputTxtBox).build().perform();
		sliderInputTxtBox.click();
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("560").build().perform();
		
	}
	
	public String selectCMPvalue()
	{
		act.scrollToElement(cpt99453CheckBox).build().perform();
		cpt99453CheckBox.click();
		act.scrollToElement(cpt99454CheckBox).build().perform();
		cpt99454CheckBox.click();
		act.scrollToElement(cpt99474CheckBox).build().perform();
		cpt99474CheckBox.click();
		
		String totalRevenuReccuring = totalRevenue.getText();
		return totalRevenuReccuring;
	}


}
