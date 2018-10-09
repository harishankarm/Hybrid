package pageClasses.PAM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Manish Kumar Pandey
 *
 */
public class Qfund_Navigation_PO extends BasePage {

	public Qfund_Navigation_PO(WebDriver _driver, ExtentTest report) {
		super(_driver, report);

	}

	// Borrower Navigation
	@FindBy(id = "900000")
	private WebElement borrower_tab;

	@FindBy(id = "955190406")
	private WebElement PAM;
	
	@FindBy(name = "personal")
	private WebElement BrwrRegPrsnl_Tab;

	@FindBy(name = "others")
	public WebElement BrwrRegOthers_Tab;

	@FindBy(id = "901000")
	private WebElement Registration;

	@FindBy(id = "902000")
	private WebElement Edit;

	@FindBy(id = "903001")
	private WebElement Collections;

	@FindBy(id = "909900")
	private WebElement Bankrupt_Deceased_Suite;

	@FindBy(id = "940010")
	private WebElement Courtesy_Calls;

	@FindBy(id = "988190443")
	private WebElement Active_Military;

	@FindBy(id = "98819081105")
	private WebElement Upload_Customer_Documents;
	
	@FindBy(xpath="//img[@name='banking']") 
	private WebElement BrwrRegBanking_TAB;

	/*
	 * LoanTransaction
	 */
	@FindBy(id = "910000")
	private WebElement LoanTransactions_Tab;
	/*
	 * New Loan
	 */
	@FindBy(id = "911100")
	private WebElement NewLoan;
	/*
	 * Transactions
	 */ @FindBy(id = "911101")
	private WebElement Transactions;
	/*
	 * Debit Cards
	 */
	@FindBy(id = "988190800")
	private WebElement DebitCards;
	/*
	 * Payday Loan
	 */
	@FindBy(id = "988190836")
	private WebElement DC_PaydayLoan;

	@FindBy(id = "98819081111")
	private WebElement returnPayment;
	/*
	 * Deposit
	 */
	@FindBy(id = "988190839")
	private WebElement DCPD_Deposit;
	/*
	 * ReDeposit/Representment
	 */
	@FindBy(id = "9881908018")
	private WebElement DCPD_ReDeposit_Representment;

	/*
	 * ACH Menu
	 */
	@FindBy(id = "913000")
	private WebElement ACH;
	/*
	 * Payday Loan Menu
	 */
	@FindBy(id = "913010")
	private WebElement ACHPaydayLoan;
	/*
	 * ACH Deposit Menu
	 */
	@FindBy(id = "913011")
	private WebElement ACHPD_ACHDeposit;
	/*
	 * ACH Return Menu
	 */
	@FindBy(id = "913012")
	private WebElement ACHPD_ACHReturn;
	/*
	 * ACH Clear Menu
	 */
	@FindBy(id = "913013")
	private WebElement ACHPD_ACHClear;
	/*
	 * ReDeposit/Representment Menu
	 */
	@FindBy(id = "913014")
	private WebElement ACHPD_ReDeposit_Representment;

	/*
	 * VIN Validation Menu
	 */
	@FindBy(id = "988190677")
	private WebElement VINValidation;
	/*
	 * Vehicle Image Upload Menu
	 */
	@FindBy(id = "98819081107")
	private WebElement VehicleImageUpload;
	/*
	 * Title Loan Menu
	 */
	@FindBy(id = "98819081117")
	private WebElement TitleLoan;
	/*
	 * Title Tracking
	 */
	@FindBy(id = "98819081118")
	private WebElement Title_Tracking;

	/*
	 * MiscTransactions Tab
	 */
	@FindBy(id = "920000")
	private WebElement MiscTransactions_Tab;
	/*
	 * Misc Receipts
	 */
	@FindBy(id = "921000")
	private WebElement Misc_Receipts;
	/*
	 * Miscellaneous Receipts
	 */
	@FindBy(id = "921009")
	private WebElement Miscellaneous_Receipts;
	/*
	 * Misc Disbursement
	 */
	@FindBy(id = "922000")
	private WebElement Misc_Disbursement;
	/*
	 * Other Disbursements
	 */

	@FindBy(id = "922003")
	private WebElement OtherDisbursements;

