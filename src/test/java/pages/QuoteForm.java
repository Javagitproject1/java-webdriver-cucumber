package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class QuoteForm extends Page {

    // selectors
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@type='button']/span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitForm;

    //optional fields
    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement dobMonth;

    @FindBy (xpath = "//select[@class='ui-datepicker-year']")
    private WebElement dobYear;

    @FindBy (xpath = "//*[@class='ui-state-default'][text()='12']")
    private WebElement dobDay;

    @FindBy (xpath = "//select[@name='countryOfOrigin']")
    private WebElement country;

    @FindBy (xpath = "//input[@name='gender'][@value='male']")
    private WebElement gender;

    @FindBy (xpath = "//*[@name='carMake']")
    private WebElement carMake;

    @FindBy (id = "address")
    private WebElement address;

    //iframe

    @FindBy (name="additionalInfo")
    private WebElement additionalInfoFrame;

    @FindBy (id="contactPersonName")
    private WebElement contactPersonName;

    @FindBy (id="contactPersonPhone")
    private WebElement contactPersonPhone;

    @FindBy (id="username-error")
    private WebElement userNameError;

    @FindBy (id="email-error")
    private WebElement emailError;

    @FindBy (id="password-error")
    private WebElement passwordError;

    @FindBy (id="name-error")
    private WebElement nameError;

    @FindBy (id="agreedToPrivacyPolicy-error")
    private WebElement getPrivacyPolicyError;

    @FindBy (id="confirmPassword-error")
    private WebElement getConfirmPasswordError;


    //methods

    public void fillUsername(String value) {
        username.click();
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillPasswordOnly (String value){
        password.sendKeys(value);
    }

    public void fillConfirmedPasswordOnly (String value){
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String middleNameValue,  String lastNameValue) {
        name.click();
        firstName.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void setPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit() {
        submitForm.click();
    }

    public void phone (String value) {
        phone.sendKeys(value);
    }

    public void birthdate (){
        dateOfBirth.click();
    }

    public void dobInfo(String month, String year){

        Select yearOption = new Select(dobYear);
        yearOption.selectByValue(year);

        Select monthOption = new Select(dobMonth);
        monthOption.selectByVisibleText(month);

        dobDay.click();
    }


    public void countryOfOrigin (String ctr){
        Select countryOption = new Select(country);
        countryOption.selectByValue(ctr);
    }

    public void genderValue (){
        gender.click();
    }

    public void carMake (String car){
        Select carOption = new Select(carMake);
        carOption.selectByValue(car);
    }

    public void address (String value){
        address.sendKeys(value);
    }

    public void fillAdditionalInfo (String nameValue, String phoneValue){
        getDriver().switchTo().frame(additionalInfoFrame);
        contactPersonName.sendKeys(nameValue);
        contactPersonPhone.sendKeys(phoneValue);
        getDriver().switchTo().defaultContent();
    }

    public String getUserNameError (){
       return userNameError.getText();
    }

    public String getEmailError (){
        return emailError.getText();
    }

    public String getPasswordError (){
        return passwordError.getText();
    }

    public String getNameError (){
        return nameError.getText();
    }

    public String getPrivacyPolicyError (){
        return getPrivacyPolicyError.getText();
    }

    public String getConfirmedPasswordError (){
        return getConfirmPasswordError.getText();
    }

    public void clearUsername (){
        username.clear();
    }

    public void clearPassword (){
        password.clear();
    }

    public void clearConfirmPassword (){
        confirmPassword.clear();
    }

    public String getFullName (String value){
        return name.getAttribute(value);
    }

}
