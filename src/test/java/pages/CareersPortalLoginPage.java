package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPortalLoginPage extends CareersPortalHeader{

    @FindBy (xpath = "//div[@class='card-header']")
    private WebElement credentials;

    @FindBy (xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement username;

    @FindBy (xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement password;

    @FindBy (xpath = "//button[@id='loginButton']")
    private WebElement submitButton;

    public boolean getCredentials (){
        waitForVisible(credentials);
        return true;
    }

    public void setUsername (String login){
        username.sendKeys(login);
    }

    public void setPassword (String value){
        password.sendKeys(value);
    }

    public void clickSubmit (){
        submitButton.click();
    }
}
