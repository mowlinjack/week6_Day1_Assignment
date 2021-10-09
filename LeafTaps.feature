Feature: Leaftaps application features 

Background:
Given Launch chrome browser



Scenario: Create lead
 
Given Launch URL 'http://leaftaps.com/opentaps/control/main'
Given Enter usernam and Password 'demosalesmanager' 'crmsfa'
When Click on signon 
Then Home page should be displayed
And Click on CRM/SFA link
And Click on Leads
And Click Create lead
And Enter 'companyNAme' 'companyFirstName' 'companyLAstName' 'phoneNumber' input values for create a lead
When click on submit button
Then quit



Scenario Outline: Duplicate lead
Given Launch URL <url>
Given Enter usernam and Password <uname> <pwd>
When Click on signon 
Then Home page should be displayed
And Click on CRM/SFA link
And Click on Leads
And Click on Find leades in leads
When Click on phone text field and enter '99'
And Click on find leads 
When Click on first item in the list
And Click on Duplicate lead
And Click on Submit
Then quit

Examples:
|url|uname|pwd|
|'http://leaftaps.com/opentaps/control/main'|'demosalesmanager'|'crmsfa'|


Scenario Outline: Edit lead
Given Launch URL <url>
Given Enter usernam and Password <uname> <pwd>
When Click on signon 
Then Home page should be displayed
And Click on CRM/SFA link
And Click on Leads
And Click on Find leades in leads
When Click on phone text field and enter '99'
And Click on find leads 
When Click on first item in the list
And Click on Edit link
And Enter Updated company name <upCmpnyName>
And Click on Submit
Then quit

Examples:
|url|uname|pwd|upCmpnyName|
|'http://leaftaps.com/opentaps/control/main'|'demosalesmanager'|'crmsfa'|'tcs'|



Scenario: Merge lead
Given Launch URL 'http://leaftaps.com/opentaps/control/main'
Given Enter usernam and Password 'demosalesmanager' 'crmsfa'
When Click on signon 
Then Home page should be displayed
And Click on CRM/SFA link
And Click on Leads
And Click on Merge Lead
And Click on look up
And Enter FirstNAme 'gopi' 
And Click on find leads
And I Get lead id
And clickon lead ID
And Enter FirstNAme 'babu'
And Click on find leads
And I click merge lead
And Click on Find leades in leads
And Enter fetched find lead
And I click on find leads 
Then check Merged lead 
Then quit




Scenario: Delete lead
Given Launch URL 'http://leaftaps.com/opentaps/control/main'
Given Enter usernam and Password 'demosalesmanager' 'crmsfa'
When Click on signon 
Then Home page should be displayed
And Click on CRM/SFA link
And Click on Leads
And Click on Find leades in leads
When Click on phone text field and enter '99'
And Click on find leads 
And Get LeadID there
And Click Delete
And Click on Find leades in leads
And Enter fetched find lead
And I click on find leads
Then Check deleted lead display
Then quit 




 

 



















