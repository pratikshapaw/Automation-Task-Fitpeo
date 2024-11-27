package com.fitpeo.qa.test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fitpeo.qa.base.BaseClass;
import com.fitpeo.qa.pages.HomePage;
import com.fitpeo.qa.pages.RevenueCalculatorPage;
import com.fitpeo.qa.util.Utility;

public class RevenueCalculatorTest extends BaseClass {
	//WebDriver driver;
	RevenueCalculatorPage revenuecalculatorpage;
	HomePage homepage;
	
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		launchBrowser();
		revenuecalculatorpage=new RevenueCalculatorPage(driver);
		homepage=new HomePage(driver);
	}
	
  @Test(priority = 1)
  public void validateRevenueCalculatorPage() throws InterruptedException
  {
	  homepage.clickOnRevenueCalculator();
	  revenuecalculatorpage.scrollToSlider();
	  revenuecalculatorpage.adjustSlider();
  }
  
  @Test(priority = 2)
  public void validateSliderValue() throws InterruptedException
  {
	  revenuecalculatorpage.updateSliderInput();
  }
  
  @Test(priority = 3)
  public void validateTotalReccuring()
  {
	 String totalrevenue = revenuecalculatorpage.selectCMPvalue();
	 assertEquals(totalrevenue, "Total Recurring Reimbursement for all Patients Per Month:$110700");
  }
//  @AfterMethod
//  public void logout() throws InterruptedException
//  {
//	 
//	  Thread.sleep(2000);
//	  driver.close();
//  }
//  @AfterClass
//  public void tearDown() throws InterruptedException
//  {
//	  closeBrowser();
//	  Thread.sleep(3000);
//  }
  }

