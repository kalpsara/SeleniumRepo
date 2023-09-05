Feature: Functionality of Delete Lead Module

  Scenario Outline: Delete Lead scenario outline
    Given Launch the browser
    Given Load the url
    Given Enter the Username as 'demoSalesManager'
    And Enter the Password as 'crmsfa'
    When Click on the Login button
    Then WelcomePage is displayed
    When Click on CRMSFA link
    When Click on Leads link
    When Click on Find Lead link
    When Click on Phone Tab
    Given Enter the Phone number as <phoneNumber>
    When Click on Find Lead button
    Then Click on Delete button

    Examples: 
      | phoneNumber |
      | '99'        |
