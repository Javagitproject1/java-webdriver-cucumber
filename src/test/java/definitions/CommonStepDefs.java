package definitions;

import cucumber.api.java.en.Given;
import pages.*;

public class CommonStepDefs {

    @Given("I open {string} page")
    public void iOpenPage(String page) throws Exception {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "ups":
                new UpsForm().open();
                break;
            case "usps":
                new UspsHome().open();
                break;
            case "careers":
                new CareersPortalLandingPage().open();
                break;
            default:
                throw new Exception("Unknown page:" + page);
        }
    }
}
