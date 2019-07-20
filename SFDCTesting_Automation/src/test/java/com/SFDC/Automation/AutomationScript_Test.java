package com.SFDC.Automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;



public class AutomationScript_Test extends ReusableMethods {

	static WebDriver driver;


	/*public static void main(String[] args) throws InterruptedException {

		Login();
		ReusableMethods.reports.endTest(logger);
		ReusableMethods.reports.flush();

	}*/
	@AfterTest
	public static void logger() {
		ReusableMethods.reports.endTest(logger);
		ReusableMethods.reports.flush();
	}
	@AfterClass
	public static void closeWindow() {
		driver.close();
	}

	@Test(priority=1,enabled = false)
	public static void initialize_Driver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shank\\Documents\\All-exe-files\\chromedriver_win32\\chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	@Test(priority=2,enabled = false)
	public static void launchUrl() {
		initialize_Driver();
		driver.get("https://login.salesforce.com//");
		driver.manage().window().maximize();
		System.out.println("Application opened");

	}
	@Test(priority=1,enabled=true)
	public static void Login() throws InterruptedException {
		CreateReport("Login");
		launchUrl();

		WebElement UserName = driver.findElement(By.xpath("//input[@id='username']"));
		entertext(UserName,"annigerinagaratna-gqwh@force.com","UserName"); //reusable method


		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		entertext(Password,"Pranavi@1234","Password");


		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		ClickButton(LoginButton,"LoginButton");


		//driver.findElement(By.id("tryLexDialogX")).click();

	}
	@Test(priority=2,enabled=false)
	public static void UserMenu_TC05() throws InterruptedException {
		CreateReport("UserMenu_TC05");
		//launchUrl();
		Login();
		Thread.sleep(3000);
		WebElement UserMenu = driver.findElement(By.id("userNavButton"));
		ClickButton(UserMenu,"UserMenu");
		Thread.sleep(3000);

	}

	@Test(priority=3,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void MyProfile_TC06() throws InterruptedException, IOException {

		CreateReport("MyProfile_TC06");
		//launchUrl();
		WebElement MyProfileLink = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		ClickButton(MyProfileLink,"MyProfileLink");

		WebElement EditButton = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
		ClickButton(EditButton,"EditButton");

		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.id("aboutTab")).click();
		WebElement LastNameField = driver.findElement(By.id("lastName"));
		clearField(LastNameField);
		entertext(LastNameField,"Annigeri","LastNameField");

		Thread.sleep(2000);

		WebElement SaveAllButton = driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		ClickButton(SaveAllButton,"SaveAllButton");
		Thread.sleep(4000);

		WebElement PostLink = driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
		ClickButton(PostLink,"PostLink");

		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		driver.switchTo().frame(Frame);


		String msg = "Hello";
		WebElement TextField = driver.findElement(By.xpath("//html[1]//body[1]"));
		TextField.sendKeys(msg);
		entertext(TextField,msg,"TextField");

		driver.switchTo().defaultContent();

		WebElement ShareButton = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		ClickButton(ShareButton,"ShareButton");

		Thread.sleep(3000);


		WebElement FileLink = driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		ClickButton(FileLink,"FileLink");

		WebElement UploadFileLink = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		ClickButton(UploadFileLink,"UploadFileLink");

		WebElement ChooseFileButton = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		ClickButton(ChooseFileButton,"ChooseFileButton");
		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\shank\\Documents\\AutoItFileUpload\\FileUpload");

		Thread.sleep(6000);

		driver.findElement(By.xpath("//div[@id='chatterFileStageTwo']//a[@class='clearContentPanelButton']")).click();

		Thread.sleep(6000);

		WebElement MouseHover = driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@class='chatter-photo']"));
		Actions MouseHoverAction = new Actions(driver);
		MouseHoverAction.moveToElement(MouseHover).build().perform();

		WebElement AddPhotoLink = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		ClickButton(AddPhotoLink,"AddPhotoLink");

		WebElement frameWindow = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(frameWindow);

		WebElement ChooseFileButton1 = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		ChooseFileButton1.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\shank\\Documents\\AutoItFileUpload\\FileUpload");

		Thread.sleep(9000);

