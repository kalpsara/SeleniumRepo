Feature: Functionality of Create Lead Module

  Scenario Outline: Create Lead with positive scenario
    Given Launch the browser
   	Given Load the url
    Given Enter the Username as 'demoSalesManager'
   	And Enter the Password as 'crmsfa'
    When Click on the Login button
 	  Then WelcomePage is displayed
    When Click on CRMSFA link
    When Click on Leads link
    When Click on CreateLead link
    When Enter the companyName as <companyName>
    When Enter the firstName as <firstName>
    When Enter the lastName as <lastName>
    When Click on Create button
    Then ViewLead page is displayed

    Examples: 
      |companyName|firstName|lastName|
      |'Capgemini' |'kalpana'|'venkatraman'|
      |'wipro'|'saravana' | 'kumar'|
