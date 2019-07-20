package com.Salesforce.Automation;

import java.util.Iterator;

// This is the program
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {
	
	

	static WebDriver driver;
	static ExtentTest logger;
	
	static ExtentReports reports = new ExtentReports("C:\\Users\\shank\\Documents\\SalesForceTesting\\ReportGenerated\\SDFCUserMenuTC7.html");
		//String path = "C:\\Users\\shank\\Documents\\SalesForceTesting\\ReportGenerated\\SDFCUserMenuTC7.html" ;
		//reports = new ExtentReports(path);
	

	public static ExtentTest CreateReport(String ReportName) {
		logger = reports.startTest(ReportName);
		return logger;
	}

	/*Name of the method: enterText
	 * Brief Description: Enter the text into text box
	 * Arguments: obj:WebElement, text ---text to be enetered , objNAme-- Name of the object
	 * Created by:Automation Team
	 * Creation Date :July 15 2019
	 * Last Modified:July 15 2019

	 * */


	public static void entertext(WebElement obj, String text, String objectName) {

		if(obj.isEnabled()) {
			obj.sendKeys(text);
			System.out.println("pass "+ text +" is enetered in "+ objectName + " field");
		logger.log(LogStatus.PASS,text +"value is entered in " +objectName + "field" );
		}
		else{
			System.out.println("Fail "+ objectName + "isnot enabled , please check the appliocation");
			logger.log(LogStatus.FAIL,text +objectName +"Field doesnot exist please check the application" );
		}
	}


	/*Name of the method: ClickButton
	 * Brief Description: Click on the button
	 * Arguments: obj:WebElement,  objNAme-- Name of the object
	 * Created by:Automation Team
	 * Creation Date :July 15 2019
	 * Last Modified:July 15 2019

	 * */

	//Reusable Method
	public static void ClickButton(WebElement obj, String objectName) {

		if(obj.isEnabled()) {
			obj.click();
			System.out.println("pass " + objectName + " is clicked");
			logger.log(LogStatus.PASS,objectName + " is clicked");
		}
		else{
			System.out.println("Fail "+ objectName + "is not clicked , please check the appliocation");
			logger.log(LogStatus.FAIL,objectName + "is not clicked , please check the appliocation");
		}
	}

	/*Name of the method: CheckBox
	 * Brief Description: Click on the button
	 * Arguments: obj:WebElement, objNAme-- Name of the object
	 * Created by:Automation Team
	 * Creation Date :July 15 2019
	 * Last Modified:July 15 2019

	 * */

	//Reusable Method
	public static void CheckBox(WebElement obj, String objectName) {

		if(obj.isEnabled()) {
			obj.click();
			System.out.println("pass "+ obj +" is clicked");
		}
		else{
			System.out.println("Fail "+ objectName + " is not clicked , please check the appliocation");
		}
	}


	/*Name of the method: RadioButton
	 * Brief Description:Click on the button
	 * Arguments: obj:WebElement, objNAme-- Name of the object
	 * Created by:Automation Team
	 * Creation Date :July 15 2019
	 * Last Modified:July 15 2019

	 * */

	//Reusable Method
	public static void RadioButton(WebElement obj, String objectName) {

		if(obj.isEnabled()) {
			obj.click();
			System.out.println("pass "+ obj +" is clicked");
		}
		else{
			System.out.println("Fail"+objectName+"is not clicked , please check the appliocation");
		}
	}
	/*Name of the method: validateMessage /Compare 2 Strings
	 * Brief Description: Enter the text into text box
	 * Arguments: obj:WebElement, text ---text to be enetered , objNAme-- Name of the object
	 * Created by:Automation Team
	 * Creation Date :July 15 2019
	 * Last Modified:July 15 2019

	 * */
	public static void validateMessage(WebElement Obj,String ExpectedMessage,String ObjName) {
		String actuallMessage;
		if(Obj.isEnabled()) {
			actuallMessage = Obj.getText();
			if(actuallMessage.equals("ExpectedMessage")) {
				System.out.println("Pass: matches the actual message");
			}else {
				System.out.println("Fail: does not matches the actual message");
			}
			System.out.println("Pass: " + ObjName + "is clicked" );
		}else {
			System.out.println("Fail "+ ObjName + " is not clicked , please check the appliocation");
		}

	}

	/*Name of the method: closeBrowser
	 * Brief Description: To closeBrowser
	 * Arguments: obj:
	 * Created by:Automation Team
	 * Creation Date :July 16 2019
	 * Last Modified:July 16 2019

	 * */
	public static void closeBrowser() {
		if(!driver.toString().contains("null")) {
			driver.close();
		}			

	}

	/*Name of the method: clearField
	 * Brief Description: To clear the field
	 * Arguments: obj:WebElement
	 * Created by:Automation Team
	 * Creation Date :July 16 2019
	 * Last Modified:July 16 2019

	 * */
	public static void clearField(WebElement obj) {
		obj.clear();
		System.out.println("field is cleared");

	}

	/*Name of the method: selectElementByVisibleText
	 * Brief Description: Enter the text into text box
	 * Arguments: element:WebElement, Name: Name of the option
	 * Created by:Automation Team
	 * Creation Date :July 15 2019
	 * Last Modified:July 15 2019

	 * */
	public static void selectElementByVisibleText(WebElement element, String Name) {
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
		System.out.println("option is selected");
	}

	/*Name of the method: selectElementByValueMethod
	 * Brief Description: selecting the option from dropdown
	 * Arguments: element:WebElement, Value: Value of the option
	 * Created by:Automation Team
	 * Creation Date :July 16 2019
	 * Last Modified:July 16 2019

	 * */
	public static void selectElementByValueMethod(WebElement element,
			String value) {
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
		System.out.println("option is selected");
	}

	/*Name of the method: selectElementByIndexMethod
	 * Brief Description: selecting the option from dropdown
	 * Arguments: element:WebElement, Index: Index of the option
	 * Created by:Automation Team
	 * Creation Date :July 16 2019
	 * Last Modified:July 16 2019

	 * */
	public static void selectElementByIndexMethod(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
		System.out.println("option is selected");
	}


	/*Name of the method: checkAlert_Accept
	 * Brief Description: Alert Accept
	 * Arguments:N/A
	 * Created by:Automation Team
	 * Creation Date :July 16 2019
	 * Last Modified:July 16 2019

	 * */
	public static boolean checkAlert_Accept() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.accept();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}
	public static void checkbox_Unchecking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
	}


	public static void checkbox_Checking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			System.out.println("Checkbox is already checked");
		} else {
			checkbox.click();
			System.out.println("Checked the checkbox");
		}
	}

	public static void switchToNewWindow() throws InterruptedException {
		/*Set s = driver.getWindowHandles();
			Iterator itr = s.iterator();
			String w1 = (String) itr.next();
			//String w2 = (String) itr.next();
			driver.switchTo().window(w1);*/


		for(String NewWindow  : driver.getWindowHandles()) {
			driver.switchTo().window(NewWindow);

			Thread.sleep(5000);

		}

	}

	public static void switchToOldWindow() {
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w1);
	}

	public static void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}

}



