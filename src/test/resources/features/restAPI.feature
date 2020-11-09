@rest
  Feature: Suit of REST API automation tests for Careers page

    @rest1
    Scenario: REST API Position CRUD
      Given I login via REST as "recruiter"
      When I create via REST "automation" position
      Then I verify via REST new "automation" position is in the list
      When I update via REST "automation" position
      Then I verify via REST new "automation" position is updated
      When I delete via REST new position
      Then I verify via REST new position is deleted

    @rest2
    Scenario: REST API Candidates CRUD
      Given I login via REST as "recruiter"
      When I create via REST "sdet" candidate
      When I add via REST "txt" resume to the candidate
      Then I verify via REST "txt" resume has been added
      Then I verify via REST new "sdet" candidate is in the list
      When I update via REST "sdet" candidate
      Then I verify via REST new "sdet" candidate is updated
      When I delete via REST new candidate
      Then I verify via REST new candidate is deleted


