Feature: spytnik

Scenario: Finding something
  Given user on the spytnik home page
  When user input "cake"
  And user click search
  Then user found "Cake (группа) — Википедия"
