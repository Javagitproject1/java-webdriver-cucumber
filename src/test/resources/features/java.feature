@java
Feature: My First Java Feature

  @java1
  Scenario: Create Java Step
    Given I say "Hello! My name is Sasha"


  @java2
  Scenario: Declare variables
    Given I say firstName "John"
    And I say lastName "Boldwin"
    And I say favoriteColor "Green"
    Then I concatenate "New York" with "San Francisco"

  @java3
  Scenario: Exercise with numbers
    Given I have num1 12 and num2 10

  @java4
  Scenario: Exercise with bolleans (compare colors)
    Given I like "Red" color

  @java5
  Scenario: Exercise with Conditions
    Given I print url for "google" page
    And I print if number -10 is positive
    And I print "3" th day of the week
    And I print "7" th day of the week using switch

    
  @java6
  Scenario: Exercise with conditions using break
    Given I print url for "bing" page using break

  @java7
  Scenario: Exercise with arrays
    Given I have grocery list




























