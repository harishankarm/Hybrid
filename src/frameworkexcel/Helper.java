package frameworkexcel;
	
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Helper{

	DataFormatter formatter = new DataFormatter();
	Workbook workbook=null;	
	LinkedList<String> alLogs;
	
	protected LinkedHashMap<String, String> allData;
	protected WebDriver driver;
	protected ExtentTest report;	
	protected String testName;
	protected String processName;
	protected String currentRow;
	
	public Helper(){}

	protected Helper(WebDriver _driver,LinkedHashMap<String, String> data,ExtentTest _report){
		driver=_driver;
		report=_report;	
		allData=data;
		testName=data.get("testName");
		processName=data.get("processName");
		currentRow=data.get("currentRow");	
	}
	
	
	public String data(String key) throws FrameworkException {		

		String Val=null;

		if(key.contains("Config_")) {
			Val=allData.get(key);
		}else if(key.contains("onlineTestData_")){//HARI
			Val=allData.get(key);
		}else {Val=allData.get(processName+"."+key.toString());}
		if(Val==null)
		{
			report.log(LogStatus.FAIL,"Data issue- Column["+key+"] not found in the data sheet["+processName+"]");
			throw new FrameworkException("Data issue- Column["+key+"] not found in the data sheet["+processName+"]");
		}else {
			return Val;
		}
	}
	
	public void assertAreEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception{
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println("Assertion:"+LogStatus.PASS+":"+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {	
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				System.out.println("Assertion:"+LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				throw new FrameworkException("Assertion Failed: "+msg+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");				
			}
		}

	}

	public void assertAreNotEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception   {			
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {	
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				System.out.println("Assertion:"+LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				throw new FrameworkException("Assertion Failed: "+msg+"Expected["+oExpected.toString()+"] "+"Actual["+oExpected.toString()+"]");
			}else {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println("Assertion:"+LogStatus.PASS+":"+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}				
		}
	}

	public void verifyAreEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception {		
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println("Verification:"+LogStatus.PASS+":"+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.FAIL,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println("Verification:"+LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}	
		}
	}

	public void verifyAreNotEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception {			
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.FAIL,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println("Verification:"+LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println("Verification:"+LogStatus.PASS+":"+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}	
		}
	}
	//Hari
	public void assertListAreContain(String msg,ExtentTest report,List<String> data, String expect) throws Exception
	{
		if (!expect.isEmpty()) {
			for (String actual : data) {
				if (actual.contains(expect)) {
					report.log(LogStatus.PASS, msg + ": " + "Expected[" + expect + "] " + "Actual[" + actual + "]");
					report.log(LogStatus.PASS,
							report.addScreenCapture(getscreenshot(driver, data("Config_Report_Path"))));
					System.out.println("Assertion:" + LogStatus.PASS + ":" + msg + ": " + "Expected[" + expect + "] "
							+ "Actual[" + actual + "]");
				} else {
					report.log(LogStatus.FAIL, msg + ": " + "Expected[" + expect + "] " + "Actual[" + actual + "]");
					System.out.println("Assertion:" + LogStatus.FAIL + msg + ": " + "Expected[" + expect + "] "
							+ "Actual[" + actual + "]");
					throw new FrameworkException(
							"Assertion Failed: " + msg + "Expected[" + expect + "] " + "Actual[" + actual + "]");
				}
			}
		}

	}
	//Hari
	public void assertFalse(boolean flag, String msg) throws Exception {
		if(flag){
			report.log(LogStatus.FAIL, msg);
			System.out.println("Assertion Failed: " + LogStatus.PASS + ":" + msg);
			throw new FrameworkException("Assert Failed: " + msg);
		}else{
			report.log(LogStatus.PASS, msg);
			System.out.println("Info:" + LogStatus.PASS + ": Search results are loaded");
			
		}
	}

	public void openWorkbook() {
		try {
			workbook = WorkbookFactory.create(Driver.testDataFileLocation_Destination);			
			alLogs=new LinkedList<String>();						
		}catch(Exception e) {
			e.printStackTrace();
			addlogs("Error: Framework excel file not loaded into framework :"+ Driver.testDataFileLocation_Destination);
		}
	}

	public void closeWorkbook() { 
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public void addlogs(String log) {
		alLogs.add(log);
		System.out.println(log);
	}

	public LinkedList<String> getlogs() {
		return alLogs;
	}

	// =================================================
	public WebDriver GetDriver(String browser, String app) throws Exception{
		WebDriver driver = null;
		String pathToDriverExe;
		try {  
			if(app.equals("PAM")){//HARI
				File Source=new File("D:\\00Selenium_Drivers\\"+browser+".exe");
				 pathToDriverExe=Source.getAbsolutePath();
			}else{
			File Source=new File("\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\Selenium_Drivers\\"+browser+".exe");
			 pathToDriverExe=Source.getAbsolutePath();}
			switch(browser) {

			case "Firefox":		

				System.setProperty("webdriver.gecko.driver", "C:\\Users\\mibrahim\\AppData\\Local\\Temp\\IE.exe");				

				FirefoxOptions fireFoxOptions = new FirefoxOptions().setProfile(new FirefoxProfile());
				//fireFoxOptions.setBinary(configData.get("FirefoxBinary"));
				driver = new FirefoxDriver(fireFoxOptions);

				break;

			case "Chrome":
				System.setProperty("webdriver.chrome.driver", pathToDriverExe);

				ChromeOptions chromeOptions = new ChromeOptions();

				//chromeOptions.setCapability("chrome.binary", configData.get("ChromeBinary").toString());
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("disable-extensions");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);


				driver = new ChromeDriver(chromeOptions);

				break;

			case "IE":
				System.setProperty("webdriver.ie.driver", pathToDriverExe);

				InternetExplorerOptions IEoptions = new InternetExplorerOptions();
				IEoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				//IEoptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);

				driver = new InternetExplorerDriver(IEoptions);

				break;

			case "EDGE":
				System.setProperty("webdriver.edge.driver",  pathToDriverExe);

				EdgeOptions Edgeoptions = new EdgeOptions();
				driver = new EdgeDriver(Edgeoptions);

				break;

			case "MOBILE":

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("openDeviceTimeout", 1);


				break;

			default:
				break;

			}
			addlogs(LogStatus.INFO+": "+ browser+" driver instnace successfully created");
		}catch(Exception e) {			
			addlogs("Error: "+ browser+" driver instnace was not created successfully ");
			throw e;
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	// =================================================

	public LinkedHashMap<String,List<String>> getTests(String testCaseType) throws Exception {

		LinkedHashMap<String, List<String>> Tests=new LinkedHashMap<String, List<String>>();
		List<String> TestFlow;


		Sheet sheet = workbook.getSheet("TestCases");
		addlogs(LogStatus.INFO+ ": TestCases sheet successfully loaded");

		if(testCaseType.equals("BATCH")) {
			for (Row row : sheet) {
				if (formatter.formatCellValue(row.getCell(2)).trim().equals("Y")) {
					TestFlow=new ArrayList<String>();
					for (int cn=0; cn<row.getLastCellNum()-4; cn++) {
						String temp=row.getCell(cn+4).getStringCellValue().trim();
						if(!temp.isEmpty()) {
							TestFlow.add(row.getCell(cn+4).getStringCellValue().trim());
						}							
					}    
					Tests.put(row.getCell(1).getStringCellValue().trim(), TestFlow);				
				}
			}
			if(Tests.isEmpty()) {				
				throw new FrameworkException("Error: Non of the test cases are selected for execution, verify the Run column marked 'Y' for any test case in TestCases Sheet");
			}else {
				addlogs(LogStatus.INFO+ ": All testcases marked  Y taken for the execution with process details");
			}
		}else {
			int rowNo=getRowNumber(sheet,1,testCaseType);	
			if(rowNo!=0) {
				Row row=sheet.getRow(getRowNumber(sheet,1,testCaseType));
				TestFlow=new ArrayList<String>();
				for (int cn=0; cn<row.getLastCellNum()-4; cn++) {
					String temp=row.getCell(cn+4).getStringCellValue().trim();
					if(!temp.isEmpty()) {
						TestFlow.add(row.getCell(cn+4).getStringCellValue().trim());
					}
				}
				Tests.put(testCaseType, TestFlow);
				addlogs(LogStatus.INFO+": "+testCaseType+" testCase taken for the execution with process details "+TestFlow);
			}else {				
				throw new FrameworkException("Error: ["+testCaseType+"] testCase not found");				
			}	
		}
		return Tests;
	}

	public String getClassNameForProcess(String prcoess) throws Exception {
		String Module=null;
		Sheet sheet = workbook.getSheet("ProcessDetails");
		int rowNo=getRowNumber(sheet,1,prcoess);
		if(rowNo!=0) {
			Row row=sheet.getRow(getRowNumber(sheet,1,prcoess));
			Module=formatter.formatCellValue(row.getCell(3)).trim();
		}else {
			throw new FrameworkException(LogStatus.FAIL+": Process["+prcoess+"] not found in the ProcessDetails sheet");
		}
		return Module;
	}

	public int getRowNumber(Sheet sheet,int columnNo,String findValue) throws Exception {
		int rowNo=0;
		for (Row row : sheet) {
			Cell cell= row.getCell(columnNo);
			if (cell!=null && cell.getRichStringCellValue().getString().trim().equals(findValue)) {
				rowNo=row.getRowNum();
				break;
			}
		}
		return rowNo;
	}

	public int getColumnNumber(Sheet sheet,String colName) throws FrameworkException {	
		int colNo=0;
		Row colRow=sheet.getRow(0);	
		for (int cn=2; cn<colRow.getLastCellNum(); cn++) {
			String _colName = formatter.formatCellValue(colRow.getCell(cn)).trim();
			if(colName.equals(_colName)) {colNo=cn;break;}
		}  

		if(colNo==0) {
			throw new FrameworkException(colName+" Cloumn is not found in the sheet: "+sheet.getSheetName().toString());
		}
		return colNo;
	}

	public void updateDataSheet(String processName,String rowNo,String colName,String valueToUpdate) throws Exception{
		try {
			FileInputStream fis=new FileInputStream(Driver.testDataFileLocation_Destination);
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(processName);
			Cell cell2Update = sheet.getRow(Integer.parseInt(rowNo)).getCell(getColumnNumber(sheet,colName),MissingCellPolicy.CREATE_NULL_AS_BLANK);
			cell2Update.setCellValue(valueToUpdate);

			FileOutputStream outputStream = new FileOutputStream(Driver.testDataFileLocation_Destination);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LinkedHashMap<String, List<Integer>> getdataIterationInfo(List<String> processes,String testName) throws Exception{

		LinkedHashMap<String, List<Integer>> dataIterationInfo=new LinkedHashMap<String, List<Integer>>();
		DataFormatter formatter = new DataFormatter();

		String processName="";
		try {
			for(String process:processes) {		
				processName=process;
				Sheet sheet = workbook.getSheet(processName);
				List<Integer> Iteration=new ArrayList<Integer>();			
				boolean bFound=false;			
				for (Row row : sheet) {				
					String test = formatter.formatCellValue(row.getCell(0)).trim();
					String flag = formatter.formatCellValue(row.getCell(1)).trim();
					if (test.equals(testName) && flag.equals("Y")) {
						Iteration.add(row.getRowNum());
						bFound=true;					
					}else {
						if(bFound) {break;}
					}  
				}
				if(!bFound) {Iteration.add(0);}
				dataIterationInfo.put(process, Iteration);
			}

		}catch(Exception e) {			
			throw new FrameworkException("Verify the data pre request in the process: "+processName+" for the testcase "+testName);
		}			

		return dataIterationInfo;
	}

	public LinkedHashMap<String, String> configData(String env) throws Exception{
		LinkedHashMap<String, String> configData=new LinkedHashMap<String, String>();

		Sheet sheet = workbook.getSheet("Config");
		addlogs(LogStatus.INFO+ ": Config sheet successfully loaded");

		Row colRow=sheet.getRow(0);	
		int rowNo=getRowNumber(sheet,0,env.toUpperCase());
		if(rowNo!=0) {
			Row valRow=sheet.getRow(rowNo);
			for (int cn=1; cn<colRow.getLastCellNum(); cn++) {
				String key = formatter.formatCellValue(colRow.getCell(cn)).trim();
				String value = formatter.formatCellValue(valRow.getCell(cn)).trim();
				if(value!=null) {
					configData.put("Config_"+key, value);
				}  
			}			
		}else {			
			throw new FrameworkException("Error: ["+env+"] row is not found in the config sheet");
		}

		//Hari
				Sheet sheetOnline = workbook.getSheet("onlineTestData");
				addlogs(LogStatus.INFO+ ": online Test Data sheet successfully loaded");
				try{
					Row colRow1=sheetOnline.getRow(0);	
				for (Row row : sheetOnline) {				
					String loanStatus = formatter.formatCellValue(row.getCell(0)).trim();
					if (loanStatus.equals("New")) {
						for (int cn=1; cn<colRow1.getLastCellNum(); cn++) {
							String key = formatter.formatCellValue(colRow1.getCell(cn)).trim();
							String value = formatter.formatCellValue(row.getCell(cn)).trim();
							if(value!=null) {
								configData.put("onlineTestData_"+key, value);
							}  
						}	
						break;
					}
					
				}
				}catch(Exception e) {		
					throw new FrameworkException("Error: [ LoanStatus New ] row is not found in the onlineTestData sheet");
				}
				System.out.println(configData);
				return configData;
	}


	public LinkedHashMap<String, String> getData(String process,String testName,int iterationCount,LinkedHashMap<String, List<Integer>> dataIterationInfo,LinkedHashMap<String, String> configData) throws Exception{

		LinkedHashMap<String, String> data=new LinkedHashMap<String, String>();
		DataFormatter formatter = new DataFormatter();

		Sheet sheet = workbook.getSheet(process);
		Row colRow=sheet.getRow(0);	
		if(dataIterationInfo.get(process).get(iterationCount)==0) {		
			addlogs(LogStatus.FAIL+": "+"No data found for the test case["+testName+"] in the data sheet["+sheet.getSheetName()+"] OR verify the Run column marked 'Y' for the test["+testName+"] in the data sheet["+sheet.getSheetName()+"]");
			throw new FrameworkException("No data found for the test case["+testName+"] in the data sheet["+sheet.getSheetName()+"] OR verify the Run column marked 'Y' for the test["+testName+"]");
		}
		Row valRow=sheet.getRow(dataIterationInfo.get(process).get(iterationCount));
		data.put("testName",testName);
		data.put("processName",process);
		data.put("currentRow",String.valueOf(valRow.getRowNum()));
		for (int cn=2; cn<colRow.getLastCellNum(); cn++) {
			String key = formatter.formatCellValue(colRow.getCell(cn)).trim();
			String value = formatter.formatCellValue(valRow.getCell(cn)).trim();
			if(value!=null) {
				if(value.contains("CDF(")) {	
					String temp[]=(value.replace("CDF(", "").replace(")", "")).split("\\.");
					if(value.contains("CDF(Config.")) {
						value=configData.get("Config_"+temp[1].trim());
					}else if(value.contains("CDF(onlineTestData.")){ //HARI
						value=configData.get("onlineTestData_"+temp[1].trim());
					}else {
						Sheet tempSheet = workbook.getSheet(temp[0].trim());
						Row tempRow=tempSheet.getRow(dataIterationInfo.get(temp[0]).get(iterationCount));	
						value = formatter.formatCellValue(tempRow.getCell(getColumnNumber(tempSheet,temp[1].trim()))).trim();
					}
				}
				data.put(process+"."+key, value);
			}  
		}

		return data;
	}

	public String getscreenshot(WebDriver driver,String reportPath) throws IOException, HeadlessException, AWTException  { 
		String sharePath=null;


		if(InetAddress.getLocalHost().getCanonicalHostName().toLowerCase().contains("hexaware")) {
			sharePath=System.getProperty("java.io.tmpdir");			
		}else {sharePath="\\\\aacss\\cssfiles";}	

		String filepath=reportPath.replace("\\\\aacss\\cssfiles", sharePath)+"\\"+getDateAndTimeNow()+".png";

		try 
		{
			driver.getTitle();    
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filepath));
		} 
		catch (UnhandledAlertException e)  
		{ 
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(filepath));
		}
		return filepath;
	}



	public String getDateAndTimeNow() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now).replace("/","_").replace(" ","_").replace(":","_");
	}

	public String getTempFolderPath() throws IOException {
		File temp = File.createTempFile("temp-file-name", ".tmp"); 
		String absolutePath = temp.getAbsolutePath();
		String tempFilePath = absolutePath.
				substring(0,absolutePath.lastIndexOf(File.separator));
		return tempFilePath;
	}

	public static String getRandomValue(String value) 
	{
		Random r = new Random();
		String[] values={};
		try {
			values = URLDecoder.decode(value, "UTF-8").split("\\|");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values[r.nextInt(values.length)];
	}

	public static String getRandomNumeric(int count)
	{
		return RandomStringUtils.randomNumeric(count);
	}

	public static String getRandomAlphabetic(int count)
	{
		return RandomStringUtils.randomAlphabetic(count);
	}

	public static String getrandomTestMailId(int length)
	{	   
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		String randomEmail = generatedString.toLowerCase()+"@gmail.com";
		return randomEmail;
	}
}

class FrameworkException extends Exception{
	private static final long serialVersionUID = 1L;
	String str1;
	FrameworkException(String str2) {
		str1=str2;
	}
	public String toString(){ 
		return (str1) ;
	}
}
