package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.freexrm.utility.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		 try {
			 prop = new Properties(	);
			 FileInputStream fin = new FileInputStream("G:\\v\\FreeCRMTest\\src\\main\\java\\com\\freecrm\\config\\config.properties");
              prop.load(fin);
             
		 }
		 catch(FileNotFoundException  e){
			 e.printStackTrace();
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
}
	
	
	public static void initilization() {
		String browser_name = prop.getProperty("browser");
		if(browser_name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chrome_windows//chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.ie.driver","C:\\Users\\DELL\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			 }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implict_time, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static String slimPopupNotification() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return	driver.findElement(By.cssSelector("p.pb-slim-notification__content")).getText();	
	}
  
} 
