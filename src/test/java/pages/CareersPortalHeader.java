package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPortalHeader extends Page {

    @FindBy (xpath = "//button[text ()='Login']")
    private WebElement login;

    @FindBy (xpath = "//button[text()='Recruit']")
    private WebElement recruiterLogin;

    @FindBy (xpath= "//span[@class='navbar-brand position-center']")
    private WebElement recruiterPage;

    public void goToLogin(){
        mouseOver(login);
        click(login);
    }

    public void goToRecruitPage(){
        waitForVisible(recruiterLogin);
        click(recruiterLogin);
    }

    public String getRecruitInfo(){
        return recruiterPage.getText();
    }
}
