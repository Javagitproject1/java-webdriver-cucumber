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


  @market6
  Scenario: Validate zip code
    Given I open url "https://www.usps.com/"
    When I navigate to Look Up a ZIP Code page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exist in the result

  @market7
  Scenario: Calculate price
    Given I open url "https://www.usps.com/"
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define 2 quantity
    Then I calculate the price and validate cost is "$2.40"

  @market8
  Scenario: Verify location
    Given I open url "https://www.usps.com/"
    When I perform "Free Boxes" search
    And I set "Mail & Ship" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now " button
    Then I validate that Sign In is required

  @market9
  Scenario: Quadcopters delivery
    Given I open url "https://www.usps.com/"
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

  @market10
  Scenario: Phone number of the nearest Mail Pickup
    Given I open url "https://www.usps.com/"
    When I navigate to Find a USPS Location page
    And I filter by "Post Offices" location types, "Pickup Services" services, "Accountable Mail" available services
    And I provide data as "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
    Then I verify phone number is "800-275-8777"
















