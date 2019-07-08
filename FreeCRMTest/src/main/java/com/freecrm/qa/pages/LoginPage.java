package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(linkText = "Sign Up/Log In")
	 WebElement login_link;
	@FindBy(id ="auth-modal-email")
	 WebElement email;
	@FindBy(xpath ="//button[@type ='submit']")
	 WebElement nextbutton;
	@FindBy(id ="auth-modal-password")
	 WebElement pass;
	@FindBy(xpath ="//button[text() ='Log In']")
	 WebElement loginbutton;

  public LoginPage() {
	  PageFactory.initElements(driver, this);
  }
  public String siteTitle() {
	  return driver.getTitle();
  }
  
  public void login(String un,String pa) {
	  login_link.click();
	  try {
		Thread.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  email.sendKeys(un);
	  nextbutton.click();
	  pass.sendKeys(pa);
	  loginbutton.click();
  }
	
	
	
}
