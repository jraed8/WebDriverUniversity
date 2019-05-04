Feature: Contact Us Form

Scenario: Submit valid data contact us form
	Given I access webdriveruniversity contact us form
	When I enter a valid first name
	When I enter a valid last name
	|	woods	|	jackson	|	jones|
		And I enter a valid email address
		And I enter comments
	| comment 1 | comment 2 | comment 3|
	When I click on the submit button
	Then the information should successfully be submitted via the contact us form
	
	
