Feature: User should be able to login

  Background: user tries to login
    Given User is on login page

  @latest
  Scenario Outline: user enters credentials to login
    When user enters <username> and <password>
    Then user is able to login

    Examples:
      | username                 | password  |
      | rohitpachauri2@gmail.com | rmv123*#R |

  Scenario: user searches for samsung galaxy m21
    Given user is logged in
    When user enters the text and clicks on search button
    And user gets the list of all the mobiles phones
    Then user adds the item to cart

  @smoke
  Scenario: user is checking elements in cart
    Given cart is not empty
    When user clicks on show in cart
    Then user enters address credentials

  Scenario: user is able to gift a gift card
    Given User is on login page for gift page
    When user clicks on gift card page
    Then user is navigated to gift card page

  @new
  Scenario: user clicks on laptops section
    Given user is on home page
    When user clicks o laptops section and enters lenovo in search box
    Then gets all the lenovo laptops

  @latest
  Scenario: user checks the fashion deals
    Given user is logged in
    When user hovers on fashion and clicks on deals
    Then navigated to fashion deals page
