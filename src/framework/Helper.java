package framework;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper{

	Connection connection;
	LinkedList<String> alLogs;	
	protected LinkedHashMap<String, String> allProcessData;
	protected WebDriver driver;
	protected ExtentTest report;	
	protected String testName;
	protected String processName;

	public Helper(){}

	protected Helper(WebDriver _driver,LinkedHashMap<String, String> data,ExtentTest _report){
		driver=_driver;
		report=_report;	
		allProcessData=data;
		testName=data.get("testName");
		processName=data.get("processName");	
	}

	public void ulterDataAndProcess(LinkedHashMap<String, String> data,String process){
		allProcessData=data;
		processName=process;	
	}




	public String data(String key) throws FrameworkException {		

		String Val=null;

		if(key.contains("Config_")) {
			Val=allProcessData.get(key);
		}else if(key.contains("onlineData_")){
			Val=allProcessData.get(key);
		}else {Val=allProcessData.get(processName+"."+key.toString());}
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
				System.out.println(LogStatus.PASS+": "+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {	
				report.log(LogStatus.FAIL,": "+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				System.out.println(LogStatus.FAIL+": "+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				throw new FrameworkException(msg+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");				
			}
		}
	}

	public void assertAreNotEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception   {			
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {	
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				System.out.println(LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				throw new FrameworkException(msg+"Expected["+oExpected.toString()+"] "+"Actual["+oExpected.toString()+"]");
			}else {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println(LogStatus.PASS+":"+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}				
		}
	}

	public void verifyAreEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception {		
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println(LogStatus.PASS+":"+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.FAIL,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println(LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}	
		}
	}

	public void verifyAreNotEqual(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception {			
		if(!oExpected.toString().isEmpty()) {
			if(oExpected.equals(oActual)) {
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.FAIL,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println(LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println(LogStatus.PASS+": "+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}	
		}
	}

	public void assertAreContain(String msg,ExtentTest report,Object oActual,Object oExpected) throws Exception{
		if(!oExpected.toString().isEmpty()) {
			if(oActual.toString().contains(oExpected.toString())) {
				report.log(LogStatus.PASS,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				report.log(LogStatus.PASS,report.addScreenCapture(getscreenshot(driver,data("Config_Report_Path"))));
				System.out.println(LogStatus.PASS+": "+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
			}else {	
				report.log(LogStatus.FAIL,msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				System.out.println(LogStatus.FAIL+msg+": "+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");
				throw new FrameworkException(msg+"Expected["+oExpected.toString()+"] "+"Actual["+oActual.toString()+"]");				
			}
		}
	}


	public void addlogs(String log) {
		//alLogs.add(log);
		//System.out.println(log);
	}

	public LinkedList<String> getlogs() {
		return alLogs;
	}

	// =================================================
	public WebDriver GetDriver(String browser) throws Exception{
		WebDriver driver = null;

		try {  
			switch(browser) {

			case "Firefox":		

				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions fireFoxOptions = new FirefoxOptions().setProfile(new FirefoxProfile());
				//fireFoxOptions.setBinary(configData.get("FirefoxBinary"));
				driver = new FirefoxDriver(fireFoxOptions);

				break;

			case "Chrome":

				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				//chromeOptions.setCapability("chrome.binary", configData.get("ChromeBinary").toString());
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("disable-extensions");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);

				driver = new ChromeDriver(chromeOptions);

				break;

			case "IE":		

				//WebDriverManager.iedriver().setup();

				System.setProperty("webdriver.ie.driver", System.getProperty("java.io.tmpdir")+"\\"+browser+Driver.IE_Driver_Version+".exe");
				InternetExplorerOptions IEoptions = new InternetExplorerOptions();
				IEoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				//IEoptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,true);
				//IEoptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS,true);
				//IEoptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
				//IEoptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);

				driver = new InternetExplorerDriver(IEoptions);		

				break;

			case "EDGE":

				WebDriverManager.edgedriver().setup();

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

	Recordset getRecordSet(String excelFilePath,String sqlQuerry) throws Exception {

		connection = new Fillo().getConnection(excelFilePath);
		Recordset recordset;
		try {
			recordset = connection.executeQuery(sqlQuerry);
		} catch (FilloException e) {
			throw new FrameworkException("Record not found for the query["+sqlQuerry+"]");
		}
		return recordset;
	}


	public LinkedHashMap<String,LinkedHashMap<String,String>> getTestsDetails(String testCaseType) throws Exception {
		LinkedHashMap<String, LinkedHashMap<String,String>> Tests=new LinkedHashMap<String, LinkedHashMap<String,String>>();
		if(testCaseType.toUpperCase().contains("_SUITE")) {
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");			
			Recordset recordset=getRecordSet(Driver.QFund_Config_FileLocation_Destination.getAbsolutePath(),"Select * from "+testCaseType+" where Run='Y'");
			while(recordset.next()){
				Tests.put(recordset.getField("TestCases"), getTestDetails(recordset.getField("TestCases")));
			}
			recordset.close();		
			connection.close();
		}else {Tests.put(testCaseType,getTestDetails(testCaseType));}
		return Tests;
	}

	public LinkedHashMap<String,String> getTestDetails(String testCase) throws Exception {
		LinkedHashMap<String,String> Tests=new LinkedHashMap<String,String>();
		Recordset recordset=getRecordSet(Driver.QFund_Config_FileLocation_Destination.getAbsolutePath(),"Select * from TestCases where TestName='"+testCase+"'");
		recordset.next();	
		String processNo = null,processName = null,dataName = null;
		for(String testFlow:recordset.getFieldNames()){			
			String value=recordset.getField(testFlow);
			if(!value.isEmpty()) {				
				if(testFlow.toLowerCase().contains("process")) {processNo=testFlow;processName=value;}
				if(testFlow.toLowerCase().contains("data")) {dataName=value;}				
			}else {break;}
			if(dataName!=null) {
				Tests.put(processNo,processName+"-->"+dataName);
			}
		}
		recordset.close();		
		connection.close();

		return Tests;
	}

	public String getOutputData(String querry,String Field) throws Exception{
		String FiledValue=null;

		Recordset recordset=getRecordSet(Driver.Qfund_OutputData.getAbsolutePath(),querry);
		recordset.next();
		FiledValue=recordset.getField(Field);
		recordset.close();		
		connection.close();

		return FiledValue;

	}

	public void updateOutputDataSheet(String querry) throws Exception{
		try {
			Connection connection=new Fillo().getConnection(Driver.Qfund_OutputData.getAbsolutePath());		
			connection.executeUpdate(querry);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void updateDataSheet(String colName,String valueToUpdate) throws Exception{
		try {
			Driver.allProcessdataForTest.put(processName+"."+colName,valueToUpdate);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getClassNameForProcess(String prcoess) throws Exception{
		String Module=null;
		Recordset recordset=getRecordSet(Driver.QFund_Config_FileLocation_Destination.getAbsolutePath(),"Select * from ProcessDetails where ProcessName='"+prcoess+"'");
		recordset.next();
		Module=recordset.getField("AppType")+"."+recordset.getField("Modules");
		recordset.close();		
		connection.close();

		return Module;
	}

	public LinkedHashMap<String, String> configData(String configName, String userType) throws Exception{
		LinkedHashMap<String, String> configData=new LinkedHashMap<String, String>();
		Recordset recordset=getRecordSet(Driver.QFund_Config_FileLocation_Destination.getAbsolutePath(),"Select * from Config where CONFIG_NAME='"+configName+"'");
		recordset.next();
		for(String filed:recordset.getFieldNames()) {
			configData.put("Config_"+filed, recordset.getField(filed));
		}
		recordset.close();		
		connection.close();

		if (userType.equals("PAM")) {
			Recordset recordset_=getRecordSet(Driver.PAM_online_testdataFile_Destination.getAbsolutePath(),"Select * from onlineData where LoanStatus='New'");
			recordset_.next();
			for (String filed : recordset_.getFieldNames()) {
				configData.put("onlineData_" + filed, recordset_.getField(filed));
			}
			recordset.close();		
			connection.close();
		}
		return configData;
	}

	public LinkedHashMap<String, String> getData(String process,String dataName,LinkedHashMap<String, String> configData) throws Exception{
		LinkedHashMap<String, String> data=new LinkedHashMap<String, String>();
		Recordset recordset=getRecordSet(Driver.testDataFileLocation_Destination.getAbsolutePath(),"Select * from "+process+" where DataName='"+dataName+"'");
		recordset.next();

		List<String> processes=recordset.getFieldNames();

		for(String filed:processes) {
			String key=filed;
			String value= recordset.getField(filed);
			if(value!=null) {
				if(value.contains("CDF(")) {	
					String temp[]=(value.replace("CDF(", "").replace(")", "")).split("\\.");
					if(value.contains("CDF(Config.")) {
						value=configData.get("Config_"+temp[1].trim());
					}else if(value.contains("CDF(onlineData.")){ 
						value=configData.get("onlineData_"+temp[1].trim());
					}else {
						value=Driver.allProcessdataForTest.get(temp[0]+"."+temp[1]);			
					}
				}
				data.put(process+"."+key, value);
			}  
		}
		recordset.close();		
		connection.close();
		data.putAll(configData);
		Driver.allProcessdataForTest.putAll(data);
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
		catch (Exception e)  
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
