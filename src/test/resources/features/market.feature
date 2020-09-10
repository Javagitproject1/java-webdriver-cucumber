@market
  Feature: Marketing test suite

    @market1
    Scenario Outline: getDriver exercise
      Given I go to "<Page1>" page
      And I print page details
      And I go to "<Page2>" page
      And I go back and forward, then refresh the page
      And I change resolution to "<Size1>"
      And I change resolution to "<Size2>"
      Then I print logs to console

      Examples:
        | Page1                 | Page2                  | Size1   | Size2   |
        | https:www.google.com  | https:www.yahoo.com    | iphone  | desktop |
        | https:www.yahoo.com   | https://duckduckgo.com | desktop | ipad    |
        | https://www.bing.com/ | https://yandex.com/    | iphone  | ipad    |

    @market2
    Scenario: Fill in required fields, submit the form and validate the data
      Given I go to "https://skryabin.com/market/quote.html" page
      When I fill in required fields for "admin"
      And I verify email field behavior for "admin"
      And I "accept" agreement
      Then I submit the page
      And I verify that fields values are recorded correctly for "admin"

    @market3
    Scenario Outline: Unit Converter
      Given I open url "https://www.unitconverters.net/"
      When I click on "<Unit>"
      And I convert from "<From>" to "<To>"
      Then I enter value "<Value Original>" and verify result is "<Value Converted>"
      Examples:
        | Unit        | From       | To        | Value Original | Value Converted |
        | Length      | Mile       | Kilometer | 50             | 80.4675         |
        | Temperature | Fahrenheit | Celsius   | 54             | 12.2            |
        | Weight      | Pound      | Kilogram  | 170            | 77              |


    @market4
    Scenario: Verify calculator result
      Given I open url "https://www.calculator.net/"
      When I navigate to "Auto Loan Calculator"
      And I clear all calculator fields
      And I calculate
      Then I verify "Please provide a positive auto price." calculator error
      And I enter "25000" price, "60" months, "4.5" interest, "5000" down payment, "0" trade-in, "California" state, "7" percent tax, "300" fees
      And I calculate
      Then I verify monthly pay is "$372.86"


