	/*
	 * CashManagement Tab
	 */
	@FindBy(id = "930000")
	private WebElement CashManagement_Tab;
	/*
	 * Drawer Menu
	 */
	@FindBy(id = "931000")
	private WebElement Drawer;
	/*
	 * Assign SubMenu
	 */
	@FindBy(id = "931010")
	private WebElement DrawerAssign;
	/*
	 * Balance
	 */
	@FindBy(id = "931020")
	private WebElement DrawerBalance;
	/*
	 * Deassign
	 */
	@FindBy(id = "931030")
	private WebElement DrawerDeassign;
	/*
	 * Safe Menu
	 */
	@FindBy(id = "932000")
	private WebElement safe;
	/*
	 * Cash In
	 */
	@FindBy(id = "406")
	private WebElement SafeCashIn;
	/*
	 * Assign
	 */
	@FindBy(id = "932010")
	private WebElement SafeAssign;
	/*
	 * Balance
	 */
	@FindBy(id = "932020")
	private WebElement SafeBalance;
	/*
	 * Deassign
	 */
	@FindBy(id = "932030")
	private WebElement SafeDeassign;
	/*
	 * Internal Transfer
	 */
	@FindBy(id = "932040")
	private WebElement SafeInternalTransfer;
	/*
	 * Deposit
	 */
	@FindBy(id = "932050")
	private WebElement SafeDeposit;
	/*
	 * Store To Store Transfers
	 */
	@FindBy(id = "988190495")
	private WebElement SafeStoreToStoreTransfers;
	/*
	 * Manual Deposit Slip
	 */
	@FindBy(id = "98819081143")
	private WebElement ManualDepositSlip;

	/*
	 * DailyProcessing Tab
	 */ @FindBy(id = "daily")
	private WebElement DailyProcessing_Tab;

	/*
	 * Reports Tab
	 */ @FindBy(id = "950000")
	private WebElement Reports_Tab;

