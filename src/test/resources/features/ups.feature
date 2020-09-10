@ups
Feature: UPS test suit
  Background: I open UPS web page
    Given I open url "https://www.ups.com/us/en/Home.page"


  @ups1
  Scenario: Validate Create Shipment Functionality
    And I go to Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment form from "contacts"
    And I submit the shipment form
    Then I verify origin shipment fields submitted according to "contacts"
    And I cancel the shipment form
    Then I verify shipment form is reset

  @ups2
  Scenario: UPS end to end full
    And I go to Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment form from "contacts"
    And I submit the shipment form
    Then I verify origin shipment fields submitted according to "contacts"
    When I fill out destination shipment fields from "user"
    When I submit the shipment form
    Then I set packaging type "UPS Express Box - Small" and weight "2"
    When I submit the shipment form
    Then I verify total charges appear
    And I select cheapest delivery option
    And I submit the shipment form
    And I set description "Books" and check Saturday Delivery type
    Then I verify total charges changed
    When I submit the shipment form
    And I select Paypal payment type
    And I submit the shipment form
    Then I review all recorded details from "contacts" and to "user" on the review page
    And I cancel the shipment form
    Then I verify shipment form is reset

