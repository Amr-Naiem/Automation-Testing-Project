package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  
	WebDriver driver;
	String baseUrl="https://automationexercise.com";
	
	
  @BeforeClass
  public void beforeTest() 
  {
      // Step 1: Initialize the Edge WebDriver
      //driver= new ChromeDriver();
	  driver= new EdgeDriver();
	  
	  // Step 2: Navigate to the base URL
	  driver.navigate().to(baseUrl); 
	  
	  // Step 3: Maximize the browser window for better visibility
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterTest() 
  {
	  driver.close();
  }

}
