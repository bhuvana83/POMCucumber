Feature: Application Login


Scenario Outline: positive login case
Given Initialize the chrome browser
And Navigate to "http://www.qaclickacademy.com/"
And click on login in home page
When user login with <username> and <password> and click login
Then user successfull login
And close all browsers

Examples:
|username		|password		|
|test			|1234			|
|sri			|feee			|



