@market
Feature: Marketing test suite

  @market1
  Scenario: getDriver exercise
    Given I go to "https:www.google.com" page
    And I print page details
    And I go to "https:www.yahoo.com" page
    And I go back and forward, then refresh the page
    And I change resolution to "desktop"

  @market2
  Scenario: Fill in required fields, submit the form and validate the data
    Given I go to "https://skryabin.com/market/quote.html" page
    When I fill in required fields
    And I verify email field behavior
    And I accept agreement with xpath "//*[@id='thirdPartyButton']"
      #And I dismiss agreement with xpat "//*[@id='thirdPartyButton']"
    Then I submit the page
    And I verify that fields values are recorded correctly







