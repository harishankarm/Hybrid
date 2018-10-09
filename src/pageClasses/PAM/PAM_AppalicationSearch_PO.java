package pageClasses.PAM;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;



public class PAM_AppalicationSearch_PO extends BasePage {

	public PAM_AppalicationSearch_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	@FindBy(name = "requestBean.queueSelected")
	private WebElement queueChk;

	@FindBy(name = "requestBean.queueNames")
	private WebElement queueName;

	@FindBy(name = "requestBean.productType")
	private WebElement prodType;

	@FindBy(name = "requestBean.assignedUser")
	private WebElement assignUser;

	@FindBy(name = "requestBean.applicationStatus")
	private WebElement applicationStatus;

	@FindBy(name = "requestBean.firstName")
	private WebElement firstName;

	@FindBy(name = "requestBean.lastName")
	private WebElement lastName;

	@FindBy(name = "ssn1")
	private WebElement SSN1;

	@FindBy(name = "ssn2")
	private WebElement SSN2;

	@FindBy(name = "ssn3")
	private WebElement SSN3;

	@FindBy(name = "requestBean.applicationNbr")
	private WebElement applicationNbr;

	@FindBy(name = "requestBean.cusNbr")
	private WebElement customerNbr;

	@FindBy(name = "requestBean.email")
	private WebElement email;

	@FindBy(name = "requestBean.bankAccount")
	private WebElement bankAccount;

	@FindBy(name = "requestBean.address")
	private WebElement address;

	@FindBy(name = "requestBean.zipCode")
	private WebElement zipCode;

	@FindBy(name = "requestBean.employerName")
	private WebElement employerName;

	@FindBy(name = "dobMonth")
	private WebElement dobMonth;

	@FindBy(name = "dobDay")
	private WebElement dobDay;

	@FindBy(name = "dobYear")
	private WebElement dobYear;

	@FindBy(name = "requestBean.phoneType")
	private WebElement phoneType;

	@FindBy(name = "requestBean.phoneNbr")
	private WebElement phoneNum;

	@FindBy(name = "requestBean.stateCode")
	private WebElement stateCode;

	@FindBy(name = "requestBean.followfromDays")
	private WebElement followfromDays;

	@FindBy(name = "requestBean.followtoDays")
	private WebElement followtoDays;

	@FindBy(name = "requestBean.fromCreditScore")
	private WebElement fromCreditScore;

	@FindBy(name = "requestBean.toCreditScore")
	private WebElement toCreditScore;

	@FindBy(name = "appDate4")
	private WebElement appFromMonth;

	@FindBy(name = "appDate5")
	private WebElement appFromDate;

	@FindBy(name = "appDate6")
	private WebElement appFromYear;

	@FindBy(name = "appDate7")
	private WebElement appToMonth;

	@FindBy(name = "appDate8")
	private WebElement appToDate;

	@FindBy(name = "appDate9")
	private WebElement appToYear;

	@FindBy(xpath = "//input[@value='All']")
	private WebElement sourceAll;

	@FindBy(xpath = "//input[@value='Organic']")
	private WebElement sourceOrganic;

	@FindBy(xpath = "//input[@value='Referal']")
	private WebElement sourceReferal;

	@FindBy(xpath = "//input[@value='LeadProvider']")
	private WebElement sourceLeadProvider;

	@FindBy(xpath = "//input[@value='requestBean.leadName']")
	private WebElement sourceLeadProviderName;

	@FindBy(name = "requestBean.channel")
	private WebElement channelType;

	@FindBy(name = "requestBean.custType")
	private WebElement custType;

	@FindBy(name = "requestBean.collateralType")
	private WebElement collateralType;

	@FindBy(name = "requestBean.disbType")
	private WebElement disbType;

	@FindBy(name = "requestBean.loanType")
	private WebElement loanType;

	@FindBy(name = "cancel")
	private WebElement cancel_Button;

	@FindBy(xpath = "//input[@value='Reset']")
	private WebElement reset;

	@FindBy(name = "submit")
	private WebElement submit_Button;

	@FindBy(xpath = "//td[contains(text(),'Applicant Search')]")
	private WebElement appalicantSearch;

	@FindBy(xpath = "//*[@color='red']/ul")
	private WebElement noRecordError;

	public boolean verifyAppalicantSearch() {
		return appalicantSearch.isDisplayed();
	}

	public void set_queueChk(String queueChk_data) {
		doIT(queueChk, queueChk_data);
	}

	public void set_queueName(String queueName_data) {
		doIT(queueName, queueName_data);
	}

	public void set_prodType(String prodType_data) {
		doIT(prodType, prodType_data);
	}

