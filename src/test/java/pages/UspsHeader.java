package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class UspsHeader extends Page{

    @FindBy(id ="mail-ship-width")
    private WebElement mailAndShip;

    @FindBy (xpath="//a[contains(@href,'ZipLookup')][text () = 'Look Up a ZIP Code']")
    private WebElement lookUpByZip;

    @FindBy (xpath = "//li[@class='tool-calc'] // a [text()='Calculate a Price']")
    private WebElement calculatePrice;

    @FindBy (xpath = "//a[@id='navsearch']/..")
    private WebElement searchLoop;

    @FindBy (id = "global-header--search-track-search")
    private WebElement searchByText;

    @FindBy (xpath = "//div[@class='white-spinner-container']")
    private WebElement spinner;

    private WebElement menuItem (String menu) {
        return getDriver().findElement(By.xpath("//a [@class='menuitem'][text()='" + menu + "']"));
    }

    public void goTolookUpByZip (){
        mouseOver(mailAndShip);
        click(lookUpByZip);
    }

    public void goToCalculatePrice(){
        mouseOver(mailAndShip);
        click(calculatePrice);
    }

    public void goToSearch (String value){
        mouseOver(searchLoop);

        switch (value){
            case "Free Boxes":
                click(searchByText);
                searchByText.sendKeys(value);
                searchByText.sendKeys(Keys.ENTER);
                break;
        }
        waitSpinnerDisappear();
    }

    public void goToHelpPage (String value){
        menuItem(value).click();
    }
}