		WebElement SaveButton = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		ClickButton(SaveButton,"SaveButton");

		Thread.sleep(2000);
		WebElement savePhoto1=driver.findElement(By.id("j_id0:j_id7:save"));
		ClickButton(savePhoto1,"savePhoto1");
		System.out.println("Image uploded sucessfully");

	}
	@Test(priority=4,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void UserMenu_MySetting_Personal_TC07() throws InterruptedException{
		CreateReport("UserMenu_MySetting_Personal_TC07");

		WebElement MySettingLink = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		ClickButton(MySettingLink,"MySettingLink");

		WebElement PersonalTab = driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
		ClickButton(PersonalTab,"PersonalTab");

		WebElement LoginHistoryLink = driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
		ClickButton(LoginHistoryLink,"LoginHistoryLink");
		Thread.sleep(3000);

		WebElement DownloadLink = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		ClickButton(DownloadLink,"DownloadLink");

		Thread.sleep(5000);

	}
	@Test(priority=5,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void UserMenu_MySetting_Display_07() throws InterruptedException{
		CreateReport("UserMenu_MySetting_Display_07");

		WebElement MySettingLink = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		ClickButton(MySettingLink,"MySettingLink");

		WebElement DisplayLayoutLink = driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		ClickButton(DisplayLayoutLink,"DisplayLayoutLink");

		WebElement CustomizeMyTab = driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		ClickButton(CustomizeMyTab,"CustomizeMyTab");


		WebElement CustomAppDropDown = driver.findElement(By.xpath("//select[@id='p4']"));
		//CustomAppDropDown.selectByIndex(1);
		selectElementByIndexMethod(CustomAppDropDown,1);


		WebElement AvailableTab = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		//AvailableTab.selectByVisibleText("Reports");
		selectElementByVisibleText(AvailableTab,"Reports","AvailableTab");

		WebElement AddButton = driver.findElement(By.xpath("//a[@id='duel_select_0_right']"));
		ClickButton(AddButton,"AddButton");
		Thread.sleep(5000);

	}
	@Test(priority=6,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void UserMenu_MySetting_Email_07() throws InterruptedException{
		CreateReport("UserMenu_MySetting_Email_07");


		WebElement MySettingLink = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		ClickButton(MySettingLink,"MySettingLink");

		WebElement EmailLink = driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
		ClickButton(EmailLink,"EmailLink");


		WebElement MyEmailSettingLink = driver.findElement(By.xpath("//a[@id='EmailSettings_font']"));
		ClickButton(MyEmailSettingLink,"MyEmailSettingLink");

		WebElement RadioButton = driver.findElement(By.xpath("//input[@id='use_external_email1']"));
		ClickButton(RadioButton,"RadioButton");


		WebElement EmailNameField = driver.findElement(By.xpath("//input[@id='sender_name']"));
		clearField(EmailNameField);

		entertext(EmailNameField,"Max","EmailNameField");


		Thread.sleep(3000);

		WebElement EmailAddressField = driver.findElement(By.xpath("//input[@id='sender_email']"));
		clearField(EmailAddressField);
		Thread.sleep(3000);
		//EmailAddressField.sendKeys("deepachiniwal@gmail.com");
		entertext(EmailNameField,"deepachiniwal@gmail.com","EmailNameField");
		Thread.sleep(3000);

		WebElement AutoBcc = driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		ClickButton(AutoBcc,"AutoBcc");

		Thread.sleep(3000);

		WebElement SaveButton = driver.findElement(By.xpath("//input[@name='save']"));
		ClickButton(SaveButton,"SaveButton");
		Thread.sleep(5000);

	}

	@Test(priority=7,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void UserMenu_MySetting_CalendarReminder_07() throws InterruptedException{
		CreateReport("UserMenu_MySetting_CalendarReminder_07");
		WebElement MySettingLink = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		ClickButton(MySettingLink,"MySettingLink");

		WebElement CalendarReminderLink = driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
		ClickButton(CalendarReminderLink,"CalendarReminderLink");

		WebElement ReminderLink = driver.findElement(By.xpath("//a[@id='Reminders_font']"));
		ClickButton(ReminderLink,"ReminderLink");

		WebElement TestReminder = driver.findElement(By.xpath("//input[@id='testbtn']"));
		ClickButton(TestReminder,"TestReminder");
		Thread.sleep(5000);
	}

	@Test(priority=8,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void UserMenu_DeveloperConsole_08() throws InterruptedException{
		CreateReport("UserMenu_DeveloperConsole_08");
		String defaultWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).click();

		for(String NewWindow  : driver.getWindowHandles()) {
			driver.switchTo().window(NewWindow);

			Thread.sleep(5000);

		}
		driver.close();

		driver.switchTo().window(defaultWindow);

	}
	@Test(priority=9,dependsOnMethods={"UserMenu_TC05"},enabled=false)
	public static void UserMenu_LogOut_09() throws InterruptedException{
		CreateReport("UserMenu_LogOut_09");
		Thread.sleep(3000);

		WebElement LogOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		ClickButton(LogOut,"LogOut");
	}

	@Test(priority=10,dependsOnMethods={"Login"},enabled=false)
	public static void Accounts_Create_New_TC10() throws InterruptedException {
		CreateReport("Accounts_Create_New_TC10");
		Thread.sleep(3000);
		WebElement AccountsTab = driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]"));
		ClickButton(AccountsTab,"Accounts");


		WebElement NewButton = driver.findElement(By.xpath("//input[@name='new']"));

		ClickButton(NewButton,"NewButton");

		WebElement AccountNameField = driver.findElement(By.xpath("//input[@id='acc2']"));
		entertext(AccountNameField,"Max","AccountName");


		Thread.sleep(3000);

		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		ClickButton(SaveButton,"SaveButton");

	}


	@Test(priority=11,dependsOnMethods={"Login"},enabled=false)
	public static void Accounts_Create_New_View_TC11() throws InterruptedException {
		CreateReport("Accounts_Create_New_View_TC11");
		Thread.sleep(3000);
		WebElement AccountsTab = driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]"));
		ClickButton(AccountsTab,"AccountsTab");


		WebElement CreateNewViewLink = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		ClickButton(CreateNewViewLink,"CreateNewViewLink");


		WebElement ViewNAmeField = driver.findElement(By.xpath("//input[@id='fname']"));
		entertext(ViewNAmeField,"Max3","ViewNAmeField");


		WebElement ViewUniqueNameField = driver.findElement(By.xpath("//input[@id='devname']"));
		Thread.sleep(3000);
		clearField(ViewUniqueNameField);
		Thread.sleep(6000);
		entertext(ViewUniqueNameField,"Max_3","ViewUniqueNameField");

		Thread.sleep(3000);

		WebElement SaveButton1 = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
		ClickButton(SaveButton1,"SaveButton1");

	}

	@Test(priority=12,dependsOnMethods={"Login"},enabled=false)
	public static void Accounts_Edit_View_TC12() throws InterruptedException {

		CreateReport("Accounts_Edit_View_TC12");
		Thread.sleep(3000);

		WebElement AccountsTab = driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]"));
		ClickButton(AccountsTab,"AccountsTab");


		Thread.sleep(3000);

		WebElement ViewDropDownOption = driver.findElement(By.xpath("//select[@id='fcf']"));
		//Select ViewDropDown =new Select(ViewDropDownOption);
		//ViewDropDown.selectByIndex(2);
		selectElementByIndexMethod(ViewDropDownOption,0);
		Thread.sleep(3000);



		WebElement EditButton = driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
		ClickButton(EditButton,"EditButton");


		WebElement ViewNAmeField = driver.findElement(By.xpath("//input[@id='fname']"));
		entertext(ViewNAmeField,"abc1","ViewNAmeField");
		Thread.sleep(4000);

		WebElement fieldDropDown = driver.findElement(By.id("fcol1"));
		selectElementByVisibleText(fieldDropDown,"Account Name","fieldDropDown");
		Thread.sleep(3000);


		WebElement OperatorDropDown =driver.findElement(By.xpath("//select[@id='fop1']"));
		selectElementByVisibleText(OperatorDropDown,"contains","OperatorDropDown");
		Thread.sleep(3000);


		//Select OperatorDropDown =new Select(driver.findElement(By.xpath("//select[@id='fop1']")));
		///OperatorDropDown.selectByVisibleText("contains");



		WebElement ValueField = driver.findElement(By.xpath("//input[@id='fval1']"));
		clearField(ValueField);
		entertext(ValueField,"x","ValueField");


		WebElement AvailableField  = driver.findElement(By.xpath("//select[@id='colselector_select_0']"));
		//Select AvailableField =new Select(driver.findElement(By.xpath("//select[@id='colselector_select_0']")));
		//AvailableField.selectByVisibleText("Last Activity");

		selectElementByVisibleText(AvailableField,"Last Activity","AvailableField");
		Thread.sleep(3000);


		WebElement AddButton = driver.findElement(By.xpath("//a[@id='colselector_select_0_right']"));
		ClickButton(AddButton,"AddButton");
		Thread.sleep(3000);

		WebElement SaveButton = driver.findElement(By.name("save"));
		ClickButton(SaveButton,"SaveButton");
		Thread.sleep(3000);

	}
	@Test(priority=13,dependsOnMethods={"Login"},enabled=false)
	public static void Accounts_Merge_TC13() throws InterruptedException {
		CreateReport("Accounts_Merge_TC13");

		WebElement AccountsTab = driver.findElement(By.xpath("//li[@id='Account_Tab']//a[contains(text(),'Accounts')]"));
		AccountsTab.click();
		logger.log(LogStatus.INFO, "AccountsTab successfully");

		WebElement MergeAccountLink = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		MergeAccountLink.click();
		logger.log(LogStatus.INFO, "MergeAccountLink successfully");

		WebElement FindAccountsField = driver.findElement(By.xpath("//input[@id='srch']"));
		FindAccountsField.sendKeys("max");;
		logger.log(LogStatus.INFO, "FindAccountsField successfully");
		Thread.sleep(3000);

		WebElement FindAccountButton = driver.findElement(By.xpath("//input[@name='srchbutton']"));
		FindAccountButton.click();
		logger.log(LogStatus.INFO, "FindAccountButton successfully");

		Thread.sleep(3000);

		WebElement checkbox = driver.findElement(By.id("cid0"));
		checkbox_Checking(checkbox);
		Thread.sleep(3000);
		// checkbox.click();
		logger.log(LogStatus.INFO, "checkbox successfully");

		WebElement checkbox1 = driver.findElement(By.id("cid1"));
		checkbox_Checking(checkbox1);
		Thread.sleep(3000);
		//checkbox1.click();
		logger.log(LogStatus.INFO, "checkbox successfully");

		Thread.sleep(2000);

		WebElement NextButton = driver.findElement(By.name("goNext"));
		NextButton.click();
		logger.log(LogStatus.INFO, "NextButton successfully");

		Thread.sleep(6000);

		WebElement MergeButton = driver.findElement(By.name("save"));
		MergeButton.click();
		logger.log(LogStatus.INFO, "MergeButton successfully");
		Thread.sleep(3000);

		//driver.switchTo().alert().accept();
		checkAlert_Accept();
		Thread.sleep(3000);
		System.out.println("Account got merged");

		Thread.sleep(3000);
	}
	@Test(priority=14,dependsOnMethods={"Login"},enabled=false)
	public static void oppurtunity_TC15() throws InterruptedException {
		CreateReport("oppurtunity_TC15");


		WebElement oppurtunity = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		ClickButton(oppurtunity,"oppurtunityTab");

		WebElement OppurtunityDropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		ClickButton(OppurtunityDropdown,"OppurtunityDropdown");

		//selectAllDropdownValues(OppurtunityDropdown,"OppurtunityDropdown");
		String[] exp = {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New This Week","Opportunity Pipeline","Recently Viewed Opportunities","Won"};
		selectDropdownValidation(OppurtunityDropdown,exp);
		Thread.sleep(4000);


	}


	@Test(priority=15,dependsOnMethods={"oppurtunity_TC15"},enabled=false)
	public static void Create_new_Opty_TC16() throws InterruptedException {

		CreateReport("Create_new_Opty_TC16");
		WebElement NewButton = driver.findElement(By.xpath("//input[@name='new']"));
		ClickButton(NewButton,"NewButton");

		WebElement OpportunityNameField = driver.findElement(By.xpath("//input[@id='opp3']"));
		entertext(OpportunityNameField,"abcd","Opportunity NameField");

		Thread.sleep(3000);

		//String defaultWindow = driver.getWindowHandle();
		//WebElement loopkup= driver.findElement(By.xpath("//a[@id='opp4_lkwgt']"));
		//ClickButton(loopkup,"loopkup");




		WebElement AccountNamefield= driver.findElement(By.xpath("//input[@id='opp4']"));
		//ClickButton(AccountNamefield,"AccountNamefield");
		entertext(AccountNamefield,"abc","AccountNamefield");
		Thread.sleep(3000);

		//input[@id='opp9']


		WebElement CloseDate= driver.findElement(By.xpath("//input[@id='opp9']"));
		ClickButton(CloseDate,"CloseDate");
		Thread.sleep(3000);
		WebElement TodayDate= driver.findElement(By.xpath("//a[@class='calToday']"));
		ClickButton(TodayDate,"CloseDate");
		Thread.sleep(3000);

		WebElement Stage= driver.findElement(By.xpath("//select[@id='opp11']"));
		selectElementByVisibleText(Stage,"Proposal","Stage");
		Thread.sleep(3000);

		WebElement probabilityfield = driver.findElement(By.xpath("//input[@id='opp12']"));
		clearField(probabilityfield);
		entertext(probabilityfield,"40","probabilityfield");
		Thread.sleep(3000);

		WebElement LeadSourceDropDown= driver.findElement(By.xpath("//select[@id='opp6']"));
		selectElementByVisibleText(LeadSourceDropDown,"Partner","LeadSourceDropDown");
		Thread.sleep(3000);



		WebElement PrimaryCampaignSourcefield= driver.findElement(By.xpath("//input[@id='opp17']"));
		//ClickButton(PrimaryCampaignSourcefield,"PrimaryCampaignSource");
		entertext(PrimaryCampaignSourcefield,"abc","PrimaryCampaignSourcefield");

		Thread.sleep(3000);

		WebElement SaveButton= driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		ClickButton(SaveButton,"Save");
		Thread.sleep(3000);
		Thread.sleep(3000);

	}

	@Test(priority=16,dependsOnMethods={"oppurtunity_TC15"},enabled=false)
	public static void oppurtunity_Pipeline_report_TC17() throws InterruptedException {
		CreateReport("oppurtunity_Pipeline_report_TC17");
		WebElement oppurtunity = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		ClickButton(oppurtunity,"oppurtunityTab");

		WebElement oppurtunityPipeline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		ClickButton(oppurtunityPipeline,"oppurtunityPipelineTab");
		Thread.sleep(3000);

	}


	@Test(priority=17,dependsOnMethods={"oppurtunity_TC15"},enabled=false)
	public static void oppurtunity_Stuck_report_TC18() throws InterruptedException {
		CreateReport("oppurtunity_Stuck_report_TC18");
		WebElement oppurtunity = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		ClickButton(oppurtunity,"oppurtunityTab");

		WebElement oppurtunityStuck = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		ClickButton(oppurtunityStuck,"oppurtunityStuck");
		Thread.sleep(3000);

	}

	@Test(priority=18,dependsOnMethods={"oppurtunity_TC15"},enabled=false)
	public static void Test_Quarterly_Summary_Report_TC19() throws InterruptedException {
		CreateReport("Test_Quarterly_Summary_Report_TC19");

		WebElement IntervalDropDown= driver.findElement(By.id("quarter_q"));
		selectElementByVisibleTextList(IntervalDropDown,"Current and Next FQ","IntervalDropDown");
		Thread.sleep(3000);


		WebElement IncludeDropDown= driver.findElement(By.xpath("//select[@id='open']"));
		selectElementByVisibleTextList(IncludeDropDown,"Open Opportunities","IncludeDropDown");
		Thread.sleep(3000);


		WebElement RunReportButton = driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
		ClickButton(RunReportButton,"RunReportButton");

	}

	@Test(priority=19,dependsOnMethods={"Login"},enabled=false)
	public static void LeadTab_TC20() throws InterruptedException {
		CreateReport("LeadTab_TC20");
		WebElement LeadTabLink = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		ClickButton(LeadTabLink,"LeadTabLink");

	}

	@Test(priority=20,dependsOnMethods={"LeadTab_TC20"},enabled=false)
	public static void ViewDropDown_TC21() throws InterruptedException {
		CreateReport("ViewDropDown_TC21");
		WebElement ViewDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		ClickButton(ViewDropDown,"ViewDropDown");
		selectAllDropdownValues(ViewDropDown,"ViewDropDown");

	}

	@Test(priority=21,dependsOnMethods={"LeadTab_TC20"},enabled=false)
	public static void Functionality_Go_Button_TC22() throws InterruptedException {
		CreateReport("Functionality_Go_Button_TC22");

		WebElement ViewDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		ClickButton(ViewDropDown,"ViewDropDown");
		selectElementByVisibleText(ViewDropDown,"Today's Leads","ViewDropDown");

		WebElement UserMenu = driver.findElement(By.id("userNavButton"));
		ClickButton(UserMenu,"UserMenu");
		Thread.sleep(3000);

		WebElement LogOutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		ClickButton(LogOutButton,"LogOutButton");

		Login();
		LeadTab_TC20();

		WebElement GoButton = driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		ClickButton(GoButton,"GoButton");
		Thread.sleep(4000);

	}

	@Test(priority=22,dependsOnMethods={"LeadTab_TC20"},enabled=false)
	public static void TodaysLead_TC23() throws InterruptedException {
		CreateReport("TodaysLead_TC23");

		WebElement ViewDropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		ClickButton(ViewDropDown,"ViewDropDown");
		selectElementByVisibleText(ViewDropDown,"Today's Leads","ViewDropDown");

		WebElement GoButton = driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		ClickButton(GoButton,"GoButton");
		Thread.sleep(4000);
	}


	@Test(priority=23,dependsOnMethods={"LeadTab_TC20"},enabled=false)
	public static void NewButton_TC24() throws InterruptedException {
		CreateReport("NewButton_TC24");

		WebElement NewButton = driver.findElement(By.xpath("//input[@name='new']"));
		ClickButton(NewButton,"NewButton");

		WebElement LastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		entertext(LastName,"ABCD","LastName"); 

		Thread.sleep(3000);
		WebElement CompanyName = driver.findElement(By.xpath("//input[@id='lea3']"));
		entertext(CompanyName,"ABCD","CompanyName");


		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		ClickButton(SaveButton,"SaveButton");
		Thread.sleep(2000);
	}

	@Test(priority=24,dependsOnMethods={"Login"})
	public static void Contact_TC25() throws InterruptedException {
		CreateReport("Contact_TC25");
		WebElement ContactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ClickButton(ContactTab,"ContactTab");

		WebElement NewButton = driver.findElement(By.xpath("//input[@name='new']"));
		ClickButton(NewButton,"NewButton");

		WebElement LastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		entertext(LastName,"ABCD","LastName");
		Thread.sleep(3000);

		WebElement AccountName = driver.findElement(By.xpath("//input[@id='con4']"));
		entertext(AccountName,"abc","AccountName");
		Thread.sleep(3000);
		WebElement SaveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		ClickButton(SaveButton,"SaveButton");

	}


	@Test(priority=24,dependsOnMethods={"Login"})
	public static void Contact_View_TC26() throws InterruptedException {
		CreateReport("Contact_TC25");
		WebElement ContactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ClickButton(ContactTab,"CreateNewViewLink");

		WebElement CreateNewViewLink = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		ClickButton(CreateNewViewLink,"ContactTab");

		WebElement ViewNameField = driver.findElement(By.xpath("//input[@id='fname']"));
		entertext(ViewNameField,"ABCD","ViewNameField");
		
		WebElement ViewUniqueNameField = driver.findElement(By.xpath("//input[@id='devname']"));
		
		clearField(ViewUniqueNameField);
		Thread.sleep(5000);
		entertext(ViewUniqueNameField,"ABCD","ViewUniqueNameField");
		Thread.sleep(3000);
		WebElement SaveButton = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		ClickButton(SaveButton,"SaveButton");

	}

}
