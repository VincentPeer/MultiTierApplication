Feature: Application produits

  Scenario: Request a non exsting ville
    Given I create a new produt
    When I create with an unexsit ville
    Then I receive a 404 status code

  Scenario: Description trop long
    Given I create a new produt
    When I create with a description too long
    Then I receive a 400 status code

  Scenario: Descrption non fournie
    Given I create a new produt
    When I create without a description
    Then I receive a 400 status code

  Scenario: Poids trop lourd
    Given I create a new produt
    When I create with a poids too heavy
    Then I receive a 400 status code

