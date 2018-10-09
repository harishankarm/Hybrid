package frameworkexcel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Driver{
	public static File testDataFileLocation_Destination=null;
	static String app=null;

	public static void main(String[] args) {
		try {
			Driver objDriver=new Driver();

			if(args[1].toUpperCase().contains("PAM")) {app="PAM";}
			else {app="QFund";}
			
			if(args.length==3) {
				objDriver.executeTest(args[0].toUpperCase(),args[1].toUpperCase(),args[2]);
			}else if(args.length==2) {
				objDriver.executeTest(args[0].toUpperCase(),args[1].toUpperCase(),"BATCH");
			}else if(args.length<2) {
				System.out.println("Error: Run parameters are missing");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	void executeTest(String browser,String env,String testCaseType) throws IOException {		

		WebDriver driver = null;		
		ExtentReports extent = null;
		ExtentTest iterationReport = null;		
		ExtentTest testReport = null;
		Class<?> processClass ;	
		String strReportPath= null;
		String sharePath=null;
		Helper flObj=null;
		String mainReport=System.getProperty("user.dir")+"\\report\\Report.html";
		File testDataFileLocation_Source;
		if (InetAddress.getLocalHost().getCanonicalHostName().toLowerCase().contains("hexaware")) {
			if (app.equals("PAM")) { // HARI
				testDataFileLocation_Source = new File("D:\\00TestData\\QFund_PAM_TestData.xlsx");
				sharePath = System.getProperty("java.io.tmpdir");
			} else {
				testDataFileLocation_Source = new File(
						"\\\\EBI149FFEW\\Users\\24246\\Desktopp\\AA\\Testdata\\QFund_Test Data.xlsx");
				sharePath = System.getProperty("java.io.tmpdir");
			}
		} else {
			sharePath = "\\\\aacss\\cssfiles\\";
			testDataFileLocation_Source = new File(
					"\\\\aacss\\cssfiles\\qa\\Automation QFund\\Project on Sandbox\\QFX Hybrid FW_PF\\QFund_Test Data\\QFund_Test Data.xlsx");
		}

		testDataFileLocation_Destination=new File(System.getProperty("java.io.tmpdir")+"\\"+System.getProperty("user.name")+"_Data.xlsx");
		FileUtils.copyFile(testDataFileLocation_Source, testDataFileLocation_Destination,true);

		try {
			flObj=new Helper();	
			
			flObj.openWorkbook();
			
			LinkedHashMap<String, String> configData=flObj.configData(env);

			strReportPath = configData.get("Config_Report_Path").replace("\\\\aacss\\cssfiles\\", sharePath)+"\\Qfundx AutomationReport_" + flObj.getDateAndTimeNow() + ".html";			
			
			flObj.addlogs(LogStatus.INFO+ ": Framework excel file copied from :"+ testDataFileLocation_Source);
			flObj.addlogs(LogStatus.INFO+ ": Framework excel file pasted to :"+ testDataFileLocation_Destination);
			flObj.addlogs(LogStatus.INFO+ ": Report path "+strReportPath);

			extent = new ExtentReports (strReportPath, true);
			extent.addSystemInfo("Environment",env);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

			LinkedHashMap<String, List<String>> tests=flObj.getTests(testCaseType);		


			for(String testCase:tests.keySet()) {

				testReport = extent.startTest(testCase);				

				List<String> processes= tests.get(testCase);
				LinkedHashMap<String, List<Integer>> dataIterationInfo=flObj.getdataIterationInfo(processes, testCase);
				flObj.closeWorkbook();
				int iterationCount=dataIterationInfo.get(processes.get(0)).size();
				
				//Getting driver instance
				driver=flObj.GetDriver(browser, app);

				for(int i=0;i<iterationCount;i++) {		
					try {
						if(iterationCount>1){							
							iterationReport = extent.startTest("Itereation_"+(i+1));
							testReport.appendChild(iterationReport);
						}
						else {iterationReport=testReport;}
						iterationReport.setStartedTime(new Date());
						for(String process:processes) {
							iterationReport.log(LogStatus.INFO,"<----"+process+" Starts---->");

							flObj.openWorkbook();
							/*HARI*/processClass = Class.forName("modules."+flObj.getClassNameForProcess(process));
							Constructor<?> Constructor = processClass.getConstructor(WebDriver.class,LinkedHashMap.class,ExtentTest.class);

							LinkedHashMap<String, String> data=flObj.getData(process, testCase,i, dataIterationInfo,configData);
							flObj.closeWorkbook();
							
							data.putAll(configData);
							
							processClass.getMethod(process).invoke(Constructor.newInstance(driver,data,iterationReport));						
							
							iterationReport.log(LogStatus.INFO,"<----"+process+" Ends---->");							
						}
					}catch(Exception e) {
						e.printStackTrace();
						if(e instanceof NoSuchMethodException) {
							iterationReport.log(LogStatus.FATAL,e.toString());
						}else {
							iterationReport.log(LogStatus.FAIL,iterationReport.addScreenCapture(flObj.getscreenshot(driver,configData.get("Config_Report_Path"))));
							if(e.getCause()!=null) {
								iterationReport.log(LogStatus.FAIL,e.getCause().getClass()+":"+e.getCause().getMessage());
							}else {
								iterationReport.log(LogStatus.FAIL,e.toString());
							}																								
						}							
					}finally{
						iterationReport.setEndedTime(new Date());
						extent.endTest(iterationReport);						
					}	
				}
				
				driver.quit();
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
			if(driver!=null && testReport!=null && flObj!=null) {
				extent.endTest(testReport);	
				driver.quit();
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
