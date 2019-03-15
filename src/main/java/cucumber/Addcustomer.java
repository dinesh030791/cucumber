package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Addcustomer extends Base{
	
	@Given("The user to be in add customer page")
	public void the_user_to_be_in_add_customer_page() {
		WebDriver driver=getDriver();
		loadurl("http://demo.guru99.com/telecom/addcustomer.php");
	    
	}

	@When("The user needs to fill the customer details")
	public void the_user_needs_to_fill_the_customer_details() {
	driver.findElement(By.id("fname")).sendKeys("Dinesh");
	driver.findElement(By.id("lname")).sendKeys("Kumar");
	driver.findElement(By.id("email")).sendKeys("dineshkumar@gmail.com");
	driver.findElement(By.name("addr")).sendKeys("Kodungaiyur");
	driver.findElement(By.id("telephoneno")).sendKeys("8773456781");
	}

	@When("The user needs to click the submit button")
	public void the_user_needs_to_click_the_submit_button() {
		driver.findElement(By.name("submit")).click();   
	}

	@Then("The user able to see the success message")
	public void the_user_able_to_see_the_success_message() {
	Assert.assertEquals("Please Note Down Your CustomerID", driver.findElement(By.xpath("//table//tr[2]//b")).getText());   
	}

	@Then("The user able to see the customer ID")
	public void the_user_able_to_see_the_customer_ID() {
	Assert.assertTrue(driver.findElement(By.xpath("//table//tr[1]//b")).isDisplayed());   
	}



}
