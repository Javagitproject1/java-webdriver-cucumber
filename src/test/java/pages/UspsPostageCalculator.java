package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UspsPostageCalculator extends UspsHeader{
    @FindBy(id = "CountryID")
    private WebElement destCountry;

    public void selectCountry (String value){
        new Select(destCountry).selectByVisibleText(value);
    }


}
