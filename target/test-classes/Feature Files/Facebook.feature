Feature: To validate the Facebook login
Scenario: Validate with valid UserName and valid Password
Given launch the browser Chrome
When load the URL and maximize the page
And locate the Username box and send the Valid value
	|name|12345|aswer|
	|name:|Sundharam|qwerty|
	|Name::|JeganSundharam||
And  locate the Password box and send the Valid Value
 	|pass|Jegan@123|
 	|pass:|Sundharam@123|
 	|pass::|JeganSundharam@123|
And click on the Login button
Then Invalid Credentials page is visible



 