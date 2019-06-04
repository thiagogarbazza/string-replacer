Feature: replacer

  Description for replacer.

  Background:
    Given
    And
    And
    And

  Scenario: 01. any name
    Given that I have the following template:
      """
      ${{date-token-example | arg='value'}}
      """
    When to ask what tokens are in the text?
    Then I will receive the following text:
      """

      """

