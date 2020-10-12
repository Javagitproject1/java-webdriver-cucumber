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

