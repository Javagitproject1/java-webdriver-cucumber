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
    When I fill in required fields for "admin"
    And I verify email field behavior for "admin"
    And I "accept" agreement
    Then I submit the page
    And I verify that fields values are recorded correctly for "admin"


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
    And I define "2" quantity
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

  @market11
  Scenario: Unit Converter
    Given I open url "https://www.unitconverters.net/"
    When I click on "Length"
    And I convert from "Mile" to "Kilometer"
    Then I enter value "50" and verify result is "80.4"

  @market12
  Scenario: Verify calculator result
    Given I open url "https://www.calculator.net/"
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    And I enter "25000" price, "60" months, "4.5" interest, "5000" down payment, "0" trade-in, "California" state, "7" percent tax, "300" fees
    And I calculate
    Then I verify monthly pay is "$372.86"

  @market13
  Scenario: Every door direct mail
    Given I open url "https://www.usps.com/"
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I click "Show Table" on the map
    When I click "Select All" on the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order

















