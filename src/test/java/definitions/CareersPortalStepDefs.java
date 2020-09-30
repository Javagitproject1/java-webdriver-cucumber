package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersPortalHeader;
import pages.CareersPortalRecruitPage;
import pages.CareersPortalLoginPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;


public class CareersPortalStepDefs {

    CareersPortalHeader careersPortalHeader = new CareersPortalHeader();
    CareersPortalLoginPage careersPortalLoginPage = new CareersPortalLoginPage();
    CareersPortalRecruitPage careersPortalRecruitPage = new CareersPortalRecruitPage();

    @And("I login as {string}")
    public void iLoginAs(String role) {
        careersPortalHeader.goToLogin();
        assertThat(careersPortalLoginPage.getCredentials()).isTrue();

        Map<String, String> form = getData(role);
        careersPortalLoginPage.setUsername(form.get("Username"));
        careersPortalLoginPage.setPassword(form.get("Password"));
        careersPortalLoginPage.clickSubmit();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String value) {
        careersPortalHeader.goToRecruitPage();
        assertThat(value).containsIgnoringCase(careersPortalHeader.getRecruitInfo());
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position) throws InterruptedException {
        Thread.sleep(1000);
        careersPortalRecruitPage.goToJob(position);
        careersPortalRecruitPage.removeJob(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String job) {
        assertThat(careersPortalRecruitPage.getAllJobs()).doesNotContain(job);
    }
}
