package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;


public class CareersPortalStepDefs {

    CareersPortalHeader careersPortalHeader = new CareersPortalHeader();
    CareersPortalLoginPage careersPortalLoginPage = new CareersPortalLoginPage();
    CareersPortalRecruitPage careersPortalRecruitPage = new CareersPortalRecruitPage();
    CareersPortalPositionPage careersPortalPositionPage = new CareersPortalPositionPage();
    CareersPortalCandidateForm careersPortalCandidateForm = new CareersPortalCandidateForm();
    CareersPortalMyJobsPage careersPortalMyJobsPage = new CareersPortalMyJobsPage();
    CareersPortalLandingPage careersPortalLandingPage = new CareersPortalLandingPage();
    CareersPortalNewPositionForm careersPortalNewPositionForm = new CareersPortalNewPositionForm();


    @And("I login as {string}")
    public void iLoginAs(String role) {
        careersPortalHeader.goToLogin();
        assertThat(careersPortalLoginPage.getCredentials()).isTrue();

        Map<String, String> form = getData(role);
        careersPortalLoginPage.setUsername(form.get("email"));
        careersPortalLoginPage.setPassword(form.get("password"));
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
        careersPortalCandidateForm.setFirstName(form.get("firstName"));
        careersPortalCandidateForm.setLastName(form.get("lastName"));
        careersPortalCandidateForm.setEmail(form.get("email"));
        careersPortalCandidateForm.setPassword(form.get("password"));
        careersPortalCandidateForm.setSummary(form.get("summary"));
        careersPortalCandidateForm.setAddress(form.get("address"));
        careersPortalCandidateForm.setCity(form.get("city"));
        careersPortalCandidateForm.setState(form.get("state"));
        careersPortalCandidateForm.setZip(form.get("zip"));
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

    @When("I create new {string} position")
    public void iCreateNewPosition(String newPosition){
        careersPortalRecruitPage.clickOnNewPosition();

        Map <String, String> role = getData(newPosition);
        careersPortalNewPositionForm.setTitle(role.get("title"));
        careersPortalNewPositionForm.setDescription(role.get("description"));
        careersPortalNewPositionForm.setAddress(role.get("address"));
        careersPortalNewPositionForm.setCity(role.get("city"));
        careersPortalNewPositionForm.setState(role.get("state"));
        careersPortalNewPositionForm.setZip(role.get("zip"));
        careersPortalNewPositionForm.setDate();
        careersPortalNewPositionForm.submitPosition();
    }

    @Then("I verify new {string} position is created")
    public void iVerifyNewPositionIsCreated(String role) throws InterruptedException {
        Map <String, String> position = getData(role);
        String createdPosition = position.get("title");
        Thread.sleep(3000);
        assertThat(careersPortalRecruitPage.isPositionVisible(createdPosition)).isTrue();
    }

    @When("I remove new {string} position")
    public void iRemoveNewPosition(String role) {
        Map <String, String> position = getData(role);
        String createdPosition = position.get("title");

        careersPortalRecruitPage.goToJob(createdPosition);
        careersPortalRecruitPage.removeJob(createdPosition);
    }

    @And("I verify new {string} position is removed")
    public void iVerifyNewPositionIsRemoved(String role) {
        Map <String, String> position = getData(role);
        String createdPosition = position.get("title");
        assertThat(careersPortalRecruitPage.getAllJobs()).doesNotContain(createdPosition);
    }
}
