package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest51 {
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void miq51(){
	  	
	    String baseUrl = "http://192.168.24.51/";
	    driver.get(baseUrl + "/miq-ci/monitoriq/login.php");
	    
	}
 
	@Test(description = "login51-->class-->LoginTest51-->tests")
  	public void login51( ) {
			  
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("admin");
	    driver.findElement(By.id("user_pass")).sendKeys("admin589");
		driver.findElement(By.cssSelector("input.btn.login-btn")).click();

	}
	
	@Test(dependsOnMethods = { "login51" })
	public void logout51(){
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}
	
}
