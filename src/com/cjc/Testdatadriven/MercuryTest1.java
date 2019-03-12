package com.cjc.Testdatadriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class MercuryTest1 {

	public WebDriver driver;

	
  @Test(dataProvider = "getdata")
  public void Loginvalddetails(String username, String password) {
	  System.out.println("Login with valid details");
	  driver.findElement(By.name("userName")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("login")).click();
	  boolean act_title=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_title=true;
	  
	  Assert.assertEquals(act_title, exp_title);
	  System.out.println("Flight finder page is displayed successfully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }

  @DataProvider
  public Object[][] getdata() throws Exception {
    Ecxeldataconfig config=new Ecxeldataconfig();
    config.testdata1("D:\\My Workspace\\MercuryTestdatadriven1\\testdata.xlsx");
    
    int rows=config.getRowcount("Sheet1");
    int columns=config.getcolumncount("Sheet1");
    Object[][] testdata=new Object[rows][columns];
    for(int i=0;i<rows;i++)
    {
    	for(int j=0;j<columns;j++)
    	{
    		testdata[i][j]=config.getdata("Sheet1",i,j);
    	}
    }
    return testdata;
  }
  
  @BeforeClass
  public void maximizewindow() {
	  System.out.println("maximze the window under before class");
	  driver.manage().window().maximize();
	  System.out.println("the window maxmsed sussessfully");
  }

  @BeforeTest
  public void url () {
	  System.out.println("Get browser under before test ");
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println("the broser url opened successfully");
	  
  }

  @BeforeSuite
  public void openbrowser() 
  {
	  System.out.println("Open the browser");
	  System.setProperty("webdriver.chrome.driver","D:\\16122018\\chromedriver_win32 (14)\\chromedriver.exe");
		 driver=new ChromeDriver();
		  System.out.println("the browser opened successfully");
  }

}
