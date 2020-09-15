@quote
    Feature: Quote OOP
      Background: I open quote page
        Given I open "quote" page

      @quote1
      Scenario: Fill in required fields, submit the form and validate the data
        When I fill out required fields for "user" oop
        Then I submit the form
        And I verify results for "user"

      @quote2
      Scenario: Required and optional fields for quote oop
        When I fill out required fields for "user" oop
        When I fill out optional fields for "user" oop
        And I submit the form
        Then I verify results for "user"
        Then I verify optional fields for "user" oop

      @quote3
      Scenario: Required fields test oop
        And I submit the form
        Then I see "username" error message "This field is required."
        And I see "email" error message "This field is required."
        And I see "password" error message "This field is required."
        And I see "name" error message "This field is required."
        And I see "agreedToPrivacyPolicy" error message "- Must check!"

      @quote4
      Scenario: Market username test oop
        When I fill out "username" field with "a"
        And I submit the form
        Then I see "username" error message "Please enter at least 2 characters."
        Then I clear field "username"
        When I fill out "username" field with "ab"
        Then I don't see "username" error message

      @quote5
      Scenario: Market email test oop
        When I fill out "email" field with "john"
        And I submit the form
        Then I see "email" error message "Please enter a valid email address."
        When I fill out "email" field with "john@example.com"
        Then I don't see "email" error message

      @quote6
      Scenario: Market passwords test oop
        When I fill out "password" field with "1234"
        And I submit the form
        Then I see "password" error message "Please enter at least 5 characters."
        Then I clear field "password"
        When I fill out "password" field with "12345"
        Then I don't see "password" error message
        When I fill out "confirmPassword" field with "1234"
        And I submit the form
        Then I see "confirmPassword" error message "Please enter at least 5 characters."
        Then I clear field "confirmPassword"
        When I fill out "confirmPassword" field with "54321"
        Then I see "confirmPassword" error message "Passwords do not match!"
        Then I clear field "confirmPassword"
        When I fill out "confirmPassword" field with "12345"
        Then I don't see "confirmPassword" error message

      @quote7
      Scenario: Market name test oop
        When I fill out name field with first name "John" and last name "Doe"
        Then I verify "name" field value "John Doe"
        When I fill out name field with first name "John", middle name "Richard", last name "Doe"
        Then I verify "name" field value "John Richard Doe"