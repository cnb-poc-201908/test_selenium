package com.autotest.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class sampleBaidu {
  @Test
  public void login() throws InterruptedException {
	  //System.out.println("Test OK.");
	  WebDriver driver = null;
	  try {
		  driver = new RemoteWebDriver(new URL("http://bmwpoc.cdkapps.cn:30444/wd/hub/"),new ChromeOptions());
		  } catch (MalformedURLException e) {
		 //TODO Auto-generated catch block
			  e.printStackTrace();
			  }
	  //System.setProperty("webdriver.gecko.driver","/Users/macgouyuling/Documents/Usual/DevOps Folder/Test/resource/geckodriver");
	 // System.setProperty("webdriver.firefox.bin","/Applications/IBM Firefox.app/Contents/MacOS/firefox-bin");
	  //WebDriver driver = new FirefoxDriver();
	  System.out.println("Start Driver!");
	  //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // 页面加载时间
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // 隐式等待
	  //WebDriverWait wait = new WebDriverWait(driver, 30); //显示等待
      driver.manage().window().maximize();
      driver.get("http://bmwpoc.cdkapps.cn:30080");
      System.out.println("Page Title: " + driver.getTitle());
      Thread.sleep(300);
      //JavascriptExecutor js = (JavascriptExecutor)driver;
      //js.executeScript("alert('Running in container!')");
      // Thread.sleep(100);
      
      WebElement input_userid = driver.findElement(By.xpath(".//input[@id='UserID']"));
      WebElement input_userpwd = driver.findElement(By.xpath(".//input[@id='Password']"));
      WebElement btn_signin = driver.findElement(By.xpath(".//button[@label='Sign in']"));
      input_userid.sendKeys("111");
      input_userpwd.sendKeys("111");
      Thread.sleep(50);
      btn_signin.click();
      
      String current_title = driver.getTitle();
      System.out.println(current_title);
      String expected_title = "TEST";
      
      assert expected_title == current_title;
     
      
      driver.quit();
      
      //Reporter.log("Test Passed");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Script execution start.");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Script execution end.");
  }

}
