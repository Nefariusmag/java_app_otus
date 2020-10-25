Feature: yandex-translate

Scenario: Finding something
  Given I am on the Home page
  When I go to service translate and send sms to number "79164871362"
  Then I found message "Сообщение отправлено"
