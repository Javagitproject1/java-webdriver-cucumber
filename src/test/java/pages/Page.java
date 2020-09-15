package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Page {

    //fields
    protected String url;
    protected String title;

    // constructor
    public Page() {
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
        title = "Get a quote";
    }

    public void open() {
        getDriver().get(url);
    }

}
