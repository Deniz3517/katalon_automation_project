Feature: User Login

  Scenario: Logging in with valid credentials
    Given The user navigates to the login page
    When The user logs in with "denz" and the correct password
    Then The user is redirected to the homepage
