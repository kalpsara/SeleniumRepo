Feature: Functionality of Duplicate Lead Module

  Scenario Outline: Duplicate Lead scenario
    Given Launch the browser
   	Given Load the url
    Given Enter the Username as 'demoSalesManager'
   	And Enter the Password as 'crmsfa'
    When Click on the Login button
 	  Then WelcomePage is displayed
    When Click on CRMSFA link
    When Click on Leads link
    When Click on Find Lead link
    When Click on Lead List
    When click on Duplicate lead
    Then ViewLead page is displayed