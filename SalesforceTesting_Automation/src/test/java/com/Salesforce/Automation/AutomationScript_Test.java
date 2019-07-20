package com.Salesforce.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationScript_Test extends ReusableMethods {

	static WebDriver driver;
	
	
	/*public static void main(String[] args) throws InterruptedException {
		
		Login();
		ReusableMethods.reports.endTest(logger);
		ReusableMethods.reports.flush();
		
	}*/
	
	public static void logger() {
		ReusableMethods.reports.endTest(logger);
		ReusableMethods.reports.flush();
	}
	
@Test(priority=1,enabled = false)
	public static void initialize_Driver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shank\\Documents\\All-exe-files\\chromedriver_win32\\chromedriver.exe");

		driver= new ChromeDriver();
	}
@Test(priority=2,enabled = false)
	public static void launchUrl() {
		initialize_Driver();
		driver.get("https://login.salesforce.com//");
		driver.manage().window().maximize();
		System.out.println("Application opened");

	}
@Test(priority=4)
	public static void Login_TC2() throws InterruptedException {
		CreateReport("Login_TC2");
		launchUrl();
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
		entertext(UserName,"annigerinagaratna-gqwh@force.com","UserName"); //reusable method
	

		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		entertext(Password,"Pranavi@1234","Password");
		

		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ClickButton(LoginButton,"LoginButton");
			

		//driver.findElement(By.id("tryLexDialogX")).click();

	}
@Test(priority=3)
public static void LoginError_TC1() {
	CreateReport("LoginError_TC1");
	launchUrl();
	
	WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
	entertext(UserName,"annigerinagaratna-gqwh@force.com","UserName"); //reusable method


	WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
	entertext(Password," ","Password");
	

	WebElement LoginButton = driver.findElement(By.xpath("//input[@id='Login']"));
	ClickButton(LoginButton,"LoginButton");
	//validateMessage(LoginButton,"Please enter your password","Login");
		
	
}
@Test(priority=6)
public static void ValidateLogin_TC4B() {
	CreateReport("ValidateLogin_TC4B");
	launchUrl();
	
	WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
	entertext(UserName,"123","UserName"); //reusable method


	WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
	entertext(Password,"22131 ","Password");
	

	WebElement LoginButton = driver.findElement(By.xpath("//input[@id='Login']"));
	ClickButton(LoginButton,"LoginButton");
	//validateMessage(LoginButton,"Please enter your password","Login");
		
}
@Test(priority=5)
public static void forgotPassword_TC4A() {
	CreateReport("forgotPassword_TC4A");
	launchUrl();
	WebElement ForgotPassword =driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
	ClickButton(ForgotPassword,"ForgotPassword");
	
	WebElement ForgotPswdUsername =driver.findElement(By.xpath("//input[@id='un']"));
	entertext(ForgotPswdUsername,"annigerinagaratna-gqwh@force.com","UserName");
	
	
	WebElement ContinueButton =driver.findElement(By.xpath("//input[@id='continue']"));
	ClickButton(ContinueButton,"ContinueButton");
	
	
	}
@Test(priority=7)
public static void checkRememberMe_TC3() {
	CreateReport("checkRememberMe_TC3");
	launchUrl();
	WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
	entertext(UserName,"annigerinagaratna-gqwh@force.com","UserName"); //reusable method

	WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
	entertext(Password,"Pranavi@1234","Password");
	
	WebElement RemembermeBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
	checkbox_Checking(RemembermeBox);
	
	WebElement LogInButton = driver.findElement(By.xpath("//input[@id='Login']"));
	ClickButton(LogInButton,"LoginButton");
	
	WebElement usermenu  = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	ClickButton(usermenu,"usermenu");


	WebElement LogOutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	ClickButton(LogOutButton,"LogOutButton");
	
	
}


}
