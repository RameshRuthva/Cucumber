package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomerSteps
{

	static WebDriver driver;
	@Given("The user is in telecom home page")
	public void the_user_is_in_telecom_home_page() 
	{
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\eclipse-workspace -Selenium\\Cucumber-1\\driver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/");
	
	}

	@Given("The user are click on add customer")
	public void the_user_are_click_on_add_customer() 
	{
	    driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("The user is filling all the details")
	public void the_user_is_filling_all_the_details() 
	{
	 
		driver.findElement(By.xpath("//label[@for='done']")).click();  // radio button
		driver.findElement(By.id("fname")).sendKeys("fname");
		driver.findElement(By.id("lname")).sendKeys("raja");
		driver.findElement(By.id("email")).sendKeys("ramesh@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("east street");
		driver.findElement(By.name("telephoneno")).sendKeys("9790393374");
	}

	@When("The user click on submit button")
	public void the_user_click_on_submit_button() 
	{
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("The user should be displayed the customer id")
	public void the_user_should_be_displayed_the_customer_id() 
	{
       Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
	}

}
