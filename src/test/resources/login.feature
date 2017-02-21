Feature: Authentication

  Scenario: Sign In to Github
    Given the Github Login page
    When logging in as an user
    Then the home page navigation is available