	/*
	 * Collection
	 */ @FindBy(id = "951000")
	private WebElement Collection;
	/*
	 * Past Due Report
	 */ @FindBy(id = "988190720")
	private WebElement PastDueReport;
	/*
	 * Promise To Pay
	 */ @FindBy(id = "988190721")
	private WebElement PromiseToPay;
	/*
	 * Collection Activity
	 */ @FindBy(id = "988190722")
	private WebElement CollectionActivity;
	/*
	 * Courtesy Call Report
	 */ @FindBy(id = "988190724")
	private WebElement CourtesyCallReport;
	/*
	 * Store to Central Collections Report
	 */ @FindBy(id = "988190725")
	private WebElement StoretoCentralCollectionsReport;
	/*
	 * Store Call Report
	 */ @FindBy(id = "988190741")
	private WebElement StoreCallReport;
	/*
	 * Customer Reports
	 */ @FindBy(id = "952000")
	private WebElement CustomerReports;
	/*
	 * Bankruptcy Report
	 */ @FindBy(id = "951010")
	private WebElement BankruptcyReport;
	/*
	 * Inactive Customer
	 */ @FindBy(id = "952010")
	private WebElement InactiveCustomer;
	/*
	 * Active Customer
	 */ @FindBy(id = "952020")
	private WebElement ActiveCustomer;
	/*
	 * Updated Customer Information Report
	 */ @FindBy(id = "988190693")
	private WebElement UpdatedCustomerInformationReport;
	/*
	 * OFAC Response Report
	 */ @FindBy(id = "988190694")
	private WebElement OFACResponseReport;
	/*
	 * Do Not Call Report
	 */ @FindBy(id = "988190695")
	private WebElement DoNotCallReport;
	/*
	 * Bankruptcy Payment Report
	 */ @FindBy(id = "988190712")
	private WebElement BankruptcyPaymentReport;
	/*
	 * Active Military Report
	 */ @FindBy(id = "988190713")
	private WebElement ActiveMilitaryReport;
	/*
	 * Pending Bankruptcy Report
	 */ @FindBy(id = "988190719")
	private WebElement PendingBankruptcyReport;
	/*
	 * Customer Cam Report
	 */ @FindBy(id = "988190726")
	private WebElement CustomerCamReport;
	/*
	 * Customer Information Summary Report(CIS)
	 */ @FindBy(id = "988190774")
	private WebElement CustomerInformationSummaryReportCIS;
	/*
	 * Inactive Bank Account Report
	 */ @FindBy(id = "988190857")
	private WebElement InactiveBankAccountReport;
	/*
	 * Daily Summary Reports
	 */ @FindBy(id = "953000")
	private WebElement DailySummaryReports;
	/*
	 * EOD Summary
	 */ @FindBy(id = "953020")
	private WebElement EODSummary;
	/*
	 * Daily Transaction Journal
	 */ @FindBy(id = "953030")
	private WebElement DailyTransactionJournal;
	/*
	 * Store Cash Management
	 */ @FindBy(id = "953050")
	private WebElement StoreCashManagement;
	/*
	 * Voided Transactions
	 */ @FindBy(id = "953060")
	private WebElement VoidedTransactions;
	/*
	 * Accounts Receivable Aging Report
	 */ @FindBy(id = "988190697")
	private WebElement AccountsReceivableAgingReport;
	/*
	 * Store Cash Management Summary Report
	 */ @FindBy(id = "988190698")
	private WebElement StoreCashManagementSummaryReport;
	/*
	 * All Payments Report
	 */ @FindBy(id = "988190699")
	private WebElement AllPaymentsReport;
	/*
	 * Cash Over/Short Report
	 */ @FindBy(id = "988190700")
	private WebElement CashOverShortReport;
	/*
	 * Cash Balance Transaction Report
	 */ @FindBy(id = "988190701")
	private WebElement CashBalanceTransactionReport;
	/*
	 * Daily Statistics Report
	 */ @FindBy(id = "988190714")
	private WebElement DailyStatisticsReport;
	/*
	 * Drawer Journal Report
	 */ @FindBy(id = "988190770")
	private WebElement DrawerJournalReport;
	/*
	 * Loan Reports
	 */ @FindBy(id = "954000")
	private WebElement LoanReports;
	/*
	 * Default Report
	 */ @FindBy(id = "954070")
	private WebElement DefaultReport;
	/*
	 * PWO Report
	 */ @FindBy(id = "954092")
	private WebElement PWOReport;
	/*
	 * Write Off Loans Report
	 */ @FindBy(id = "954093")
	private WebElement WriteOffLoansReport;
	/*
	 * Returned Items Report
	 */ @FindBy(id = "954095")
	private WebElement ReturnedItemsReport;
	/*
	 * Sold Loan Report
	 */ @FindBy(id = "13700008")
	private WebElement SoldLoanReport;
	/*
	 * Check Register Report
	 */ @FindBy(id = "988190702")
	private WebElement LR_CheckRegisterReport;
	/*
	 * Deposit Report
	 */ @FindBy(id = "988190703")
	private WebElement DepositReport;
	/*
	 * Waive Fee Report
	 */ @FindBy(id = "988190704")
	private WebElement LR_WaiveFeeReport;
	/*
	 * Refund Transaction Report
	 */ @FindBy(id = "988190706")
	private WebElement RefundTransactionReport;
	/*
	 * New Loan Report
	 */ @FindBy(id = "988190708")
	private WebElement report_NewLoan;
	/*
	 * Returned Items Inventory Report
	 */ @FindBy(id = "988190709")
	private WebElement ReturnedItemsInventory;
	/*
	 * Current Loan Inventory Report
	 */ @FindBy(id = "988190710")
	private WebElement CurrentLoanInventoryReport;
	/*
	 * Representment Report
	 */ @FindBy(id = "988190711")
	private WebElement RepresentmentReport;
	/*
	 * Coupon Tracking Report
	 */ @FindBy(id = "988190716")
	private WebElement CouponTrackingReport;
	/*
	 * ACH Details Report
	 */ @FindBy(id = "988190717")
	private WebElement ACHDetailsReport;
	/*
	 * Held Check Summary
	 */ @FindBy(id = "988190718")
	private WebElement HeldCheckSummary;
	/*
	 * Transfer Payments Report
	 */ @FindBy(id = "988190728")
	private WebElement TransferPayments;
	/*
	 * Pending ACH/RCK/Check 21 Report
	 */ @FindBy(id = "9881908038")
	private WebElement PendingACHRCKCheck21Report;
	/*
	 * Other Reports
	 */ @FindBy(id = "955000")
	private WebElement OtherReports;
	/*
	 * Monetary Transfer Log
	 */ @FindBy(id = "955030")
	private WebElement MonetaryTransferLog;
	/*
	 * EncryptionKey Report
	 */ @FindBy(id = "988190775")
	private WebElement EncryptionKeyReport;
	/*
	 * Active Users Report
	 */ @FindBy(id = "988190776")
	private WebElement ActiveUsersReport;
	/*
	 * Misc Disbursements Log Report
	 */ @FindBy(id = "988190777")
	private WebElement MiscDisbursementsLogReport;
	/*
	 * Currency Transaction Report
	 */ @FindBy(id = "988190778")
	private WebElement CurrencyTransactionReport;
	/*
	 * Rescission Report
	 */ @FindBy(id = "988190779")
	private WebElement RescissionReport;
	/*
	 * Debit Card payments Report
	 */ @FindBy(id = "988190780")
	private WebElement DebitCardpaymentsReport;
	/*
	 * Loans With Credit Balance Report
	 */ @FindBy(id = "988190781")
	private WebElement LoansWithCreditBalanceReport;
	/*
	 * NOAT Missing Report
	 */ @FindBy(id = "988190782")
	private WebElement NOATMissingReport;
	/*
	 * Miscellaneous Receipts Report
	 */ @FindBy(id = "988190783")
	private WebElement MiscellaneousReceiptsReport;
	/*
	 * Teller Productivity Report
	 */ @FindBy(id = "988190784")
	private WebElement TellerProductivityReport;
	/*
	 * Large Scale Report
	 */ @FindBy(id = "988190785")
	private WebElement LargeScaleReport;
	/*
	 * Loan Denial Report
	 */ @FindBy(id = "988190786")
	private WebElement LoanDenialReport;
	/*
	 * ACH Collection Inventory Report
	 */ @FindBy(id = "988190802")
	private WebElement ACHCollectionInventoryReport;
	/*
	 * Payment Plan Report
	 */ @FindBy(id = "988190851")
	private WebElement PaymentPlanReport;
	/*
	 * Veritec Report
	 */ @FindBy(id = "9881908013")
	private WebElement VeritecReport;
	/*
	 * Refinance Report
	 */ @FindBy(id = "9881908020")
	private WebElement RefinanceReport;
	/*
	 * Legal Garnishment Report
	 */ @FindBy(id = "9881908027")
	private WebElement LegalGarnishmentReport;
	/*
	 * Currency Transaction Report
	 */ @FindBy(id = "9881908040")
	private WebElement CurrencyTransactionReport2;
	/*
	 * Teller Productivity Report
	 */ @FindBy(id = "9881908042")
	private WebElement TellerProductivityReport2;
	/*
	 * Rescission Report
	 */ @FindBy(id = "9881908043")
	private WebElement RescissionReport2;
	/*
	 * Debit Card payments Report
	 */ @FindBy(id = "9881908044")
	private WebElement DebitCardpaymentsReport2;
	/*
	 * Loans With Credit Balance Report
	 */ @FindBy(id = "9881908045")
	private WebElement LoansWithCreditBalanceReport2;
	/*
	 * NOAT Missing Report
	 */ @FindBy(id = "9881908046")
	private WebElement NOATMissingReport2;
	/*
	 * NetSpend Tab
	 */ @FindBy(id = "960000")
	private WebElement NetSpend_Tab;
	/*
	 * Register And Load Card
	 */ @FindBy(id = "961000")
	private WebElement RegisterAndLoadCard;
	/*
	 * Activate Net Spend
	 */ @FindBy(id = "961001")
	private WebElement ActivateNetSpend;
	// Collection Menu and sub-menu
	@FindBy(id = "951000")
	private WebElement collection;

