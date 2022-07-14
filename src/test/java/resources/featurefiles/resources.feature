@Regression
Feature: Resources Test
  As user I want to verify 'Connect with the world’s financial markets' text into lseg website

  Scenario: User should navigate to resources page successfully
    Given I am on homepage
    And I click on accept cookies
    When I mouse hover and click in resources tab
    Then I should able to verify text