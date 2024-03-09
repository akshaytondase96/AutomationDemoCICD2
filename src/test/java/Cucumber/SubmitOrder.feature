@tag
Feature: Purchase the ordern from E-commerce website.
  I want to use this template for my feature file

Background:
Given I landed on E-commerce page.
  Scenario Outline: Positive test of submitting the order
    Given Logged in with Username <username> and password <password>
    When add product <productName> to cart
    And checkout <productName> and submit order
    Then verify the message "THANKYOU FOR THE ORDER." is displayed on confirmation page

 Examples: 
      | username                       | password                   | productName       |
      | Ajinkya@gmail.com       |Ajinkya5572               | ZARA COAT 3        |
      
