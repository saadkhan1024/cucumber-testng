Feature: Login Functionality for OpenCart E-commerce Website

  As a user of the OpenCart website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the OpenCart login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid "saadkhan@gmail.com" and "welcome123"
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered an invalid "<email>" and "<password>"
    When I click on the login button
    Then I should see a error message indicating "<errorMessage>"

    Examples:
      | email             | password        | errorMessage                                          |
      | invalid@email.com | invalidPassword | Warning: No match for E-Mail Address and/or Password. |
      | valid@email.com   | invalidPassword | Warning: No match for E-Mail Address and/or Password. |
      | invalid@email.com | validPassword | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to the forgotten password page
    When I click on the forgotten password link
    Then I should be redirected to the password reset page