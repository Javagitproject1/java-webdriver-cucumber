package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsSignInPage extends UspsHeader {

    @FindBy (xpath = "//h1 [@id='sign-in-to-your-account-header']")
    private WebElement signInHeader;

    @FindBy (xpath = "//*[@id='btn-submit']")
    private WebElement clickSignIn;

    public boolean signInHeader (){
        waitForVisible(signInHeader);
        waitForVisible(clickSignIn);
        if (!signInHeader.isDisplayed()) {
            return false;
        }
        return true;
    }
}
