testcucumber


---
Homework 7
---

Задание:

Написать Feature для реализации поиска в поисковой системе Спутник

Создать сценарий поиска любого запроса в Спутник
Убедиться, что результаты поиска присутствуют на странице.

Реализовать с помощью Serenity в связке с Cucumber.

Решение:

Создал:
- ветку Serenity
- указал зависимости для запуска
- создал search.feature и описал в нем сценирий 
```java
Scenario: Finding something
  Given user on the spytnik home page
  When user input "cake"
  And user click search
  Then user found "Cake (группа) — Википедия"
```
- Создал HomePage и ResultPage для работы со страницами
- Создал SpytnikTest для обращения к страницам 
- Создал SearchTest для ссылки на сценарий search.feature
```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/testcucumber/search.feature")
```
