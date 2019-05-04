Feature: Products

Scenario: Validate promo code alert is visible 
					when clicking on the special offers link
	Given User navigates to url
	When User clicks on special offers link 
	And User clicks on Proceed button
	Then User should be presented with a promo alert

