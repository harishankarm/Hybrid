package pageClasses.PAM;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;


public class PAM_SearchResult_PO extends BasePage {

	public PAM_SearchResult_PO(WebDriver _driver, ExtentTest _report) {
		super(_driver, _report);
	}

	@FindBy(xpath = "//select[@name='searchBean.pageNum']")
	private List<WebElement> pagedrpdwn;

	@FindBy(xpath = "//input[@class='sortbuttons']")
	private WebElement page_Go;

	@FindBy(xpath = "//select[@name='requestBean.assignUser']")
	private WebElement user_Assignedto;

	@FindBy(xpath = "//td[contains(text(),'SearchResults')]")
	private WebElement SearchResults;

	@FindBy(xpath = "(//table//input[@name='button'][1]/parent::td)[1]")
	private WebElement btn_Go;

	@FindBy(xpath = "//td[contains(text(),'record(s) found')]")
	private WebElement SearchResultsMatchText;

	@FindBy(xpath = "//tr[@class='tableheadrow']/td")
	private List<WebElement> tableHeader;

	@FindBy(xpath = "//tr[@class='tableheadrow']//following-sibling::tr")
	private List<WebElement> tableRow;

	public boolean verifySearchResults() {
		return isDisplayed(SearchResults);
	}

	public String getSearchResultMatchText() {
		return SearchResultsMatchText.getText();
	}

	public void click_GoButton(String data) {
		selectFrame(frameMain);
		wait.until(ExpectedConditions.visibilityOf(btn_Go));
		doIT(btn_Go, data);
		try {
			if (isDisplayedNoException(btn_Go)) {
				doIT(btn_Go, data);
			}
		} catch (Exception e) {
		}
	}

	public List<String> getTableColumn(String tableColName) {
		List<String> header = new ArrayList<String>();
		for (int row = 1; row <= tableRow.size(); row++) {
			String tableColumn = "//tr[@class='tableheadrow']//following-sibling::tr[" + row + "]/td["
					+ getTableHeader(tableColName) + "]";
			header.add(driver.findElement(By.xpath(tableColumn)).getText());
		}
		return header;
	}

	public int getTableHeader(String tableColName) {
		int col;
		for (col = 0; col < tableHeader.size(); col++) {
			if (tableHeader.get(col).getText().contains(tableColName)) {
				break;
			}
		}
		return col + 1;
	}

	public String getSSNnumber(String data) {
		if (!data.isEmpty()) {
			return data.substring(7);
		}
		return data;
	}

}