	@FindBy(id = "988190720")
	private WebElement pastDueReport;

	@FindBy(id = "988190721")
	private WebElement promiseToPay;

	@FindBy(id = "988190722")
	private WebElement collectionActivity;

	@FindBy(id = "988190724")
	private WebElement courtesyCallReport;

	@FindBy(id = "988190725")
	private WebElement storeToCentralCollectionsReport;

	@FindBy(id = "988190741")
	private WebElement storeCallReport;

	
	/* ---------------------------------------------------------------------------
	 * Admin
	 * ------------------------------------------------------------------------------
	 */

	@FindBy(id = "500000")
	private WebElement Admin_Transactions_Tab;
	
	@FindBy(id = "100000")
	private WebElement Admin_StoreSetUp;
	
		@FindBy(id = "101000")
		private WebElement Admin_StoreSetUp_StoreConfig;
		
			@FindBy(id = "101020")
			private WebElement Admin_StoreSetUp_StoreConfig_EditStore;
		
	@FindBy(id = "407")
	private WebElement Transactions_QueueManagement;
	
	@FindBy(id = "988190744")
	private WebElement Transactions_DebitCards;
	@FindBy(id = "501000")
	private WebElement Transactions_CollateralChecks;
	
	@FindBy(id = "502000")
	private WebElement Transactions_Borrower;	
			
		@FindBy(id = "502020")
		private WebElement Transactions_Borrower_HitList;
	
		@FindBy(id = "502030")
		private WebElement Transactions_Borrower_ExitHitList;
	
		@FindBy(id = "502060")
		private WebElement Transactions_Borrower_Transfer;
	
		@FindBy(id = "502070")
		private WebElement Transactions_Borrower_DrawerDeassign;
	
		@FindBy(id = "502080")
		private WebElement Transactions_Borrower_SafeDeassign;
		
		@FindBy(id = "502090")
		private WebElement Transactions_Borrower_ReprintCheck;	
		
		@FindBy(id = "502120")
		private WebElement Transactions_Borrower_EditSSN;
	
