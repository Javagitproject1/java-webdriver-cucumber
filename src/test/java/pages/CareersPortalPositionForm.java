package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareersPortalPositionForm extends CareersPortalHeader{

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

}
