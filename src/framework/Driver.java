package framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Driver{
	public static String IE_Driver_Version="3_14";
	public static File testDataFileLocation_Destination=null;
	public static File QFund_Config_FileLocation_Destination=null;
	public static File PAM_online_testdataFile_Destination=null;
	public static File Qfund_OutputData=null;
	static LinkedHashMap<String, String> allProcessdataForTest=new LinkedHashMap<String, String>();
	static String app=null;

	public static void main(String[] args) {
		try {			
			Runtime.getRuntime().exec("taskkill /F /IM IE"+IE_Driver_Version+".exe");
			Thread.sleep(2000);
			File IEdriver_FileSource=new File("D:\\00Selenium_Drivers\\IE"+IE_Driver_Version+".exe");
			//File IEdriver_FileSource=new File("\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\Selenium_Drivers\\IE"+IE_Driver_Version+".exe");
			File IEdriver_FileDes=new File(System.getProperty("java.io.tmpdir")+"\\"+"IE"+IE_Driver_Version+".exe");

			FileUtils.copyFile( IEdriver_FileSource, IEdriver_FileDes,true);			
			
			Driver objDriver=new Driver();

			if(args[1].toUpperCase().contains("PAM")) {app="PAM";}
			else {app="QFund";}

			if(args.length==3) {
				objDriver.executeTest(args[0].toUpperCase(),args[1].toUpperCase(),args[2]);
			}else if(args.length<3) {
				System.out.println("Error: Run parameters are missing");
			}		
			
			Runtime.getRuntime().exec("taskkill /F /IM IE"+IE_Driver_Version+".exe");
			IEdriver_FileDes.deleteOnExit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	void executeTest(String browser,String env,String testCaseType) throws IOException {		

		WebDriver driver = null;		
		ExtentReports extent = null;
		ExtentTest testReport = null;
		Class<?> processClass ;	
		String strReportPath= null;
		String sharePath=null;
		Helper flObj=null;
		String mainReport=System.getProperty("user.dir")+"\\report\\Report.html";

		File testDataFileLocation_Source,QFund_ConfigFileLocation_Source,online_testdataFile_Source;
		if(InetAddress.getLocalHost().getCanonicalHostName().toLowerCase().contains("hexaware")) {			
			testDataFileLocation_Source= new File("\\\\EBI149FFEW\\Users\\24246\\Desktop\\AA\\Testdata\\QFund_TestData.xlsx");
			QFund_ConfigFileLocation_Source=new File("\\\\EBI149FFEW\\Users\\24246\\Desktop\\AA\\Testdata\\QFund_Config.xlsx");
			online_testdataFile_Source=new File("\\\\EBI149FFEW\\Users\\24246\\Desktop\\AA\\Testdata\\PAM_OnlineData.xlsx");
			sharePath=System.getProperty("java.io.tmpdir");
		}else {
			sharePath="\\\\aacss\\cssfiles\\";
			testDataFileLocation_Source= new File("\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFund_Test Data\\QFund_TestData.xlsx");
			QFund_ConfigFileLocation_Source= new File("\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFund_Test Data\\QFund_Config.xlsx");
			online_testdataFile_Source= new File("\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFund_Test Data\\PAM_OnlineData.xlsx");
			Qfund_OutputData=new File("\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFund_Test Data\\Qfund_OutputData.xlsx");
		}		

		QFund_Config_FileLocation_Destination=new File(System.getProperty("java.io.tmpdir")+"\\"+System.getProperty("user.name")+"_QFund_Config.xlsx");
		testDataFileLocation_Destination=new File(System.getProperty("java.io.tmpdir")+"\\"+System.getProperty("user.name")+"_Data.xlsx");
		PAM_online_testdataFile_Destination=new File(System.getProperty("java.io.tmpdir")+"\\"+System.getProperty("user.name")+"_PAMData.xlsx");
		FileUtils.copyFile(testDataFileLocation_Source, testDataFileLocation_Destination,true);
		FileUtils.copyFile( QFund_ConfigFileLocation_Source, QFund_Config_FileLocation_Destination,true);
		FileUtils.copyFile( online_testdataFile_Source, PAM_online_testdataFile_Destination,true);

		try {
			flObj=new Helper();	

			LinkedHashMap<String, String> configData=flObj.configData(env, app);
			configData.put("Config_Browser", browser);

			strReportPath = configData.get("Config_Report_Path").replace("\\\\aacss\\cssfiles\\", sharePath)+"\\Qfundx AutomationReport_" + flObj.getDateAndTimeNow() + ".html";			

			//flObj.addlogs(LogStatus.INFO+ ": Report path "+strReportPath);

			extent = new ExtentReports (strReportPath, true);
			extent.addSystemInfo("Environment",env);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

			LinkedHashMap<String, LinkedHashMap<String,String>> tests=flObj.getTestsDetails(testCaseType);		


			for(String testCase:tests.keySet()) {
				Runtime.getRuntime().exec("taskkill /F /IM IE"+IE_Driver_Version+".exe");
				Thread.sleep(5000);

				testReport = extent.startTest(testCase);				

				LinkedHashMap<String,String> testFlow= tests.get(testCase);

				//Getting driver instance
				driver=flObj.GetDriver(browser);

				try {
				
					testReport.setStartedTime(new Date());
					for(String processNo:testFlow.keySet()) {
						
						String temp[]=testFlow.get(processNo).split("-->");
						String process=temp[0];
						String dataName=temp[1];
						
						testReport.log(LogStatus.INFO,"<----"+process+" Starts---->");

						processClass = Class.forName("modules."+ flObj.getClassNameForProcess(process));
						Constructor<?> Constructor = processClass.getConstructor(WebDriver.class,LinkedHashMap.class,ExtentTest.class);

						LinkedHashMap<String, String> data=flObj.getData(process, dataName,configData);

						data.put("testName",testCase);
						data.put("processName",process);						

						Object obj=	processClass.getMethod(process).invoke(Constructor.newInstance(driver,data,testReport));						

						if(obj!=null) {
							driver=(WebDriver)obj;	
						}						
						
						testReport.log(LogStatus.INFO,"<----"+process+" Ends---->");							
					}
				}catch(Exception e) {
					e.printStackTrace();
					if(e instanceof NoSuchMethodException) {
						testReport.log(LogStatus.FATAL,e.toString());
					}else {
						testReport.log(LogStatus.FAIL,testReport.addScreenCapture(flObj.getscreenshot(driver,configData.get("Config_Report_Path"))));
						if(e.getCause()!=null) {
							testReport.log(LogStatus.FAIL,e.getCause().getClass()+":"+e.getCause().getMessage());
						}else {
							testReport.log(LogStatus.FAIL,e.toString());
						}																								
					}							
				}finally{
					testReport.setEndedTime(new Date());
					extent.endTest(testReport);	
					//driver.quit();
				}				
			}

		}catch(Exception e) {
			e.printStackTrace();
			if(testReport==null) {
				testReport=extent.startTest("FATAL ERROR");
			}
			for(String log:flObj.getlogs()) {
				if(log.toLowerCase().contains("error")){
					testReport.log(LogStatus.FATAL,log);
				}else {
					testReport.log(LogStatus.INFO,log);
				}
			}
			testReport.log(LogStatus.FATAL,e.toString());					
		}
		finally{
			if(testReport!=null && flObj!=null) {
				extent.endTest(testReport);	
				extent.flush();
				extent.close();			
				try {					
					FileUtils.copyFile(new File(strReportPath), new File(mainReport),true);
					//new ProcessBuilder("C:\\Program Files\\internet explorer\\iexplore.exe", mainReport).start();				
				} catch (Exception e) {}	
			}
		}
	}
}