		@FindBy(id = "502021")
		private WebElement Transactions_Borrower_FailOverReturns;
		
	
	@FindBy(id = "503000")
	private WebElement Transactions_ACH;	
		
		@FindBy(id = "503010")
		private WebElement Transactions_ACH_PaydayLoan;
	
		@FindBy(id = "503030")
		private WebElement Transactions_ACH_InstallmentLoan;
	
		@FindBy(id = "503100")
		private WebElement Transactions_ACH_RCC;
	
		@FindBy(id = "503200")
		private WebElement Transactions_ACH_RCPO;
	
		@FindBy(id = "503300")
		private WebElement Transactions_ACH_GreenBank;
		
		@FindBy(id = "503400")
		private WebElement Transactions_ACH_RCCPayments;
		
		@FindBy(id = "955190290")
		private WebElement Transactions_ACH_LOC;
			
			@FindBy(id = "98819081100")
			private WebElement Transactions_ACH_LOC_UnsecureLOCStatement;
		
	@FindBy(id = "507000")
	private WebElement Transactions_QAJobs;
			
		@FindBy(id = "502150")
		private WebElement Transactions_QAJobs_ProcessDateChange;
		
		@FindBy(id = "507040")
		private WebElement Transactions_QAJobs_IPDLPreNoteDepositProcess;
				
		@FindBy(id = "507041")
		private WebElement Transactions_QAJobs_TLPPreNoteDepositProcess;
				
		@FindBy(id = "507042")
		private WebElement Transactions_QAJobs_PDLPreNoteDepositProcess;
	
	@FindBy(id = "508000")
	private WebElement Transactions_EODBatchProcess;
	
	@FindBy(id = "9881908084")
	private WebElement Transactions_TitleLoan;
	


		/* ---------------------------------------------------------------------------
		 * Locator Methods
		 * ------------------------------------------------------------------------------
		 */
		
	
	public void navigateToBorrowerTab() {
		selectFrame(frameTop);
		click_BorrowerTab();
	}

	public void click_BorrowerTab() {
		doIT(borrower_tab, "y");
	}

	public void navigateToLoanTransactions_Tab() {
		selectFrame(frameTop);
		click_LoanTransactions_Tab();
	}

	public void click_LoanTransactions_Tab() {
		doIT(LoanTransactions_Tab, "y");
	}

	public void navigateToMiscTransactions_Tab() {
		selectFrame(frameTop);
		click_MiscTransactions_Tab();
	}

	public void click_MiscTransactions_Tab() {
		doIT(MiscTransactions_Tab, "y");
	}

	public void navigateToCashManagement_Tab() {
		selectFrame(frameTop);
		click_CashManagement_Tab();
	}

	public void click_CashManagement_Tab() {
		doIT(CashManagement_Tab, "y");
	}

	public void navigateToDailyProcessing_Tab() {
		selectFrame(frameTop);
		click_DailyProcessing_Tab();
	}

	public void click_DailyProcessing_Tab() {
		doIT(DailyProcessing_Tab, "y");
	}

	public void navigateToReports_Tab() {
		selectFrame(frameTop);
		click_Reports_Tab();
	}

	public void click_Reports_Tab() {
		doIT(Reports_Tab, "y");
	}

	public void navigateToNetSpend_Tab() {
		selectFrame(frameTop);
		click_NetSpend_Tab();
	}

	public void click_NetSpend_Tab() {
		doIT(NetSpend_Tab, "y");
	}

