
Feature:  Functionality of Merge Lead Module
  
  Scenario Outline: Merge Lead scenario outline
   Given Launch the browser
   Given Load the url
   Given Enter the Username as 'demoSalesManager'
   And Enter the Password as 'crmsfa'
   When Click on the Login button
   Then WelcomePage is displayed
   When Click on CRMSFA link
   When Click on Leads link
   When Click on Merge Lead Link
   When From lead and To lead is selected
   When Click on Merge button
   Then ViewLead page is displayed
   Then Verify merged lead