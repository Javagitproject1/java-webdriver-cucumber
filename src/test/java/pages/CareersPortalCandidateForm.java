package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CareersPortalCandidateForm extends CareersPortalHeader{

    @FindBy (xpath = "//label[@for='candidateFirstName']/following-sibling::input[@type='text']")
    private WebElement firstName;

    @FindBy (xpath = "//label[@for='candidateLastName']/following-sibling::input[@type='text']")
    private WebElement lastName;

    @FindBy (xpath = "//label[@for='candidateEmail']/following-sibling::input[@type='text']")
    private WebElement email;

    @FindBy (xpath = "//label[@for='candidatePassword']/following-sibling::input[@type='password']")
    private WebElement password;

    @FindBy (xpath = "//label[@for='candidateConfirmPassword']/following-sibling::input[@type='password']")
    private WebElement confirmPassword;

    @FindBy (xpath = "//label[@for='candidateSummary']/following-sibling::textarea")
    private WebElement summary;

    @FindBy (xpath = "//label[@for='candidateAddress']/following-sibling::input[@type='text']")
    private WebElement address;

    @FindBy (xpath = "//label[@for='candidateCity']/following-sibling::input[@type='text']")
    private WebElement city;

    @FindBy (xpath = "//select [@class='form-control']")
    private WebElement state;

    @FindBy (xpath = "//label[@for='candidateZip']/following-sibling::input[@type='text']")
    private WebElement zip;

    @FindBy (xpath = "//button[text()='Submit'][@type='submit']")
    private WebElement submit;

    @FindBy (xpath = "//button[text()='Delete Account'][@type='submit']")
    private WebElement delete;

    @FindBy (xpath = "//button[text()='Edit'][@type='submit']")
    private WebElement edit;

    @FindBy (xpath="//label[@for='candidateAddress']/following-sibling::span[@type='text']")
    private WebElement candidateAddress;

    @FindBy (xpath = "//label[@for='candidateSummary']/following-sibling::span")
    private WebElement candidateSummary;

    @FindBy (xpath = "//label[@for='candidateCity']/following-sibling::span[@type='text']")
    private WebElement candidateCity;

    public void setFirstName(String value){
        firstName.sendKeys(value);
    }

    public void setLastName(String value){
        lastName.sendKeys(value);
    }

    public void setEmail(String value){
        email.sendKeys(value);
    }

    public void setSummary(String value){
        summary.sendKeys(value);
    }

    public void setPassword(String value){
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void setAddress(String value){
        address.sendKeys(value);
    }

    public void setCity(String value){
        city.sendKeys(value);
    }

    public void setState(String value){
        new Select(state).selectByVisibleText(value);
    }

    public void setZip(String value){
        zip.sendKeys(value);
    }

    public void clickSubmit(){
        click(submit);
    }

    public void clickDeleteAccount(){
        click(delete);
    }

    public void clickEdit (){
        click(edit);
    }

    public void clearAddress (){
        waitForElementIsClickable(address);
        address.clear();
    }
    public void clearCity (){
        waitForElementIsClickable(city);
        city.clear();
    }
    public void clearSummary (){
        waitForElementIsClickable(summary);
        summary.clear();
    }

    public String getCandidateAddress (){
        waitForVisible(candidateAddress);
        return candidateAddress.getText();
    }

    public String getCandidateSummary (){
        waitForVisible(candidateSummary);
        return candidateSummary.getText();
    }

    public String getCandidateCity (){
        waitForVisible(candidateCity);
        return candidateCity.getText();
    }
}