	public void navigateToBorrower_Registration() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Registration();
		selectFrame(frameMain);
	}

	public void click_Registration() {
		doIT(Registration, "y");
	}

	public void navigateToBorrower_Edit() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Edit();
		selectFrame(frameMain);
	}

	public void click_Edit() {
		doIT(Edit, "y");
	}

	public void click_BBrwrRegPrsnl_Tab() {
		doIT(BrwrRegPrsnl_Tab, "y");
	}

	public void click_BrwrRegOthers_Tab() {
		doIT(BrwrRegOthers_Tab, "y");
	}
	
	public void click_BrwrRegBanking_TAB() {
		doIT(BrwrRegBanking_TAB, "y");
	}

	public void navigateToBorrower_Collections() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Collections();
		selectFrame(frameMain);
	}

	public void click_Collections() {
		doIT(Collections, "y");
	}

	public void navigateToBorrower_BankruptDeceasedSuite() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Bankrupt_Deceased_Suite();
		selectFrame(frameMain);
	}

	public void click_Bankrupt_Deceased_Suite() {
		doIT(Bankrupt_Deceased_Suite, "y");
	}

	public void navigateToBorrower_CourtesyCalls() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Courtesy_Calls();
		selectFrame(frameMain);
	}

	public void click_Courtesy_Calls() {
		doIT(Courtesy_Calls, "y");
	}

	public void navigateToBorrower_ActiveMilitary() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Active_Military();
		selectFrame(frameMain);
	}

	public void click_Active_Military() {
		doIT(Active_Military, "y");
	}

	public void navigateToBorrower_UploadCustomerDocuments() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_Upload_Customer_Documents();
		selectFrame(frameMain);
	}

	public void click_Upload_Customer_Documents() {
		doIT(Upload_Customer_Documents, "y");
	}

	public void LoanTransaction_Options(WebElement element1, WebElement element2) {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		new Actions(driver).moveToElement(element1).click().build().perform();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element2));
		new Actions(driver).moveToElement(element2).click().build().perform();
		selectFrame(frameMain);
	}

	public void navigateToLoanTransaction_NewLoan() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_NewLoan();
		selectFrame(frameMain);
	}

	public void click_NewLoan() {
		doIT(NewLoan, "y");
	}

	public void navigateToLoanTransaction_Transactions() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_Transactions();
		selectFrame(frameMain);
	}

	public void click_Transactions() {
		doIT(Transactions, "y");
	}

	public void navigateToLoanTransaction_DebitCards_PaydayLoan_Deposit() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_DebitCards();
		wait.until(ExpectedConditions.visibilityOf(DC_PaydayLoan));
		click_DC_PaydayLoan();
		wait.until(ExpectedConditions.visibilityOf(DCPD_Deposit));
		click_DCPD_Deposit();
		selectFrame(frameMain);
	}

	public void click_DebitCards() {
		doIT(DebitCards, "y");
	}

	public void click_DC_PaydayLoan() {
		doIT(DC_PaydayLoan, "y");
	}

	public void click_DCPD_Deposit() {
		doIT(DCPD_Deposit, "y");
	}

	public void navigateToLoanTransaction_DebitCards_PaydayLoan_ReDeposit() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_DebitCards();
		wait.until(ExpectedConditions.visibilityOf(DC_PaydayLoan));
		click_DC_PaydayLoan();
		wait.until(ExpectedConditions.visibilityOf(DCPD_ReDeposit_Representment));
		click_DCPD_ReDeposit_Representment();
		selectFrame(frameMain);
	}

	public void click_DCPD_ReDeposit_Representment() {
		doIT(DCPD_ReDeposit_Representment, "y");
	}

	public void navigateToLoanTransaction_ACH_PaydayLoan_ACHDeposit() {

		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_ACH();
		wait.until(ExpectedConditions.visibilityOf(ACHPaydayLoan));
		click_ACHPaydayLoan();
		wait.until(ExpectedConditions.visibilityOf(ACHPD_ACHDeposit));
		click_ACHPD_ACHDeposit();
		selectFrame(frameMain);
	}

	public void click_ACH() {
		doIT(ACH, "y");
	}

	public void click_ACHPaydayLoan() {
		doIT(ACHPaydayLoan, "y");
	}

	public void click_ACHPD_ACHDeposit() {
		doIT(ACHPD_ACHDeposit, "y");
	}

	public void navigateToLoanTransaction_ACH_PaydayLoan_ACHReturn() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_ACH();
		wait.until(ExpectedConditions.visibilityOf(ACHPaydayLoan));
		click_ACHPaydayLoan();
		wait.until(ExpectedConditions.visibilityOf(ACHPD_ACHReturn));
		click_ACHPD_ACHReturn();
		selectFrame(frameMain);
	}
	public void click_ACHPD_ACHReturn() {
		doIT(ACHPD_ACHReturn, "y");
	}

	public void navigateToLoanTransaction_ACH_PaydayLoan_ACHRedeposit() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_ACH();
		wait.until(ExpectedConditions.visibilityOf(ACHPaydayLoan));
		click_ACHPaydayLoan();
		wait.until(ExpectedConditions.visibilityOf(ACHPD_ReDeposit_Representment));
		click_ACHPD_ReDeposit_Representment();
		selectFrame(frameMain);
	}
	public void click_ACHPD_ReDeposit_Representment() {
		doIT(ACHPD_ReDeposit_Representment, "y");
	}

	public void navigateToLoanTransaction_ACH_PaydayLoan_ACHClear() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_ACH();
		wait.until(ExpectedConditions.visibilityOf(ACHPaydayLoan));
		click_ACHPaydayLoan();
		wait.until(ExpectedConditions.visibilityOf(ACHPD_ACHClear));
		click_ACHPD_ACHClear();
		selectFrame(frameMain);
	}
	public void click_ACHPD_ACHClear() {
		doIT(ACHPD_ACHClear, "y");
	}

	public void navigateToLoanTransaction_VINValidation() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_VINValidation();
		selectFrame(frameMain);
	}
	public void click_VINValidation() {
		doIT(VINValidation, "y");
	}

	public void navigateToLoanTransaction_VehicleImageUpload() {
		navigateToLoanTransactions_Tab();
		selectFrame(frameMiddle);
		click_VehicleImageUpload();
		selectFrame(frameMain);
	}
	public void click_VehicleImageUpload() {
		doIT(VehicleImageUpload, "y");
	}
	public void navigateToLoanTransaction_TitleLoan_TitleTracking() {
		LoanTransaction_Options(TitleLoan, Title_Tracking);
	}

	public void navigateToMiscTransactions_MiscReceipts_MiscellaneousReceipts() {
		navigateToMiscTransactions_Tab();
		selectFrame(frameMiddle);
		click_Misc_Receipts();
		wait.until(ExpectedConditions.visibilityOf(Miscellaneous_Receipts));
		click_Miscellaneous_Receipts();
		selectFrame(frameMain);
	}
	public void click_Misc_Receipts() {
		doIT(Misc_Receipts, "y");
	}
	public void click_Miscellaneous_Receipts() {
		doIT(Miscellaneous_Receipts, "y");
	}

	public void navigateToMiscTransactions_MiscDisbursement_OtherDisbursements() {
		navigateToMiscTransactions_Tab();
		selectFrame(frameMiddle);
		 click_Misc_Disbursement();
		wait.until(ExpectedConditions.visibilityOf(OtherDisbursements));
		click_OtherDisbursements();
		selectFrame(frameMain);
	}
	public void click_Misc_Disbursement() {
		doIT(Misc_Disbursement, "y");
	}
	public void click_OtherDisbursements() {
		doIT(OtherDisbursements, "y");
	}
	public void CashManagement_Options(WebElement element1, WebElement element2) {
		navigateToCashManagement_Tab();
		selectFrame(frameMiddle);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element1));
		new Actions(driver).moveToElement(element1).click().build().perform();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element2));
		new Actions(driver).moveToElement(element2).click().build().perform();
		selectFrame(frameMain);
	}

	public void navigateToCashManagement_Drawer_DrawerAssign() throws Exception {
		CashManagement_Options(Drawer, DrawerAssign);
	}

	public void navigateToCashManagement_Drawer_DrawerBalance() {
		CashManagement_Options(Drawer, DrawerBalance);
	}

	public void navigateToCashManagement_Drawer_DrawerDeassign() {
		CashManagement_Options(Drawer, DrawerDeassign);
	}

	public void navigateToCashManagement_Safe_SafeCashIn() {
		CashManagement_Options(safe, SafeCashIn);
	}

	public void navigateToCashManagement_Safe_SafeAssign() {
		CashManagement_Options(safe, SafeAssign);
	}

	public void navigateToCashManagement_Safe_SafeBalance() {
		CashManagement_Options(safe, SafeBalance);
	}

	public void navigateToCashManagement_Safe_SafeDeassign() {
		CashManagement_Options(safe, SafeDeassign);
	}

	public void navigateToCashManagement_Safe_SafeInternalTransfer() {
		CashManagement_Options(safe, SafeInternalTransfer);

	}

	public void navigateToCashManagement_Safe_SafeDeposit() {
		CashManagement_Options(safe, SafeDeposit);
	}

	public void navigateToCashManagement_Safe_SafeStoreToStoreTransfers() {
		CashManagement_Options(safe, SafeStoreToStoreTransfers);
	}

	public void navigateToCashManagement_Safe_ManualDepositSlip() {
		CashManagement_Options(safe, ManualDepositSlip);
	}

	public void navigateToBorrower_PAM() {
		navigateToBorrowerTab();
		selectFrame(frameMiddle);
		click_PAM();
		selectFrame(frameMain);
	}
	
	public void click_PAM() {
		wait.until(ExpectedConditions.visibilityOf(PAM));
		doIT(PAM, "y");
	}
	
	