	public void set_assignUser(String assignUser_data) {
		doIT(assignUser, assignUser_data);
	}

	public void set_applicationStatus(String applicationStatus_data) {
		doIT(applicationStatus, applicationStatus_data);
	}

	public void set_firstName(String firstName_data) {
		doIT(firstName, firstName_data);
	}

	public void set_lastName(String lastName_data) {
		doIT(lastName, lastName_data);
	}

	public void set_applicationNbr(String applicationNbr_data) {
		doIT(applicationNbr, applicationNbr_data);
	}

	public void set_customerNbr(String customerNbr_data) {
		doIT(customerNbr, customerNbr_data);
	}

	public void set_email(String email_data) {
		doIT(email, email_data);
	}

	public void set_bankAccount(String bankAccount_data) {
		doIT(bankAccount, bankAccount_data);
	}

	public void set_address(String address_data) {
		doIT(address, address_data);
	}

	public void set_zipCode(String zipCode_data) {
		doIT(zipCode, zipCode_data);
	}

	public void set_employerName(String employerName_data) {
		doIT(employerName, employerName_data);
	}

	public void set_phoneType(String phoneType_data) {
		doIT(phoneType, phoneType_data);
	}

	public void set_phoneNum(String phoneNum_data) {
		doIT(phoneNum, phoneNum_data);
	}

	public void set_stateCode(String stateCode_data) {
		doIT(stateCode, stateCode_data);
	}

	public void set_followfromDays(String followfromDays_data) {
		doIT(followfromDays, followfromDays_data);
	}

	public void set_followtoDays(String followtoDays_data) {
		doIT(followtoDays, followtoDays_data);
	}

	public void set_fromCreditScore(String fromCreditScore_data) {
		doIT(fromCreditScore, fromCreditScore_data);
	}

	public void set_toCreditScore(String toCreditScore_data) {
		doIT(toCreditScore, toCreditScore_data);
	}

	public void set_sourceAll(String sourceAll_data) {
		doIT(sourceAll, sourceAll_data);
	}

	public void set_sourceOrganic(String sourceOrganic_data) {
		doIT(sourceOrganic, sourceOrganic_data);
	}

	public void set_sourceReferal(String sourceReferal_data) {
		doIT(sourceReferal, sourceReferal_data);
	}

	public void set_sourceLeadProvider(String sourceLeadProvider_data) {
		doIT(sourceLeadProvider, sourceLeadProvider_data);
	}

	public void set_sourceLeadProviderName(String sourceLeadProviderName_data) {
		doIT(sourceLeadProviderName, sourceLeadProviderName_data);
	}

	public void set_channelType(String channelType_data) {
		doIT(channelType, channelType_data);
	}

	public void set_custType(String custType_data) {
		doIT(custType, custType_data);
	}

	public void set_collateralType(String collateralType_data) {
		doIT(collateralType, collateralType_data);
	}

	public void set_disbType(String disbType_data) {
		doIT(disbType, disbType_data);
	}

	public void set_loanType(String loanType_data) {
		doIT(loanType, loanType_data);
	}

	public void click_cancel_Button(String data) {
		doIT(cancel_Button, data);
	}

	public void click_submit_Button(String data) {
		doIT(submit_Button, data);
	}

	public void set_appalicantSearch(String appalicantSearch_data) {
		doIT(appalicantSearch, appalicantSearch_data);
	}

	public boolean getNoRecordError() {
		return isDisplayed(noRecordError);
	}

	public void set_SSN(String SSN_data) {
		if (!SSN_data.isEmpty()) {
			doIT(SSN1, SSN_data.substring(0, 3));
			doIT(SSN2, SSN_data.substring(3, 5));
			doIT(SSN3, SSN_data.substring(5));
		}
	}

	public void set_DOB(String DOB_data) {
		if (!DOB_data.isEmpty()) {
			String[] DOB = DOB_data.split("/", -2);
			doIT(dobMonth, DOB[0]);
			doIT(dobDay, DOB[1]);
			doIT(dobYear, DOB[2]);
		}
	}

	public void set_ApplicationDate(String fromDate, String todate) {
		if (!fromDate.isEmpty()) {
			String[] fdate = fromDate.split("/", -2);
			doIT(appFromMonth, fdate[0]);
			doIT(appFromDate, fdate[1]);
			doIT(appFromYear, fdate[2]);
			String[] tdate = todate.split("/", -2);
			doIT(appToMonth, tdate[0]);
			doIT(appToDate, tdate[1]);
			doIT(appToYear, tdate[2]);
		}
	}

	public void switchToChildWindows() {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		parentWindowId = it.next();
		childWindowId = it.next();
		driver.switchTo().window(childWindowId);
	}

}
