package pageClasses.PAM;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	protected WebDriver driver;
	ExtentTest report;
	protected WebDriverWait wait ;
	protected String  parentWindowId;
	protected String childWindowId;
	public String frameTop="TOP";
	public String frameMiddle="MIDDLE";
	public String frameMain="MAIN";
	public String frameBottom="BOTTOM";
	public String frameDefault="DEFAULT";
	public JavascriptExecutor javaScriptExecutor=null;

	@FindBy(xpath = "//img[@alt='Loading...']")
	protected WebElement pageLoader;
	
	@FindBy(id = "topFrame")
	protected WebElement topFrame;
	
	@FindBy(id = "mainFrame")
	protected WebElement mainFrame;
	
	@FindBy(id = "main")
	protected WebElement mainFrameInsidemainFrame;
	
	@FindBy(id = "bottom")
	protected WebElement bottomFrame;

	public BasePage(WebDriver _driver,ExtentTest _report) {
		report=_report;
		driver=_driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		javaScriptExecutor=(JavascriptExecutor) driver;
	}

	public void selectFrame(String frameName) {

		driver.switchTo().defaultContent();
		try {
			wait.until(ExpectedConditions.invisibilityOf(pageLoader));
		}catch(Exception e) {}


		if(frameName.toUpperCase().equals("TOP")) {			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topFrame"));			
		}else if(frameName.toUpperCase().equals("MIDDLE")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainFrame"));						
		}else if(frameName.toUpperCase().equals("MAIN")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainFrame"));			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
		}else if(frameName.toUpperCase().equals("BOTTOM")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottom"));
		}else if(frameName.toUpperCase().equals("DEFAULT")) {
			driver.switchTo().defaultContent();			
		}	
	}

	protected String doIT(WebElement element, String data){

		String temp=Thread.currentThread().getStackTrace()[2].getMethodName();
		String webEvent=temp.split("_")[0];
		String elementName=temp.substring(temp.indexOf("_")+1, temp.length());
		String returnVal=null;

		if(data!=null) {


			if(!data.isEmpty()) {


				//if(element!=null) {new Actions(driver).moveToElement(element).perform();}

				if(webEvent.toLowerCase().equals("set")) {
					try {
						element.sendKeys(data);	
						report.log(LogStatus.INFO, "Value[" + data + "] set in"+"[" + elementName + "]");
						System.out.println(LogStatus.INFO+ ": Value[" + data + "] set in"+"[" + elementName + "]");
					}catch(Exception e) {
						if(e instanceof InvalidElementStateException) {
							try {
								new Select(element).selectByVisibleText(data);	
								report.log(LogStatus.INFO, "Option [" + data + "] selected from the menu"+"[" + elementName + "]");
								System.out.println(LogStatus.INFO+ " :Option [" + data + "] selected from the menu"+"[" + elementName + "]");
							}catch(Exception e1) {
								report.log(LogStatus.FAIL, "Option [" + data + "] not selected from the menu"+"[" + elementName + "]");
								System.out.println(LogStatus.FAIL+ " :Option [" + data + "] not selected from the menu"+"[" + elementName + "]");
								throw e;
							}
						}else {
							report.log(LogStatus.FAIL, "Not able to set value in"+"[" + elementName + "]");
							System.out.println(LogStatus.FAIL+ " :Not able to set value in"+"[" + elementName + "]");
							throw e;
						}
					}
				}

				else if(webEvent.toLowerCase().equals("get")) {
					try {
						returnVal=element.getText();
						if(returnVal.isEmpty()) {
							returnVal=element.getAttribute("value");
						}
						report.log(LogStatus.INFO, "Got text["+ returnVal  + "] from [" + elementName + "]");
						System.out.println(LogStatus.INFO+ ": Got text["+ returnVal  + "] from [" + elementName + "]");
					}catch(Exception e) {
						report.log(LogStatus.FAIL, "Not able to get text from [" + elementName + "]");
						System.out.println(LogStatus.FAIL+ " :Not able to get text from [" + elementName + "]");
						throw e;
					}
				}

				else if(webEvent.toLowerCase().equals("click")) {

					try {
						if(element!=null) {		
							//new Actions(driver).moveToElement(element).perform();
							element.click();
							report.log(LogStatus.INFO, "Clicked " + elementName);
							System.out.println(LogStatus.INFO+ ": Clicked [" + elementName + "]");
						}		
					}catch(Exception e) {
						report.log(LogStatus.FAIL, "Not able to click " + elementName);
						System.out.println(LogStatus.FAIL+ " :Not able to click" + elementName);
						throw e;
					}		
				}

				else if(webEvent.toLowerCase().equals("loadurl")) {	
					try {
						driver.get(data);
						report.log(LogStatus.INFO, "Navigated to " + elementName+"["+data+"]");		
						System.out.println(LogStatus.INFO+ ": Navigated to " + elementName+"["+data+"]");
					}catch(Exception e) {
						report.log(LogStatus.FAIL, "Not able navigate to " + elementName+"["+data+"]");
						System.out.println(LogStatus.FAIL+": Not able navigate to " + elementName+"["+data+"]");
						throw e;
					}
				}

				else if(webEvent.toLowerCase().equals("navigateto")) {	
					try {
						if(element!=null) {
							element.click();
							report.log(LogStatus.INFO, webEvent.replace("navigateTo", "Navigate To"));	
							System.out.println(LogStatus.INFO+" :" +webEvent.replace("navigateTo", "Navigate To"));
						}	

					}catch(Exception e) {
						report.log(LogStatus.FAIL, "Not "+webEvent.replace("navigateTo", "Navigate To"));
						System.out.println(LogStatus.FAIL+" :Not "+webEvent.replace("NAVIGATETO", "Navigate To"));
						throw e;
					}
				}

			}	
		}

		return returnVal;
	}

	public boolean isDisplayed(WebElement element) {

		String temp=Thread.currentThread().getStackTrace()[2].getMethodName();
		String elementName=temp.substring(temp.indexOf("_")+1, temp.length());
		try {
			boolean found=(wait.until(ExpectedConditions.visibilityOf(element))!=null);
			System.out.println(LogStatus.INFO+ ": " + elementName + " displayed = "+ found);
			return found;
		}catch(Exception e){
			return false;			
		}
	}


	protected boolean isDisplayedNoException(WebElement element){
		boolean Found = false;
		try {
			Found= element.isDisplayed();
		}catch (Exception e) {}
		return Found;			
	}


	WebElement getWebElementForDynamicText(String xpathStrig, String DynamicTexts) {

		WebElement FoundElement = null;
		if (!DynamicTexts.isEmpty()) {
			if (DynamicTexts.contains("--->")) {
				String TempText1[] = DynamicTexts.split("--->");
				for (int i = 0; i < TempText1.length; i++) {
					xpathStrig = xpathStrig.replace("DYNAMIC_TEXT" + i, TempText1[i]);
				}
			} else {
				xpathStrig = xpathStrig.replace("DYNAMIC_TEXT", DynamicTexts);
			}
			FoundElement = driver.findElement(By.xpath(xpathStrig));
		}else {FoundElement = null;}

		return FoundElement;
	}

	public void switchToChildWindow()	{		
		if(wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			// Store the current window handle
			parentWindowId = driver.getWindowHandle();			

			List<String> winList=new ArrayList<String>();
			for(String winHandle : driver.getWindowHandles()) {winList.add(winHandle);}	

			for(String window: winList) {
				if(!window.equals(parentWindowId)) {
					driver.switchTo().window(window);
				}
			}

		}	
	}

	public void closeWindow() {
		driver.close();
	}





	public void switchToParentWindow() {
		try {wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		}catch(Exception e) {}

		driver.switchTo().window(parentWindowId);			
	}

	public void acceptAlert(){
		//		if(ExpectedConditions.alertIsPresent().apply(driver)!=null){
		//			driver.switchTo().alert().accept();
		//		}

		AlertDecesion("accept");

	}

	public void dismissAlert(){
		AlertDecesion("dismiss");
	}

	public String getAlertText(){
		return AlertDecesion("getText");
	}

	public boolean isAlertPresent() 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	} 

	public void switchToFlagwindow() {
		if (wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			parentWindowId = it.next();
			childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			driver.close();
			driver.switchTo().window(parentWindowId);
		}
	}


	public String AlertDecesion(String AlertDecesion)
	{
		String alertText=null;
		int i=0;
		while(i++<6)
		{
			try
			{
				if(AlertDecesion.equalsIgnoreCase("accept")) {
					driver.switchTo().alert().accept();
				}else if(AlertDecesion.equalsIgnoreCase("dismiss")) {
					driver.switchTo().alert().dismiss();
				}
				else if(AlertDecesion.equalsIgnoreCase("getText")) {
					alertText=driver.switchTo().alert().getText();
				}
				Thread.sleep(1000);				
				break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				continue;
			}
		}
		return alertText;

	}

	public int visibleWebElementFromListofWebElement(List<WebElement> listWebElement) {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		int foundIndex = 0;

		long startTime = System.currentTimeMillis();
		long elapsedTime = 0;

		while (elapsedTime < 20 * 1000 && foundIndex==0) {				
			for(int i=0;i<listWebElement.size();i++) {
				if(isDisplayedNoException(listWebElement.get(i))) {
					foundIndex=i+1;
				}
			}		
			elapsedTime = (new Date()).getTime() - startTime;
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return foundIndex;
	}

	public String set_Add_DateMMDDYYYY(String data, String moveDate) throws Exception {
		String dateCalculated = null;
		
		if (moveDate.isEmpty()){
			moveDate = "0";
		}
		
		if(!data.isEmpty()&& !moveDate.isEmpty())		{
			int mdate =	Integer.parseInt(moveDate);
			Calendar c = Calendar.getInstance();
			if (data.toUpperCase().equals("TODAY") && moveDate!=null) {
				addDays(c, mdate);
				
				 dateCalculated = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
				
			}else {
				Date date=new SimpleDateFormat("MM/dd/yyyy").parse(data);
				 c.setTime(date);
				 addDays(c, mdate);
				 
				 dateCalculated = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
			}
		}
		System.out.println(dateCalculated.replace("/", "").trim());
		return dateCalculated.replace("/", "").trim();
	}
	
	public void addDays(Calendar c ,int mdate)
	{
		DateFormat dateFormat = new SimpleDateFormat("E, MM/dd/yyyy");
		c.add(Calendar.DATE, mdate);
		if (dateFormat.format(c.getTime()).contains("Sun")) {
			c.add(Calendar.DATE, 1);
		}else if(dateFormat.format(c.getTime()).contains("Sat"))
		{
			c.add(Calendar.DATE, 2);
		}
	}
	
	
	
	
}