/* ---------------------------------------------------------------------------
 * Locator Methods - Admin
 * ------------------------------------------------------------------------------
 */


	public void navigateTo_AdminTab(WebElement TabElement)  {
		selectFrame(frameTop);

		doIT(TabElement,"Click");
	}
	
	public void navigateTo_AdminMenu(WebElement MenuElement)  {
		//selectFrame(frameMiddle);
		
		//new Actions(driver).moveToElement(MenuElement).perform();
		doIT(MenuElement,"Click");
		
	}
	
	public void navigateTo_AdminSubMenu(WebElement SubMenuElement)  {
		//new Actions(driver).moveToElement(SubMenuElement).build().perform();
		//doIT(SubMenuElement,"Click");
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(SubMenuElement));
		new Actions(driver).moveToElement(SubMenuElement).click().build().perform();
	}
	
	public void navigateTo_AdminSubMenu_Options(WebElement SubMenuSubElement)  {
		//new Actions(driver).moveToElement(SubMenuElement).build().perform();
		//doIT(SubMenuElement,"Click");
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(SubMenuSubElement));
		new Actions(driver).moveToElement(SubMenuSubElement).click().build().perform();
	}
	
	
	public void navigateTo_Admin_Tab_Menu(WebElement TabElement, WebElement MenuElement)  {
		
		navigateTo_AdminTab(TabElement);
		selectFrame(frameMiddle);
		navigateTo_AdminMenu(MenuElement); 
		selectFrame(frameMain);
	 
	}
	
	public void navigateTo_Admin_Tab_Menu_SubMenu(WebElement TabElement, WebElement MenuElement, WebElement SubMenuElement)  {
		
		navigateTo_AdminTab(TabElement);
		selectFrame(frameMiddle);
		navigateTo_AdminMenu(MenuElement); 
		navigateTo_AdminSubMenu(SubMenuElement); 
		selectFrame(frameMain);

	}
	
