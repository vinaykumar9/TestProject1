package com.freecrm.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	 public void setUp() {
		initilization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority =1)
	 public void loginTitle() {
	String sitetitle =loginpage.siteTitle();
	Assert.assertEquals(sitetitle, "StoryWeaver");
	
	}
	@Test(priority =2)
	public void verifylogin() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

   @Test(priority =3)
    public void verifyInvalidLogin() {
		loginpage.login(prop.getProperty("username1"), prop.getProperty("password2"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	String notification=loginpage.slimPopupNotification();
		Assert.assertEquals(notification , "Invalid email or password.");
	   
   }
	
	@AfterMethod()
     public void tearDown() {
		driver.quit();
	}
}

