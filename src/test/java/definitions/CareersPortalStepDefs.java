package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;


public class CareersPortalStepDefs {

    CareersPortalHeader careersPortalHeader = new CareersPortalHeader();
    CareersPortalLoginPage careersPortalLoginPage = new CareersPortalLoginPage();
    CareersPortalRecruitPage careersPortalRecruitPage = new CareersPortalRecruitPage();
    CareersPortalPositionPage careersPortalPositionPage = new CareersPortalPositionPage();
    CareersPortalPositionForm careersPortalPositionForm = new CareersPortalPositionForm();
    CareersPortalMyJobsPage careersPortalMyJobsPage = new CareersPortalMyJobsPage();
    CareersPortalLandingPage careersPortalLandingPage = new CareersPortalLandingPage();


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
    public void iRemovePosition(String position){
        careersPortalRecruitPage.goToJob(position);
        careersPortalRecruitPage.removeJob(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String job) {
        assertThat(careersPortalRecruitPage.getAllJobs()).doesNotContain(job);
    }

    @And("I select desired position {string}")
    public void iSelectDesiredPosition(String position){
        careersPortalLandingPage.selectPosition(position);
        assertThat(careersPortalPositionPage.getTitle()).containsIgnoringCase(position);
    }

    @And("I click {string}")
    public void iClick(String button) {
        careersPortalPositionPage.clickButton(button);
    }

    @Then("I fill profile details for {string}")
    public void iFillProfileDetailsFor(String role) {
        Map <String, String> form = getData(role);
        careersPortalPositionForm.setFirstName(form.get("First Name"));
        careersPortalPositionForm.setLastName(form.get("Last Name"));
        careersPortalPositionForm.setEmail(form.get("Email"));
        careersPortalPositionForm.setPassword(form.get("Password"));
        careersPortalPositionForm.setSummary(form.get("Summary"));
        careersPortalPositionForm.setAddress(form.get("Address"));
        careersPortalPositionForm.setCity(form.get("City"));
        careersPortalPositionForm.setState(form.get("State"));
        careersPortalPositionForm.setZip(form.get("Zip"));
    }

    @And("I verify I have submitted for position {string}")
    public void iVerifyIHaveSubmittedForPosition(String title) {
        assertThat(careersPortalMyJobsPage.confirmPosition()).containsIgnoringCase(title);
    }

    @When("I go back to {string} page")
    public void iGoBackToPage(String page){
        careersPortalHeader.clickOnButton(page);
    }

    @And("I select another position {string}")
    public void iSelectAnotherPosition(String position){
        assertThat(careersPortalMyJobsPage.confirmPosition()).isNotEmpty();
        careersPortalLandingPage.clickOnSelectPosition(position);
    }

    @And("I {string}")
    public void i(String logout) {
        careersPortalHeader.clickOnButton(logout);
    }
}