public void navigateTo_Admin_Tab_Menu_SubMenu_Options(WebElement TabElement, WebElement MenuElement, WebElement SubMenuElement, WebElement SubMenuSubElement)  {
		
		navigateTo_AdminTab(TabElement);
		selectFrame(frameMiddle);
		navigateTo_AdminMenu(MenuElement); 
		navigateTo_AdminSubMenu(SubMenuElement);
		navigateTo_AdminSubMenu_Options(SubMenuSubElement);
		selectFrame(frameMain);

	}
	
	
	public void navigateTo_Admin_Transactions_Tab(){
		selectFrame(frameTop);
		doIT(Admin_Transactions_Tab,"Click");
	}
		
	public void Admin_Transactions_Options(WebElement element1, WebElement element2) {
		navigateTo_Admin_Transactions_Tab();
		selectFrame(frameMiddle);
		new Actions(driver).moveToElement(element1).click().build().perform();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element2));
		new Actions(driver).moveToElement(element2).click().build().perform();
		selectFrame(frameMain);
	}
	public void navigateTo_Admin_Transactions_ACH_LOC_UnsecureStatement() {
		navigateTo_Admin_Tab_Menu_SubMenu_Options(Admin_Transactions_Tab, Transactions_ACH, Transactions_ACH_LOC, Transactions_ACH_LOC_UnsecureLOCStatement );

	}
	
	public void navigateTo_Admin_StoreSetUp_StoreConfig_EditStore()  {
		//Admin_Transactions_Options	(Transactions_QAJobs, Transactions_QAJobs_ProcessDateChange);
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_StoreSetUp, Transactions_QAJobs, Transactions_QAJobs_ProcessDateChange);
	}
	
	
	public void navigateTo_Admin_Transactions_QAJobs_ProcessDateChange()  {
		//Admin_Transactions_Options	(Transactions_QAJobs, Transactions_QAJobs_ProcessDateChange);
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Admin_StoreSetUp_StoreConfig, Admin_StoreSetUp_StoreConfig_EditStore);
	}

	public void navigateTo_Admin_Transactions_EODBatchProcess()  {		
		navigateTo_Admin_Tab_Menu(Admin_Transactions_Tab, Transactions_EODBatchProcess);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_HitList()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_HitList);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_ExitHitList()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_ExitHitList);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_DrawerDeassign()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_DrawerDeassign);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_SafeDeassign()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_SafeDeassign);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_ReprintCheck()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_ReprintCheck);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_EditSSN()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_EditSSN);
	}
	
	public void navigateTo_Admin_Transactions_Borrower_FailOverReturns()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_Borrower, Transactions_Borrower_FailOverReturns);
	}
	
	public void navigateTo_Admin_Transactions_ACH_PaydayLoan()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_ACH, Transactions_ACH_PaydayLoan);
	}

	public void navigateTo_Admin_Transactions_ACH_InstallmentLoan()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_ACH, Transactions_ACH_InstallmentLoan);
	}
		
	public void navigateTo_Admin_Transactions_ACH_RCC()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_ACH, Transactions_ACH_RCC);
	}					
			
	public void navigateTo_Admin_Transactions_ACH_RCPO()  {
		navigateTo_Admin_Tab_Menu_SubMenu(Admin_Transactions_Tab, Transactions_ACH, Transactions_ACH_RCPO);
	}					
			

		
}
