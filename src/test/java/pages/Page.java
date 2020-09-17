package pages;

import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

import static support.TestContext.getDriver;

public class Page {

    //fields
    protected String url;
    protected String title;

    // constructor
    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open(String whatPage) throws Exception {
        switch (whatPage){
            case "quote":
                url = "https://skryabin.com/market/quote.html";
                title = "Get a quote";
                getDriver().get(url);
                break;
            case "ups":
                url = "https://www.ups.com/us/en/Home.page";
                title = "Global Shipping & Logistics Services | UPS - United States";
                getDriver().get(url);
                break;
            default:
                throw new Exception("This is unknown page to the system:" + whatPage);
        }

    }

}
