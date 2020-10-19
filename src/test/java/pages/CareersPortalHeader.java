package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CareersPortalHeader extends Page {

    @FindBy (xpath = "//button[text ()='Login']")
    private WebElement login;

    @FindBy (xpath = "//button[text()='Recruit']")
    private WebElement recruiterLogin;

    @FindBy (xpath= "//span[@class='navbar-brand position-center']")
    private WebElement pageTitle;

    @FindBy (xpath = "//div/span/a")
    private WebElement candidateTitle;

    @FindBy (xpath ="//div[@id='shuffle']/nav[contains (@class, 'fixed-top')]")
    private WebElement topNavBar;

    private WebElement headerButtons(String value){
        return getByXpath("//button[text ()='" + value + "']");



    }
    public void goToLogin(){
        mouseOver(login);
        click(login);
    }

    public void goToRecruitPage(){
        waitForVisible(recruiterLogin);
        click(recruiterLogin);
    }

    public String getRecruitInfo(){
        waitForVisible(recruiterLogin);
        return recruiterLogin.getText();
    }

    public void clickOnButton (String value){
        WebElement headButton = headerButtons(value);
        waitForVisible(headButton);
        click(headButton);
    }

    public String getCandidateTitle(){
        waitForVisible(candidateTitle);
        return candidateTitle.getText();
    }

    public void clickOnCandidate(){
        waitForVisible(candidateTitle);
        click(candidateTitle);
    }

    public String getNavBarText (){
        waitForVisible(topNavBar);
        return topNavBar.getText();
    }
}
