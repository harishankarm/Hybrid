package pageClasses.PAM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;


public class PAM_NewLoan_PO extends BasePage {

	public PAM_NewLoan_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
	}

	@FindBy(name = "advanceRequestBean.emailConsentFlag")
	private WebElement electronicDoc;

	// header
	@FindBy(xpath = "(//td[@class='rightHeading'])[1]")
	private WebElement name;

	@FindBy(xpath = "//td[@class='rightheading']//a")
	private WebElement ssn;

	@FindBy(xpath = "(//td[@class='rightHeading'])[2]")
	private WebElement address;

	// line of credit
	@FindBy(xpath = "(//input[@class='textBox120editable'])[1]")
	private WebElement line_of_crdt;

	@FindBy(xpath = "//input[@name='stmtDueDate1']")
	private WebElement due_date_month;

	@FindBy(xpath = "//input[@name='stmtDueDate2']")
	private WebElement due_date_date;

	@FindBy(xpath = "//input[@name='stmtDueDate3']")
	private WebElement due_date_year;

	@FindBy(xpath = "//input[@name='dueDate1']")
	private WebElement stmt_date_month;

	@FindBy(xpath = "//input[@name='dueDate2']")
	private WebElement stmt_date_date;

	@FindBy(xpath = "//input[@name='dueDate3']")
	private WebElement stmt_date_year;

	@FindBy(xpath = "(//td[@class='leftHeading'])[8]")
	private WebElement membership_fee;

	@FindBy(xpath = "(//td[@class='leftHeading'])[10]")
	private WebElement cashadvance_fee;

	@FindBy(xpath = "(//input[@class='textBox120editable'])[2]")
	private WebElement intrest_rate;

	@FindBy(xpath = "//input[@name='allowAch']")
	private WebElement allow_ACH_debits;
	// loandetails

	@FindBy(xpath = "//input[@name='htmlAdvanceAmt']")
	private WebElement loandetail_loanamt;

	@FindBy(name = "tempFeeAmt")
	private WebElement loan_feee;

	@FindBy(xpath = "(//input[@class='textBox50NoneditableMonetary1'])[3]")
	private WebElement promotions;

	@FindBy(xpath = "(//input[@class='textBox50NoneditableMonetary1'])[4]")
	private WebElement total_due;

	@FindBy(xpath = "//input[@name='promotions']")
	private WebElement promotions_btn;

	@FindBy(xpath = "//input[@name='advanceRequestBean.loanAmount']")
	private WebElement loanAmt;

	@FindBy(className = "formHeading")
	private static WebElement loanType;

	@FindBy(name = "finishadvance")
	private WebElement finishLoan_Button;

	// Please Confirm
	@FindBy(xpath = "(//*[@name='OKBut'])[2]")
	private WebElement yes_Button;

	@FindBy(xpath = "(//*[@name='cancleBut'])[2]")
	private WebElement no_Button;

	// Loan Originated Successful
	@FindBy(xpath = "//input[@name='ok']")
	private WebElement ok_Button;

	// LOC
	@FindBy(xpath = "//input[@name='ok'] [@value='Yes']")
	private WebElement yes_ButtonLOC;

	@FindBy(xpath = "//input[@name='ok'] [@value='No']")
	private WebElement no_ButtonLOC;

	public void set_ElectronicDoc(String applicationStatus_data) {
		selectFrame(frameMain);
		doIT(electronicDoc, applicationStatus_data);
	}

	public void click_FinishLoan_Button(String data) {
		doIT(finishLoan_Button, data);
	}

	public void click_Yes_Button(String data) {
		doIT(yes_Button, data);
	}

	public void click_No_Button(String data) {
		doIT(no_Button, data);
	}

	public void click_No_ButtonLOC(String data) {
		doIT(no_ButtonLOC, data);
	}

	public void click_Yes_ButtonLOC(String data) {
		doIT(yes_ButtonLOC, data);
	}

	public void click_Ok_Button(String data) {
		doIT(ok_Button, data);
		System.out.println();
	}

	public String getLoanType() {
		return loanType.getText();
	}

	public void getLoantypee(String applicationStatus_data) {

		if (!getLoanType().contains("Line Of Credit")) {
			set_ElectronicDoc(applicationStatus_data);

		}

	}
}
