package pageClasses.PAM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;


public class PAM_VerificationAction_PO extends BasePage {

	public PAM_VerificationAction_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
	}

	// verification action
	@FindBy(xpath = "//b[text()='Application Status:']//following::td")
	private WebElement application_status;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[3]")
	private WebElement custmr_nbr;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[5]")
	private WebElement application_Nbr;

	// personal details

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[8]")
	private WebElement ssn_Nbr;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[10]")
	private WebElement address;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[12]")
	private WebElement email_Id;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[16]")
	private WebElement first_Name;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[18]")
	private WebElement city;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[18]")
	private WebElement dob;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[24]")
	private WebElement last_Name;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[26]")
	private WebElement state;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[28]")
	private WebElement is_Onboarded;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[32]")
	private WebElement middle_name;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[34]")
	private WebElement zip_Code;

	@FindBy(xpath = "//b[text()='Application Status:']//following::td[40]")
	private WebElement uploaded_Doc_personal;

	@FindBy(xpath = "(//b[text()='Uploaded Document:'])[1]")
	private WebElement uploaded_doc;

	// contact info

	@FindBy(xpath = "//td[@id=\"primPhone\"]")
	private WebElement primary_phone;

	@FindBy(xpath = "//td[@id=\"workPhone\"]")
	private WebElement work_Phone;

	@FindBy(xpath = "//td[@id=\"altPhone\"]")
	private WebElement altername_Phone;

	@FindBy(xpath = "///tr[@class='trEven']//child::td[3]")
	private WebElement phonetype_primePhone;

	@FindBy(xpath = "//tr[@class='trEven']//child::td[4]/input[1]")
	private WebElement dnc_primPhone;

	@FindBy(xpath = "//tr[@class='trEven']//child::td[5]/input[1]")
	private WebElement bad_primPhone;

	@FindBy(xpath = "(//tr[@class='trEven'])[2]//child::td[3]")
	private WebElement phonetype_AlternatPhn;

	@FindBy(xpath = "(//tr[@class='trEven'])[2]//child::td[4]/input[1]")
	private WebElement dnc_AlternatPhn;

	// income details

	@FindBy(xpath = "(//tr[@class='trEven'])[2]//child::td[5]/input")
	private WebElement bad_AlternatPhn;

	@FindBy(xpath = "//b[text()='Income Type:']//following::td[1]")
	private WebElement income_type;

	@FindBy(xpath = "//b[text()='Income Type:']//following::td[3]")
	private WebElement employer_name;

	@FindBy(xpath = "//b[text()='Income Type:']//following::td[5]")
	private WebElement direct_deposit;

	@FindBy(xpath = "//td[text()='Bi-Weekly']")
	private WebElement pay_frequency;

	@FindBy(xpath = "//td[text()='Bi-Weekly']//following-sibling::td[2]")
	private WebElement next_paydate;

	@FindBy(xpath = "//td[text()='Bi-Weekly']//following-sibling::td[4]")
	private WebElement second_paydate;

	@FindBy(xpath = "//td[text()='Bi-Weekly']//following::tr//td[2]")
	private WebElement gross_income;

	@FindBy(xpath = "//td[text()='Bi-Weekly']//following::tr//td[4]")
	private WebElement net_income;

	@FindBy(xpath = "(//b[text()='Uploaded Document:'])[1]")
	private WebElement uploaded_doc_income;

	// bank details
	@FindBy(xpath = "//b[text()='Bank Name:']//following::td")
	private WebElement bank_name;

	@FindBy(xpath = "//b[text()='Bank Name:']//following::td[2]")
	private WebElement routing_nbr;

	@FindBy(xpath = "//b[text()='Bank Name:']//following::td[5]")
	private WebElement account_nbr;

	@FindBy(xpath = "//b[text()='Card Type:']")
	private WebElement card_type;

	@FindBy(xpath = "//b[text()='Card Type:']//following::td[3]")
	private WebElement card_nbr;

	@FindBy(xpath = "//b[text()='Card Type:']//following::td[5]")
	private WebElement expiration_date;

	@FindBy(xpath = "(//b[text()='Card Type:']//following::tr/td/b)[1]")
	private WebElement upload_doc_bank;

	// documents and other information

	@FindBy(xpath = "//b[text()='Documents Reviewed']")
	private WebElement documents_reviewed;

	@FindBy(xpath = "//b[text()='Documents Reviewed']//following::div//b")
	private WebElement fax_id;

	@FindBy(xpath = "//b[text()='Documents Reviewed']//following::div[2]//b")
	private WebElement date_time;

	@FindBy(xpath = "//b[text()='Documents Reviewed']//following::div[3]//b")
	private WebElement attachments;

	@FindBy(xpath = "//b[text()='Documents Reviewed']//following::div[4]//b")
	private WebElement re_assign;

	@FindBy(xpath = "//b[text()='Documents Reviewed']//following::div[5]//b")
	private WebElement comment;

	@FindBy(xpath = "//input[@id='uploadOtherId']")
	private WebElement upload_other_doc;

	@FindBy(xpath = "//textarea[@id='otherDocCommentsId']")
	private WebElement comments;

	@FindBy(xpath = "//input[@name='button']")
	private WebElement upload_doc_btn;

	// received

	@FindBy(xpath = "(//input[@id='recievedId'])[4]")
	private WebElement cb_identification_statement_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[5]")
	private WebElement pf_namechange_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[6]")
	private WebElement bankruptcy_notice_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[7]")
	private WebElement govt_id_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[8]")
	private WebElement dismisal_bankrpt_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[9]")
	private WebElement other_br_doc_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[10]")
	private WebElement proof_of_dec_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[11]")
	private WebElement ba_verfy_doc_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[12]")
	private WebElement proof_residence_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[13]")
	private WebElement ssn_itin_verfydoc_rxd;

	@FindBy(xpath = "(//input[@id='recievedId'])[14]")
	private WebElement bank_ac_statment_rxd;

	// verified
	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[4]")
	private WebElement cb_identification_statement_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[5]")
	private WebElement pf_namechange_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[6]")
	private WebElement bankruptcy_notice_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[7]")
	private WebElement govt_id_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[8]")
	private WebElement dismisal_bankrpt_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[9]")
	private WebElement other_br_doc_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[10]")
	private WebElement proof_of_dec_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[11]")
	private WebElement ba_verfy_doc_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[12]")
	private WebElement proof_residence_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[13]")
	private WebElement ssn_itin_verfydoc_vrfd;

	@FindBy(xpath = "(//input[@name='requestBean.verifiedList'])[14]")
	private WebElement bank_ac_statment_vrfd;

	@FindBy(xpath = "//input[@name='customerBean.work_Phone_Verified']")
	private WebElement work_phone_vrfd;

	// loan deatails

	@FindBy(xpath = "//td[text()='LOC']")
	private WebElement product_type;

	@FindBy(xpath = "//td[text()='New']")
	private WebElement customer_type;

	@FindBy(xpath = "//td[text()='Standard']")
	private WebElement application_type;

	@FindBy(xpath = "//td[text()='ACH']")
	private WebElement disbursment_type;

	@FindBy(xpath = "//td[text()='Application Date :']//following::td")
	private WebElement application_date;

	// verification action

	@FindBy(xpath = "//textarea[@id='commentsId']")
	private WebElement comments_verification;

	// footer
	@FindBy(xpath = "//input[@name='cancel']")
	private WebElement cancle_btn;

	@FindBy(xpath = "//input[@value='E-Sign History']")
	private WebElement esign_history_btn;

	@FindBy(xpath = "//input[@id='Follow-UpDate']")
	private WebElement follow_up_days;

	@FindBy(xpath = "//input[@id='Notes']")
	private WebElement notes;

	@FindBy(xpath = "//input[@id='sndMail']")
	private WebElement send_mail;

	@FindBy(xpath = "//td[contains(text(),'OTHER')]//following::td[1]//input[1]")
	private WebElement otherReceived;

	@FindBy(xpath = "//td[contains(text(),'OTHER')]//following::td[2]//input[1]")
	private WebElement otherVerified;

	@FindBy(xpath = "//td[contains(text(),'Proof of Income')]//following::td[1]//input[1]")
	private WebElement pofReceived;

	@FindBy(xpath = "//td[contains(text(),'Proof of Income')]//following::td[2]//input[1]")
	private WebElement pofVerified;

	@FindBy(xpath = "//td[contains(text(),'Bankruptcy Proof')]//following::td[1]//input[1]")
	private WebElement bpocReceived;

	@FindBy(xpath = "//td[contains(text(),'Bankruptcy Proof')]//following::td[2]//input[1]")
	private WebElement bpocVerified;

	@FindBy(id = "primaryPhone")
	private WebElement primaryPhoneVerified;

	@FindBy(id = "verificationActionId")
	private WebElement applicationStatus;

	@FindBy(id = "verificationActionId1")
	private WebElement needESignature;

	@FindBy(xpath = "//input[@id='appLoanAmtId']")
	private WebElement appLoanAmount;

	@FindBy(xpath = "//*[contains(text(), 'Req Loan')]/following::td[1]")
	private WebElement reqLoanAmount;

	@FindBy(xpath = "//input[@id='Submit']")
	private WebElement Submit_Button;

	@FindBy(xpath = "//td[@class='formHeadingCenter']")
	private WebElement infoMessage;

	@FindBy(name = "requestBean.denialId")
	private WebElement denialReason;

	public void click_OtherReceived(String data) {
		selectFrame(frameMain);
		wait.until(ExpectedConditions.visibilityOf(otherReceived));
		doIT(otherReceived, data);
	}

	public void click_OtherVerified(String data) {
		wait.until(ExpectedConditions.visibilityOf(otherVerified));
		doIT(otherVerified, data);
	}

	public void click_pofReceived(String data) {
		doIT(pofReceived, data);
	}

	public void click_pofVerified(String data) {
		doIT(pofVerified, data);
	}

	public void click_bpocReceived(String data) {
		doIT(bpocReceived, data);
	}

	public void click_bpocVerified(String data) {
		doIT(bpocVerified, data);
	}

	public void click_primaryPhoneVerified(String data) {
		doIT(primaryPhoneVerified, data);
	}

	public void set_verificationActionId(String applicationStatus_data) {
		wait.until(ExpectedConditions.visibilityOf(applicationStatus));
		
		doIT(applicationStatus, applicationStatus_data);
	}

	public void set_denialReason(String applicationStatus_data) {
		doIT(denialReason, applicationStatus_data);
	}

	public String get_infoMessage(String applicationStatus_data) {
		return doIT(infoMessage, applicationStatus_data);
	}

	public void click_Submit_Button(String data) {
		wait.until(ExpectedConditions.visibilityOf(Submit_Button));
		doIT(Submit_Button, data);
	}

	public String getApprovedAmount() {
		double amountTemp = Double.parseDouble(reqLoanAmount.getText().replace("$", ""));
		appLoanAmount.clear();
		appLoanAmount.sendKeys(Double.toString(amountTemp + 10));
		needESignature.click();
		String temp = needESignature.getText();
		appLoanAmount.clear();
		appLoanAmount.sendKeys(Double.toString(amountTemp));
		reqLoanAmount.click();
		return temp;
	}
}
