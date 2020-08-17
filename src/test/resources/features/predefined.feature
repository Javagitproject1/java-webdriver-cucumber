@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefind steps for Yahoo!
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@id='header-search-input']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@id='header-search-input']"
    Then I click on element with xpath "//button[@id='header-desktop-search-button']"
    Then I wait for element with xpath "//div[@id='main']" to be present
    Then element with xpath "//div[@id='main']" should contain text "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//*[(text()='Portnov Computer School - Software Testing and Software QA ...')])[1]"
    Then I wait for 3 sec


  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element using JavaScript with xpath "//input[@id='sb_form_go']"
    Then I wait for element with xpath "//*[@id='b_results']" to be present
    Then element with xpath "//*[@id='b_results']" should contain text "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//*[text()='Portnov Computer School'])[1]"
    Then I wait for 3 sec


  @predefined4
  Scenario: Predefined steps for Giburu
    Given I open url "https://gibiru.com/"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//*[text()='Portnov Computer School'])[1]"
    Then I wait for 3 sec

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@name='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//*[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//a/b[contains(text(),'Portnov')])[1]"
    Then I wait for 3 sec

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title as "Swisscows the alternative, data secure search engine."
    Then element with xpath "//input[@class='input-search']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@class='input-search']"
    Then I click on element using JavaScript with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//*[text()='Portnov Computer School'])[1]"
    Then I wait for 3 sec

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//span/b[contains(text(),'Portnov')])[1]"
    Then I wait for 3 sec

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title as "Startpage.com - The world's most private search engine"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//button[@class='search-form-home__form__button']"
    Then I wait for element with xpath "//*[@class='mainline-results--default']" to be present
      #Then I should see page title as "Portnov Computer School: Software Testing and Software QA ..."
    Then I click on element using JavaScript with xpath "(//*[contains(text(),'Portnov Computer School')])[1]"
    Then I wait for 3 sec

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.ru/"
    Then I should see page title as "Яндекс"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@id='text']"
    Then I click on element using JavaScript with xpath "(//*[@class='button__text'])[2]"
    Then I wait for element with xpath "//ul[@id='search-result']" to be present
    Then I should see page title contains "Portnov Computer School"
    Then I click on element using JavaScript with xpath "//*[contains(text(),'Software Testing')]"
    Then I wait for 3 sec

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title as "Boardreader - Forum Search Engine"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@id='title-query']"
    Then I click on element using JavaScript with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//*[@class='mdl-list']" to be present
      #Then I should see page title contains "Portnov Computer School"
      #Then I click on element using JavaScript with xpath "(//*[contains(text(),'Portnov Computer School')])[1]"
    Then I wait for 3 sec

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title as "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//*[@class='mainline-results']" to be present
    Then I should see page title contains "Portnov Computer School"
    Then I click on element using JavaScript with xpath "(//a[contains(text(),'Portnov Computer School')])[1]"
    Then I wait for 3 sec

  @predefined12
  Scenario: Validate Responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1268 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 800 and 163
    Then element with xpath "//*[@id='currentDate']" should be displayed
    And I resize window to 320 and 568
    Then element with xpath "//*[@id='currentTime']" should not be displayed

  @predefined13
  Scenario: Fill out and validate Username field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "E" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//input[@name='email']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    Then I type "I" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//input[@name='email']"
    Then element with xpath "//*[@id='username-error']" should not be displayed

  @predefined14
  Scenario: Validate Email address field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "E" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='email-error']" should be displayed
    Then I type "john@me.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='email-error']" should not be displayed

  @predefined15
  Scenario: Validate Password field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "Pass" into element with xpath "//input[@name='password']"
    And I click on element with xpath "//input[@name='confirmPassword']"
    Then element with xpath "//*[@id='password-error']" should be displayed
    And element with xpath "//*[@name='confirmPassword']" should be enabled
    Then I clear element with xpath "//input[@name='password']"
    And element with xpath "//*[@name='confirmPassword']" should be disabled
    Then I type "Password" into element with xpath "//input[@name='password']"
    And I click on element with xpath "//input[@name='confirmPassword']"
    Then element with xpath "//*[@id='password-error']" should not be displayed

  @predefined16
  Scenario: Validate Name field bahavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='name']"
    Then element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
    Then I type "Tom" into element with xpath "//input[@id='firstName']"
    And I type "A" into element with xpath "//input[@id='middleName']"
    And I type "Muller" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "(//span[@class='ui-button-text'])[2]"
    Then element with xpath "//*[@id='name']" should have attribute "value" as "Tom A Muller"
    And I wait for 2 sec

  @predefined17
  Scenario: Validate check box for Privacy Policy
    Given I open url "https://skryabin.com/market/quote.html"
    Then I type "testuser1" into element with xpath "//input[@name='username']"
    * I type "testuser1@school.com" into element with xpath "//input[@name='email']"
    * I type "Password" into element with xpath "//input[@name='password']"
    * I type "Password" into element with xpath "//input[@name='confirmPassword']"
    Then I click on element with xpath "//*[@id='name']"
    And element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
    Then I type "Tom" into element with xpath "//input[@id='firstName']"
    * I type "A" into element with xpath "//input[@id='middleName']"
    * I type "Muller" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "(//span[@class='ui-button-text'])[2]"
    And element with xpath "//*[@id='name']" should have attribute "value" as "Tom A Muller"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//label[@class='required checkbox_radio']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed
    Then I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 3 sec

  @predefined18
  Scenario: Fill out all forms on Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    Then I type "testuser1" into element with xpath "//input[@name='username']"
    * I type "testuser1@school.com" into element with xpath "//input[@name='email']"
    * I type "Password" into element with xpath "//input[@name='password']"
    * I type "Password" into element with xpath "//input[@name='confirmPassword']"
    Then I click on element with xpath "//*[@id='name']"
    And element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
    Then I type "Tom" into element with xpath "//input[@id='firstName']"
    * I type "A" into element with xpath "//input[@id='middleName']"
    * I type "Muller" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "(//span[@class='ui-button-text'])[2]"
    * I type "+1 (212) 336-1440" into element with xpath "//input[@name='phone']"
    When I click on element with xpath "//input[@id='dateOfBirth']"
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    * I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='6']"
    * I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1988']"
    * I click on element with xpath "//a[@class='ui-state-default'][text()='5']"
    * I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Germany']"
    * I click on element with xpath "//label[@class='checkbox_radio']/input[@value='male']"
    * I click on element with xpath "//label[@class='checkbox_radio']/input[@name='allowedToContact']"
    * I type "767 5th Ave New York, NY, 10153, United States" into element with xpath "//*[@id='address']"
    * I click on element with xpath "//select[@name='carMake']/option[@value='BMW']"
    * I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    Then I click on element with xpath "//label[@class='required checkbox_radio']"
    Then I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 3 sec

  @predefined19
  Scenario: Submit the form and validate the data
    Given I open url "https://skryabin.com/market/quote.html"
    Then I type "testuser1" into element with xpath "//input[@name='username']"
    * I type "testuser1@school.com" into element with xpath "//input[@name='email']"
    * I type "Password" into element with xpath "//input[@name='password']"
    * I type "Password" into element with xpath "//input[@name='confirmPassword']"
    Then I click on element with xpath "//*[@id='name']"
    And element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
    Then I type "Tom" into element with xpath "//input[@id='firstName']"
    * I type "A" into element with xpath "//input[@id='middleName']"
    * I type "Muller" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "(//span[@class='ui-button-text'])[2]"
    * I type "2123361440" into element with xpath "//input[@name='phone']"
    When I click on element with xpath "//input[@id='dateOfBirth']"
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    * I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='6']"
    * I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1988']"
    * I click on element with xpath "//a[@class='ui-state-default'][text()='5']"
    * I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Germany']"
    * I click on element with xpath "//label[@class='checkbox_radio']/input[@value='male']"
    * I click on element with xpath "//label[@class='checkbox_radio']/input[@name='allowedToContact']"
    * I type "767 5th Ave New York, NY, 10153, United States" into element with xpath "//*[@id='address']"
    * I click on element with xpath "//select[@name='carMake']/option[@value='BMW']"
    * I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    Then I click on element with xpath "//label[@class='required checkbox_radio']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should be displayed
    Then element with xpath "//b[@name='gender']" should have text as "male"
    * element with xpath "//b[@name='username']" should have text as "testuser1"
    * element with xpath "//b[@name='firstName']" should have text as "Tom"
    * element with xpath "//b[@name='countryOfOrigin']" should have text as "Germany"
    * element with xpath "//b[@name='carMake']" should have text as "BMW"
    * element with xpath "//b[@name='email']" should have text as "testuser1@school.com"
    * element with xpath "//b[@name='lastName']" should have text as "Muller"
    * element with xpath "//b[@name='allowedToContact']" should have text as "true"
    * element with xpath "//b[@name='phone']" should have text as "2123361440"
    * element with xpath "//b[@name='password']" should not have text as "Password"
    * element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"
    * element with xpath "//b[@name='thirdPartyAgreement']" should have text as "accepted"
    * element with xpath "//b[@name='address']" should have text as "767 5th Ave New York, NY, 10153, United States"
    * element with xpath "//b[@name='dateOfBirth']" should have text as "07/05/1988"
    * element with xpath "//b[@name='name']" should have text as "Tom A Muller"
    * element with xpath "//b[@name='middleName']" should have text as "A"
    And I wait for 3 sec

  @predefined20
  Scenario: My First Java feature
    Given I open url "https://www.ebay.com/"
    Then element with xpath "//input[@id='gh-ac']" should be displayed
    Then I click on element with xpath "//input[@id='gh-ac']"
    Then I type "Iphone 11" into element with xpath "//input[@id='gh-ac']"
    Then I click on element using JavaScript with xpath "//input[@id='gh-btn']"
    Then I wait for 3 sec






      

