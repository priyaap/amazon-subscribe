#Author: pradhanpriya@gmail.com

@AmazonSaveSubscribe
Feature: Amazon Subscribe and Save
  This feature will validate the subscribe and save feature and various scenarios realted

  Scenario: Login to Amazon with valid login id and password
    Given user visits amazon home page
    When user logs in with valid login and password
    Then user logs in sucessfully

   Scenario: User vistis amazon subscribe and save page
    Given User clicks on account and lists dropdown
    When user cicks on subscribe and save link
    And user clicks on subscribe button
    Then user is on subscribe and save home page 
    
    
    Scenario: User search and subscribes to a product
    Given User search a product on the subscribe and save page
    When when user clicks on the result link for the product
    Then user subscribes to the product choosing quantiy "<quantity>" with frequency <frequency>
     Examples:
    |quantity|frequency|
    |3			 |4				|