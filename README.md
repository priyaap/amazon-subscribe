**Amazon Subscribe & Save**

This project covers following 3 test cases for Amazon Subscribe&Save Feature

		Test Case #1: Verify that user Logs in successfully to Amazon.com with valid login id and password
    			Given user visits amazon home page
    			When user logs in with valid login and password
    			Then user logs in sucessfully

		Test Case #2: Verify that user lands on Amazon Subscribe & Save page successfully
    			Given User clicks on account and lists dropdown
    			When user cicks on subscribe and save link
    			And user clicks on subscribe button
    			Then user is on subscribe and save home page 
    
    
		Test Case #3: Verify that user can search for a product and subscribes to it successfully using desired quantity and frequency
    			Given User search a product on the subscribe and save page
    			When when user clicks on the result link for the product
    			Then user subscribes to the product choosing quantiy "<quantity>" with frequency <frequency>


To Run this Framework Successfully, please follow the 2 step process below:


1. Please enter valid user id and password for Amazon.com at the following location: src/test/java/projectObjectRepo/SignInPage.java
as the following two string elements:
	public static String loginIdValue="";
	public static String passwordValue="";

2. Please run testrunner class from the following location: src/test/java/org/steps/com/TestRunner.java
