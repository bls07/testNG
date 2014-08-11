package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class TestInclude{
	
	WebDriver driver = new FirefoxDriver();
  
  
	
  @Test(groups = { "3.0","3.3","4.0"})
  public void login() {
	   
	  	String baseUrl = "http://192.168.24.113/";
	    driver.get(baseUrl + "/miq/monitoriq/login.php");
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("admin");
	    driver.findElement(By.id("user_pass")).sendKeys("admin589");
		driver.findElement(By.cssSelector("input.btn.login-btn")).click();
  }
  
  @Test(groups = { "3.0"})
  public void search_a() {
	 
	  driver.get("http://192.168.24.113/miq/monitoriq/search.php?show[]=clips");
	  
  }
	
  @Test(groups = { "4.0"})
  public void search_b() {
	
	  driver.get("http://192.168.24.113/miq/monitoriq/search.php?show[]=recordings");
  }
 

}
