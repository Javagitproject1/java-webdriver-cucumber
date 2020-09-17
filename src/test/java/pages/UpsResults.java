package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsResults extends Page {
    @FindBy(xpath = "//span[@id='originnbsAgentSummaryName']")
    WebElement summaryName;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryAddressLine1']")
    WebElement summaryAddress;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryCity']")
    WebElement summaryCity;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryState']")
    WebElement summaryState;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryPostalCode']")
    WebElement summaryPostalCode;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryEmail']")
    WebElement summaryEmail;

    @FindBy(xpath = "//span[@id='originnbsAgentSummaryPhone']")
    WebElement summaryPhone;

    public String getName() {
        return summaryName.getText();
    }

    public String getAddress() {
        return summaryAddress.getText();
    }

    public String getCity() {
        return summaryCity.getText();
    }

    public String getState() {
        return summaryState.getText();
    }

    public String getPostalCode() {
        return summaryPostalCode.getText();
    }

    public String getEmail() {
        return summaryEmail.getText();
    }

    public String getPhone() {
        return summaryPhone.getText();
    }
}
