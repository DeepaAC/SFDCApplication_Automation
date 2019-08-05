package com.Salesforce.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SFDC_Steps  extends  ReusableMethods {
	static WebDriver driver;

	@AfterTest
	public static void logger() {
		ReusableMethods.reports.endTest(logger);
		ReusableMethods.reports.flush();
	}


	@Test(priority=1,enabled = false)
	public static void initialize_Driver() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}

	@Given("^Launch the Salesforce login page$")
	public void launch_the_Salesforce_login_page() throws Throwable {
		initialize_Driver();
		driver.get("https://login.salesforce.com//");
		driver.manage().window().maximize();
		System.out.println("Application opened");
	}


	@When("^User enters the valid user name in username field$")
	public void user_enters_the_valid_user_name_in_username_field() throws Throwable {
		CreateReport("user_enters_the_valid_user_name_in_username_field");
		WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
		entertext(UserName,"annigerinagaratna-gqwh@force.com","UserName");
	}

	@When("^user  keeps the password field empty$")
	public void user_keeps_the_password_field_empty() throws Throwable {
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		entertext(Password," ","Password");
	}    

	@Then("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ClickButton(LoginButton,"LoginButton");
		

	}

	@Then("^validate the error message$")
	public void validate_the_error_message() throws Throwable {
		WebElement err_msg = driver.findElement(By.id("error"));
		validateMessage(err_msg,"Please enter your password.","error message");

	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		Thread.sleep(6000);
		driver.quit();  
	}

	@When("^user enters the valid password in password field$")
	public void user_enters_the_valid_password_in_password_field() throws Throwable {
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		entertext(Password,"Pranavi@1234","Password");
	}

	@Then("^user selects the remember me check box$")
	public void user_selects_the_remember_me_check_box() throws Throwable {
		WebElement RemembermeBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		checkbox_Checking(RemembermeBox);
	}

	@Then("^user clicks on user menu drop down$")
	public void user_clicks_on_user_menu_drop_down() throws Throwable {
		WebElement usermenu  = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		ClickButton(usermenu,"usermenu");
	}

	@Then("^click on logout button$")
	public void click_on_logout_button() throws Throwable {
		WebElement LogOutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		ClickButton(LogOutButton,"LogOutButton");
	}

	@Then("^User check for UserName Field to validate$")
	public void user_check_for_UserName_Field_to_validate() throws Throwable {
		WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
		validateMessage(UserName,"annigerinagaratna-gqwh@force.com","UserName");

	}
	@When("^user clicks on forgot password$")
	public void user_clicks_on_forgot_password() throws Throwable {
		WebElement ForgotPassword =driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		ClickButton(ForgotPassword,"ForgotPassword");
	}

	@Then("^user enters the username in the username field$")
	public void user_enters_the_username_in_the_username_field() throws Throwable {
		WebElement ForgotPswdUsername =driver.findElement(By.xpath("//input[@id='un']"));
		entertext(ForgotPswdUsername,"annigerinagaratna-gqwh@force.com","UserName");
	}

	@Then("^clicks on continue button$")
	public void clicks_on_continue_button() throws Throwable {
		WebElement ContinueButton =driver.findElement(By.xpath("//input[@id='continue']"));
		ClickButton(ContinueButton,"ContinueButton");
	}
	@When("^User enters the invalid user name in username field$")
	public void user_enters_the_invalid_user_name_in_username_field() throws Throwable {
		WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
		entertext(UserName,"123","UserName");
	}

	@When("^user enters the invalid password in password field$")
	public void user_enters_the_invalid_password_in_password_field() throws Throwable {
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		entertext(Password," 22131 ","Password");
	}

	@Then("^validate the error message after login$")
	public void validate_the_error_message_after_login() throws Throwable {
		WebElement err_msg = driver.findElement(By.id("error"));
		validateMessage(err_msg,"Please check your username and password. If you still can't log in, contact your Salesforce administrator.","error message");

	}



}
