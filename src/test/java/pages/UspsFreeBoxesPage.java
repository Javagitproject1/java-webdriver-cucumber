package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class UspsFreeBoxesPage extends UspsHeader {

    @FindBy(xpath = "//div[@id='main_res']//li")
    private List<WebElement> resultsList;

    @FindBy (xpath ="//span [@ID='searchResultsHeading']")
    private WebElement resultsFound;

    private WebElement category(String str) {
        return getDriver().findElement(By.xpath("//div[@id='dyn_nav']//*[(text()='" + str + "')]"));
    }

    public void selectCategory(String cat) {
        category(cat).click();
        waitSpinnerDisappear();
    }

    public int getNumberOfResults() {
        return resultsList.size();
    }

    public String getFoundResults (){
        return resultsFound.getText();
    }
}
