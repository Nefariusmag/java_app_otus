Feature: yandex

Scenario: Finding something
  Given I am on the Yandex Home page
  When I search "cake"
  Then I found "cake"
