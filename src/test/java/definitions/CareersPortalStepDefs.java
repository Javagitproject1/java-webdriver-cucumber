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
        //careersPortalHeader.goToRecruitPage();
        assertThat(value).containsIgnoringCase(careersPortalHeader.getRecruitInfo());
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position) {
        careersPortalRecruitPage.goToJob(position);
        careersPortalRecruitPage.removeJob(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String job) {
        assertThat(careersPortalRecruitPage.getAllJobs()).doesNotContain(job);
    }

    @And("I select desired position {string}")
    public void iSelectDesiredPosition(String position) {
        careersPortalLandingPage.selectPosition(position);
        assertThat(careersPortalPositionPage.getTitle()).containsIgnoringCase(position);
    }

    @And("I click {string}")
    public void iClick(String button) {
        careersPortalPositionPage.clickButton(button);
    }

    @Then("I fill profile details for {string}")
    public void iFillProfileDetailsFor(String role) {
        Map<String, String> form = getData(role);
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
    public void iGoBackToPage(String page) {
        careersPortalHeader.clickOnButton(page);
    }

    @And("I select another position {string}")
    public void iSelectAnotherPosition(String position) {
        assertThat(careersPortalMyJobsPage.confirmPosition()).isNotEmpty();
        careersPortalLandingPage.clickOnSelectPosition(position);
    }

    @And("I {string}")
    public void i(String logout) {
        careersPortalHeader.clickOnButton(logout);
    }

    @When("I create new {string} position")
    public void iCreateNewPosition(String newPosition) {
        careersPortalHeader.goToRecruitPage();
        careersPortalRecruitPage.clickOnNewPosition();

        Map<String, String> role = getData(newPosition);
        careersPortalNewPositionForm.setTitle(role.get("title"));
        careersPortalNewPositionForm.setDescription(role.get("description"));
        careersPortalNewPositionForm.setAddress(role.get("address"));
        careersPortalNewPositionForm.setCity(role.get("city"));
        careersPortalNewPositionForm.setState(role.get("state"));
        careersPortalNewPositionForm.setZip(role.get("zip"));
        careersPortalNewPositionForm.setDate();
        //bug -> when click Today and submit, the date is set to yesterday
        careersPortalNewPositionForm.submitPosition();

    }

    @Then("I verify new {string} position is created")
    public void iVerifyNewPositionIsCreated(String role) {
        Map<String, String> position = getData(role);
        String positionTitle = position.get("title");
        assertThat(careersPortalRecruitPage.positionVisible(positionTitle)).isTrue();
    }

    @When("I remove new {string} position")
    public void iRemoveNewPosition(String role) {
        Map<String, String> position = getData(role);
        String createdPosition = position.get("title");

        careersPortalRecruitPage.goToJob(createdPosition);
        careersPortalRecruitPage.removeJob(createdPosition);
    }

    @And("I verify new {string} position is removed")
    public void iVerifyNewPositionIsRemoved(String role) {
        Map<String, String> position = getData(role);
        String createdPosition = position.get("title");
        assertThat(careersPortalRecruitPage.getAllJobs()).doesNotContain(createdPosition);
    }

    @When("I update new {string} position")
    public void iUpdateNewPosition(String role) {
        Map<String, String> position = getData(role);
        String createdPosition = position.get("title");
        careersPortalRecruitPage.goToJob(createdPosition);
        careersPortalRecruitPage.clickOnPosition(createdPosition);

        careersPortalPositionPage.clickEdit();
        Map<String, String> updatePositionFields = getData(role + "_updated");
        careersPortalNewPositionForm.clearAddress();
        careersPortalNewPositionForm.setAddress(updatePositionFields.get("address"));
        careersPortalNewPositionForm.clearCity();
        careersPortalNewPositionForm.setCity(updatePositionFields.get("city"));
        careersPortalNewPositionForm.setDate();
        careersPortalNewPositionForm.submitPosition();
    }

    @Then("I verify new {string} position is updated")
    public void iVerifyNewPositionIsUpdated(String title) {
        Map<String, String> updatePositionFields = getData(title + "_updated");
        assertThat(careersPortalNewPositionForm.getPositionAddress()).containsIgnoringCase(updatePositionFields.get("address"));
        assertThat(careersPortalNewPositionForm.getPositionCity()).containsIgnoringCase(updatePositionFields.get("city"));
    }

    @And("I submit application to a {string} position as a {string}")
    public void iSubmitApplicationToAPositionAsA(String role, String title) {
        careersPortalLandingPage.selectPosition(role);
        assertThat(careersPortalPositionPage.getTitle()).containsIgnoringCase(role);
        careersPortalPositionPage.clickApply();

        Map<String, String> form = getData(title);
        careersPortalCandidateForm.setFirstName(form.get("firstName"));
        careersPortalCandidateForm.setLastName(form.get("lastName"));
        careersPortalCandidateForm.setEmail(form.get("email"));
        careersPortalCandidateForm.setPassword(form.get("password"));
        careersPortalCandidateForm.setSummary(form.get("summary"));
        careersPortalCandidateForm.setAddress(form.get("address"));
        careersPortalCandidateForm.setCity(form.get("city"));
        careersPortalCandidateForm.setState(form.get("state"));
        careersPortalCandidateForm.setZip(form.get("zip"));
        careersPortalCandidateForm.clickSubmit();
    }

    @Then("I verify new {string} is created")
    public void iVerifyNewIsCreated(String title) {
        Map<String, String> candidate = getData(title);
        String candidateName = candidate.get("firstName");
        assertThat(careersPortalHeader.getCandidateTitle()).containsIgnoringCase(candidateName);
    }

    @When("I delete candidate profile")
    public void iDeleteCandidateProfile() {
        careersPortalHeader.clickOnCandidate();
        careersPortalCandidateForm.clickDeleteAccount();
    }

    @Then("I verify new {string} is removed")
    public void iVerifyNewIsRemoved(String title) {
        Map<String, String> candidate = getData(title);
        String candidateName = candidate.get("firstName");
        assertThat(careersPortalHeader.getNavBarText()).doesNotContain(candidateName);
    }

    @When("I update new {string}")
    public void iUpdateNew(String title) {
        Map<String, String> updatedCandidate = getData(title + "_updated");
        careersPortalHeader.clickOnCandidate();
        careersPortalCandidateForm.clickEdit();
        careersPortalCandidateForm.clearAddress();
        careersPortalCandidateForm.setAddress(updatedCandidate.get("address"));
        careersPortalCandidateForm.clearCity();
        careersPortalCandidateForm.setCity(updatedCandidate.get("city"));
        careersPortalCandidateForm.clearSummary();
        careersPortalCandidateForm.setSummary(updatedCandidate.get("summary"));
        careersPortalCandidateForm.clickSubmit();

    }

    @Then("I verify new {string} is updated")
    public void iVerifyNewIsUpdated(String title) {
        Map<String, String> updatedCandidate = getData(title + "_updated");
        assertThat(careersPortalCandidateForm.getCandidateAddress()).containsIgnoringCase(updatedCandidate.get("address"));
        assertThat(careersPortalCandidateForm.getCandidateCity()).containsIgnoringCase(updatedCandidate.get("city"));
        assertThat(careersPortalCandidateForm.getCandidateSummary()).containsIgnoringCase(updatedCandidate.get("summary"));

    }

    @When("I delete new candidate profile")
    public void iDeleteNewCandidateProfile() {
        careersPortalCandidateForm.clickDeleteAccount();
    }

    @Then("I verify login for {string}")
    public void iVerifyLoginFor(String value) {
        Map<String, String> candidate = getData(value);
        String candidateName = candidate.get("firstName");
        assertThat(careersPortalHeader.getCandidateTitle()).containsIgnoringCase(candidateName);
    }

    @When("I apply for a {string} position")
    public void iApplyForAPosition(String role) {
        careersPortalLandingPage.clickOnSelectPosition(role);
    }

    @Then("I see {string} position marked as applied")
    public void iSeePositionMarkedAsApplied(String title) {
        assertThat(careersPortalLandingPage.isPositionSelected(title)).isTrue();
    }

    @And("I see {string} position in {string}")
    public void iSeePositionIn(String role, String page) {
        careersPortalHeader.clickOnButton(page);
        assertThat(careersPortalMyJobsPage.confirmPosition()).containsIgnoringCase(role);

    }

    @When("I withdraw from {string} position")
    public void iWithdrawFromPosition(String role) {
        careersPortalMyJobsPage.withdrawButton(role);
    }

    @Then("I don't see {string} position in my jobs")
    public void iDonTSeePositionInMyJobs(String role) {
        assertThat(careersPortalMyJobsPage.isPositionWithdrawn(role)).isTrue();
    }
}
