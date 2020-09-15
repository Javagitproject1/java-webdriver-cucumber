package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResults extends Page {

    @FindBy (name = "username")
    private WebElement username;

    @FindBy (name = "firstName")
    private WebElement firstName;

    @FindBy (name = "middleName")
    private WebElement middleName;

    @FindBy (name = "lastName")
    private WebElement lastName;

    @FindBy (name = "email")
    private WebElement email;

    @FindBy (xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy (name = "agreedToPrivacyPolicy")
    private WebElement agreedToPrivacyPolicy;

    @FindBy (name = "carMake")
    private WebElement carMake;

    @FindBy (name = "phone")
    private WebElement phone;

    @FindBy (name = "gender")
    private WebElement gender;

    @FindBy (name = "address")
    private WebElement address;

    @FindBy (name = "countryOfOrigin")
    private WebElement countryOfOrigin;

    @FindBy (name = "contactPersonPhone")
    private WebElement contactPersonPhone;

    @FindBy (name = "contactPersonName")
    private WebElement contactPersonName;

    public String userName() {
        return username.getText();
    }

    public String firstName() {
        return firstName.getText();
    }

    public String lastName() {
        return lastName.getText();
    }

    public String middleName() {
        return middleName.getText();
    }

    public String email() {
        return email.getText();
    }

    public String password() {
        return password.getText();
    }

    public boolean agreedToPrivacyPolicy() {
        return Boolean.parseBoolean(agreedToPrivacyPolicy.getText());
    }

    public String carMake() {
        return carMake.getText();
    }

    public String phone() {
        return phone.getText();
    }

    public String gender() {
        return gender.getText();
    }

    public String address() {
        return address.getText();
    }

    public String country() {
        return countryOfOrigin.getText();
    }

    public String contactPersonPhone() {
        return contactPersonPhone.getText();
    }

    public String contactPersonName() {
        return contactPersonName.getText();
    }
}


