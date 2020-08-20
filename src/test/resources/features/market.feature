@market
Feature: Marketing test suite

  @market1
  Scenario: getDriver exercise
    Given I go to "https:www.google.com" page
    And I print page details
    And I go to "https:www.yahoo.com" page
    And I go back and forward, then refresh the page
    And I change resolution to "desktop"
    And I print logs to console

  @market2
  Scenario: Fill in required fields, submit the form and validate the data
    Given I go to "https://skryabin.com/market/quote.html" page
    When I fill in required fields
    And I verify email field behavior
    And I accept agreement with xpath "//*[@id='thirdPartyButton']"
      #And I dismiss agreement with xpath "//*[@id='thirdPartyButton']"
    Then I submit the page
    And I verify that fields values are recorded correctly

    @market3
    Scenario: Coding challenges
      Given I create my own method

    @market4
    Scenario: Coding task 1
      Given I swap 2 and 4 element in the array

    @market5
    Scenario: Coding task 2
      Given I have entered number 12

    @market6
    Scenario: Validate zip code
      Given I open url "https://www.usps.com/"
      When I navigate to Look Up a ZIP Code page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exist in the result















