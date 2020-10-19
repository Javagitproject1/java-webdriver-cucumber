@careers
  Feature: Careers portal test suit

    @careers1
    Scenario: Recruiter removes position
      Given I open "careers" page
      And I login as "recruiter"
      Then I verify "recruiter" login
      When I remove "Principal Automation Engineer" position
      And I verify "Principal Automation Engineer" position is removed

    @careers2
    Scenario: Candidate applies for position
      Given I open "careers" page
      And I select desired position "Principal Automation Engineer"
      And I click "Apply"
      Then I fill profile details for "candidate"
      And I click "Submit"
      And I verify I have submitted for position "Principal Automation Engineer"
      When I go back to "Careers" page
      And I select another position "Principal Applications Developer"
      And I go back to "My Jobs" page
      Then I verify I have submitted for position "Principal Applications Developer"
      And I "Logout"

    @careers3
    Scenario: Recruiter creates position
      Given I open "careers" page
      And I login as "recruiter"
      Then I verify "recruiter" login
      When I create new "automation" position
      Then I verify new "automation" position is created
      When I remove new "automation" position
      And I verify new "automation" position is removed

    @careers4
    Scenario: Recruiter updates position
      Given I open "careers" page
      And I login as "recruiter"
      And I create new "automation" position
      Then I verify new "automation" position is created
      When I update new "automation" position
      Then I verify new "automation" position is updated

    @careers5
    Scenario: Candidate creates profile
      Given I open "careers" page
      And I submit application to a "Test Automation Engineer" position as a "candidate"
      Then I verify new "candidate" is created
      When I delete candidate profile
      Then I verify new "candidate" is removed

    @careers6
    Scenario: Candidate updates profile
      Given I open "careers" page
      And I submit application to a "Test Automation Engineer" position as a "candidate"
      Then I verify new "candidate" is created
      When I update new "candidate"
      Then I verify new "candidate" is updated
      When I delete new candidate profile
      Then I verify new "candidate" is removed

    @careers7
    Scenario: Candidates applies and withdraws from a new position
      Given I open "careers" page
      And I login as "candidate1"
      Then I verify login for "candidate1"
      When I apply for a "Principal Automation Engineer" position
      Then I see "Principal Automation Engineer" position marked as applied
      And I see "Principal Automation Engineer" position in "My Jobs"
      When I withdraw from "Principal Automation Engineer" position
      Then I don't see "Principal Automation Engineer" position in my jobs


