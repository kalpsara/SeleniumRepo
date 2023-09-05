
Feature:  Functionality of Edit Lead Module
  
  Scenario Outline: Edit Lead scenario outline
   Given Launch the browser
   Given Load the url
   Given Enter the Username as 'demoSalesManager'
   And Enter the Password as 'crmsfa'
   When Click on the Login button
   Then WelcomePage is displayed
   When Click on CRMSFA link
   When Click on Leads link
    When Click on Find Lead link
    
  #Given Enter the Lead id as <leadId>
    Given Enter the first name as <firstName>
    When Click on Find Lead button
    When Click on Lead List
     When Click on Edit link
     Then Clear description 
    Then Edit description as <description>
    Then Update lead

    Examples: 
      | leadId  | firstName | description  |
      | '15566' | 'd'  | 'eddit1' |
     	| '14169' | 's'  | 'edit2' |
