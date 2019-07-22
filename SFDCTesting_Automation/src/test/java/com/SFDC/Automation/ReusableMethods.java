package com.SFDC.Automation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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


	static String filename =new SimpleDateFormat("'SFDCExtentReport_'yyyyMMddHHmm'.html'").format(new Date()); 
	static String path ="C:\\Users\\shank\\Documents\\SalesForceTesting\\ReportGenerated\\"+filename;
	static ExtentReports reports = new ExtentReports(path);
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
			System.out.println("Actual Message is "+ actuallMessage);
			if(actuallMessage.equals(ExpectedMessage)) {
				System.out.println("Pass: "+ ObjName +" ExpectedMessage matches the actual message");
				logger.log(LogStatus.PASS, ObjName +" ExpectedMessage matches the actual message");
			}else {
				System.out.println("Fail: "+ ObjName + " does not matches the actual message");
				logger.log(LogStatus.FAIL,ObjName +"ExpectedMessage does not matches the actual message");
			}
			//System.out.println("Pass: " + ObjName + "is clicked" );
		}else {
			//System.out.println("Fail "+ ObjName + " is not clicked , please check the appliocation");
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
	public static void selectElementByVisibleText(WebElement element, String Name,String ObjName) {



		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
		System.out.println("option is selected");

		if(!Name.isEmpty()) {
			System.out.println("PASS" + Name +" value is entered in " + ObjName + " field");
			logger.log(LogStatus.PASS,Name +" value is entered in " + ObjName + " field" );
		}
		else{
			System.out.println("Fail "+ Name + "isnot enabled , please check the appliocation");
			logger.log(LogStatus.FAIL,Name +"Field doesnot exist please check the application" );
		}
	}


	public static void selectDropdownValidation(WebElement element,String[]expected) {

		Select	select = new Select(element); 
		List<WebElement> options = select.getOptions(); 
		for(WebElement item:options) 
		{  
			for (int i=0; i<expected.length; i++){
				if (item.getText().equals(expected[i])){
					//System.out.println("Matched");
				}
			}
		} 
		System.out.println("All the items Matched");
		if(!options.isEmpty()) {
			System.out.println("PASS"+" Expected values matches Actual values");
			logger.log(LogStatus.PASS ,"Expected values matches Actual values" );
		}
		else{
			System.out.println("Fail "+ "Expected values does not matches Actual values");
			logger.log(LogStatus.FAIL," Expected values does not matches Actual values" );
		}


	}


	public static void selectAllDropdownValues(WebElement element,String ObjName) {

		Select select = new Select(element); 
		List<WebElement> options = select.getOptions(); 
		for(WebElement item:options) 
		{ 
			System.out.println("Dropdown values are "+ item.getText());           
		}

		if(!options.isEmpty()) {
			System.out.println("Pass : All " + ObjName + " items are selected");
			logger.log(LogStatus.PASS, "All " + ObjName + " items are selected" );
		}
		else{
			System.out.println("Fail: All " + ObjName + " items are not selected");
			logger.log(LogStatus.FAIL,"All " + ObjName + " items are not selected" );
		}
	}





	public static void selectElementByVisibleTextList(WebElement element, String Name,String ObjName) {



		Select selectitem = new Select(element);
		//selectitem.selectByVisibleText(Name);
		//System.out.println("option is selected");

		List<WebElement> list=selectitem.getOptions();
		for(int i=0;i<list.size();i++)          
		{
			selectitem.selectByVisibleText(Name);
			// System.out.println(list.get(i).getText());

		}
		System.out.println("option is selected");
		if(!Name.isEmpty()) {
			System.out.println("PASS" + Name +" value is entered in " + ObjName + " field");
			logger.log(LogStatus.PASS,Name +" value is entered in " + ObjName + " field" );
		}
		else{
			System.out.println("Fail "+ Name + "isnot enabled , please check the appliocation");
			logger.log(LogStatus.FAIL,Name +"Field doesnot exist please check the application" );
		}
	}

	/*Name of the method: selectElementByValueMethod
	 * Brief Description: selecting the option from dropdown
	 * Arguments: element:WebElement, Value: Value of the option
	 * Created by:Automation Team
	 * Creation Date :July 16 2019
	 * Last Modified:July 16 2019

	 * */
	public static void selectElementByValueMethod(WebElement element,String value,String ObjName) {
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
		System.out.println("option is selected");
		if(!value.isEmpty()) {
			System.out.println("PASS" + ObjName +" value is entered in " + ObjName + " field");
			logger.log(LogStatus.PASS,ObjName +" value is entered in " + ObjName + " field" );
		}
		else{
			System.out.println("Fail "+ ObjName + "isnot enabled , please check the appliocation");
			logger.log(LogStatus.FAIL,ObjName +"Field doesnot exist please check the application" );
		}
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
	public static void checkAlert_Accept() {
		/*try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.accept();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}*/

		driver.switchTo().alert();
		System.out.println("Pass: Alert is present and accepted");
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




