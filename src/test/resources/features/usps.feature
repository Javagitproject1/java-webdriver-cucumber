@usps
  Feature: USPS test suit
    Background: I open USPS url first
      Given I open url "https://www.usps.com/"

    @usps1
    Scenario: Validate zip code
      When I navigate to Look Up a ZIP Code page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exist in the result

    @usps2
    Scenario: Calculate price
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.40"

    @usps3
    Scenario: Verify location for Free Boxes
      When I perform "Free Boxes" search
      And I set "Mail & Ship" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now " button
      Then I validate that Sign In is required

    @usps4
    Scenario: Quadcopters delivery
      When I go to "Help" tab
      And I perform "Quadcopters delivery" help search
      Then I verify that no results of "Quadcopters delivery" available in help search

    @usps5
    Scenario: Phone number of the nearest Mail Pickup
      When I navigate to Find a USPS Location page
      And I filter by "Post Offices" location types, "Pickup Services" services, "Accountable Mail" available services
      And I provide data as "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
      Then I verify phone number is "800-275-8777"

    @usps6
    Scenario: Every door direct mail
      When I go to "Every Door Direct Mail" under "Business"
      And I search for "4970 El Camino Real, Los Altos, CA 94022"
      And I click "Show Table" on the map
      When I click "Select All" on the table
      And I close modal window
      Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order

    @usps7
    Scenario: Wrong store id does not match
      When I navigate to "Postal Store" tab
      And I enter "12345" into store search
      Then I search and validate no products found

    @usps8
    Scenario: One item found
      When I go to "Stamps" under "Postal Store"
      And choose "Priority Mail" option under filter "Mail Service"
      Then I verify 1 items found

    @usps9
    Scenario: Verify color
      When I go to "Stamps" under "Postal Store"
      When I unselect Stamps checkbox
      And select Vertical stamp Shape
      And I click Blue color
      Then I verify "Blue" and "Vertical" filters
      Then I verify 12 items found
      And I verify that items below 12.00 dollars exists

    @usps10
    Scenario: Verify location for Passport
      When I perform "Passports" search
      And I select "Passport Application" in results
      And I click "Schedule an Appointment" button
      And verify "Passport Renewal" service exists

    @usps11
    Scenario: PO Box
      When I go to "PO Boxes" under "Track & Manage"
      And I reserve new PO box for "94022"
      Then I verify that "Los Altos — Post Office™" present
      And I verify that "Size 5-XL" PO Box is available in "Los Altos — Post Office™"