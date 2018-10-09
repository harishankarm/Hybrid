package modules.PAM;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import framework.Helper;
import pageClasses.PAM.PAM_AppalicationSearch_PO;
import pageClasses.PAM.PAM_NewLoan_PO;
import pageClasses.PAM.PAM_SearchResult_PO;
import pageClasses.PAM.PAM_VerificationAction_PO;
import pageClasses.PAM.Qfund_Navigation_PO;



public class LoanOrigination_PR extends Helper{


	public LoanOrigination_PR(WebDriver _driver, LinkedHashMap<String, String> data, ExtentTest report) {
		super(_driver,data,report);
	}

	public void searchOnlineLoanbyPAM() throws Exception{
		
		Qfund_Navigation_PO objQfund_Navigation_PO=new Qfund_Navigation_PO(driver,report);	
		objQfund_Navigation_PO.navigateToBorrower_PAM();
		PAM_AppalicationSearch_PO objAppalicationSearch_PO= new PAM_AppalicationSearch_PO(driver, report);
		assertAreEqual("Appaliicant search Loaded successfully",report,objAppalicationSearch_PO.verifyAppalicantSearch(),true);				
		objAppalicationSearch_PO.set_applicationStatus(data("applicationStatus"));
		objAppalicationSearch_PO.set_firstName(data("firstName"));
		objAppalicationSearch_PO.set_lastName(data("lastName"));
		objAppalicationSearch_PO.set_SSN(data("SSN"));
		objAppalicationSearch_PO.set_DOB(data("DOB"));
		objAppalicationSearch_PO.set_customerNbr(data("customerNbr"));
		objAppalicationSearch_PO.set_phoneType(data("phoneType"));
		objAppalicationSearch_PO.set_phoneNum(data("phoneNumber"));
		objAppalicationSearch_PO.set_ApplicationDate(data("applicationDateFrom"),data("applicationDateTo"));
		objAppalicationSearch_PO.click_submit_Button(data("submit"));
		assertAreEqual("No record found on searched criteria",report,objAppalicationSearch_PO.getNoRecordError(),false);
		
		PAM_SearchResult_PO objSearchResult_PO = new PAM_SearchResult_PO(driver,report);
		assertAreEqual("Search Result Loaded successfully",report,objSearchResult_PO.verifySearchResults(),true);
		validateTableData(objSearchResult_PO,"Source","Online");
		validateTableData(objSearchResult_PO,"Name",data("firstName"));
		validateTableData(objSearchResult_PO,"Name",data("lastName"));
		validateTableData(objSearchResult_PO,"CustNbr",data("customerNbr"));
		validateTableData(objSearchResult_PO,"DOB",data("DOB").replace("-", "/"));
		validateTableData(objSearchResult_PO,"SSN / ITIN",objSearchResult_PO.getSSNnumber(data("SSN")));
		objSearchResult_PO.click_GoButton("Y");
			
	}
	

	public void verificationActionPAM() throws Exception{
		
		PAM_VerificationAction_PO objVerificationAction_PO = new PAM_VerificationAction_PO(driver,report);
		
		objVerificationAction_PO.click_OtherReceived(data("otherReceived"));
		objVerificationAction_PO.click_OtherVerified(data("otherVerified"));
		objVerificationAction_PO.click_pofReceived(data("pofReceived"));
		objVerificationAction_PO.click_pofVerified(data("pofVerified"));
		objVerificationAction_PO.click_bpocReceived(data("bpocReceived"));
		objVerificationAction_PO.click_bpocVerified(data("bpocVerified"));
		objVerificationAction_PO.click_primaryPhoneVerified(data("primaryPhoneVerified"));
		if(data("applicationStatus").contains("Approve"))
		assertAreEqual("Validate Need E-Signature dorp down",report,objVerificationAction_PO.getApprovedAmount(),"Need E-Signature");	
		objVerificationAction_PO.set_verificationActionId(data("applicationStatus"));
		if(data("applicationStatus").equals("Denied"))
		objVerificationAction_PO.set_denialReason(data("denialReason"));
		objVerificationAction_PO.click_Submit_Button(data("Submit_Button"));
		if(data("applicationStatus").equals("Hold")){
			assertAreContain("Loan Hold validation",report,objVerificationAction_PO.get_infoMessage("Y"),"Hold");}
		else if(data("applicationStatus").equals("Need Info/Docs")){
			assertAreContain("Loan Needs More Documents validation",report,objVerificationAction_PO.get_infoMessage("Y"),"Needs More Documents");}
		else if(data("applicationStatus").equals("Denied")){
			assertAreContain("Loan Denied validation",report,objVerificationAction_PO.get_infoMessage("Y"),"Denied Successfully");}
		
	}
	
	public void loanOriginationPAM() throws Exception
	{
		PAM_NewLoan_PO objPAM_NewLoan_PO = new PAM_NewLoan_PO(driver,report);
		objPAM_NewLoan_PO.getLoantypee(data("electronicDoc"));
		objPAM_NewLoan_PO.click_FinishLoan_Button(data("finishLoan_btn"));
		objPAM_NewLoan_PO.click_Yes_Button(data("loanOriginationYes"));
		//objPAM_NewLoan_PO.click_No_Button(data("loanOriginationYes"));
		objPAM_NewLoan_PO.click_Ok_Button(data("loanOriginationYes"));
	}

	public void validateTableData(PAM_SearchResult_PO objSearchResult_PO,String tableColName, String expect) throws Exception
	{
		if (!expect.isEmpty()) {
			List<String> data = objSearchResult_PO.getTableColumn(tableColName);
			for (String actual : data) {
				assertAreContain("Search result table "+tableColName+" column match ",report,actual,expect);
			}
		}
	}

	
}