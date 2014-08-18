package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class LoginTest113 {

	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest(groups = { "ver3.0" })
	
	public void miq113(){
	  	
	    String baseUrl = "http://192.168.24.113/";
	    driver.get(baseUrl + "/miq/monitoriq/login.php");
	    
		}
	
	@BeforeTest(groups = { "ver4.0" })

	public void miq51() {
				
	  
	    String baseUrl = "http://192.168.24.51/";
	    driver.get(baseUrl + "/miq/monitoriq/login.php");

	}
  
  
	
	@Test(timeOut=3000)
	public void login113()  {
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("admin");
	    driver.findElement(By.id("user_pass")).sendKeys("admin589");
		driver.findElement(By.cssSelector("input.btn.login-btn")).click();
		System.out.println("check 1");
 }
	
	@Test(dependsOnMethods = { "login113" })
	public void logout113(){
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
		
	}
}
