Feature: User should be able to login

  Background: user tries to login
    Given User is on login page
    When user enters credentials
    Then user is able to login

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
