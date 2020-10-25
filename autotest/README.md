Homework для `otus.ru` для курса `https://otus.ru/lessons/qa/` по автотестированию

---
Homework 16
---
REST + UI 

Домашнее задание:
Создать тест, отправляющий запрос на REST и проверяющий соответствие данных в UI
Воспользоваться API Переводчика
https://tech.yandex.ru/translate/doc/dg/reference/translate-docpage/
и проверить соответствие результата перевода на web странице ответу от REST API https://translate.yandex.ru, создав 1 автоматический тест.

Решение:


---
Homework 15
##Homework 15
---
Rest-Assured

Домашнее задание:
Создать два теста с использованием Rest-Assured фреймворка
 Зарегистрироваться на api.yandex.ru, получить API ключ.  
Прочитать документацию: https://tech.yandex.ru/dictionary/doc/dg/reference/lookup-docpage/  
Сделать два теста: 
1. тест на метод getLangs(),
2. тест на метод lookup(),
используя Rest-Assured.

Решение:
Rest-Assured для обращения и проверок использует следующую конструкцию:
```java
given().
when().
        get(URL).
then().
        statusCode(200).
        body("$", hasItem("ru-en"));
        body("text", equalTo("Шалом"));
```

`.body` позволдяет парсить ответ и находить в нем нужное

Для образенния к Яндекс словарю прочел доку:
1. https://tech.yandex.ru/dictionary/doc/dg/reference/getLangs-docpage/
2. https://tech.yandex.ru/dictionary/doc/dg/reference/lookup-docpage/

##Homework 14
DataProvider

Задание:
- Добавить DataProvider к проекту и написать тест на поиск XSS уязвимостей приложения

Решение:
- Конструкция для записи переменных в массив:
```java
@DataProvider(name = "xsstest")
public Object[][] xssDataProvider(){
    return new Object[][] {{"San Diego", "Berlin"}};
}
```
- Чтобы забрать переменные из масива для запуска с ними теста добавляем в ``@Test` вот такое обозначение:
```java
@Test(dataProvider = "xssfalsetest")
public void test2(String xssFrom, String xssTo)
```
Чтобы не упало при вводе кривых данных обрабатываю исключение:
```java
try {
    fligtPage.From_to(from_to);
    System.out.println("Ввели неправильное значение и прошло");
} catch (AssertionError e) {
    System.out.println("Всё ок, лишнего не ввести");
}
```

---
Homework 11
---
Log4J
##Homework 9
JDI

- Реализовать тест на покупку авиабилета с использованием JDI

Решение:
- Создается сложная структура:
```
jdi
├── BaseTest.java
├── blazedemo
│   ├── JDIExsampleSite.java
│   ├── NavigationSite.java
│   └── page
│       ├── FinishPage.java
│       ├── FlightsPage.java
│       ├── PrivatePage.java
│       └── SelectPage.java
└── Homework9Test.java
```
где:
- `blazedemo.page` - страницы page
- `Homework9Test.java` - класс запускающий тест
- `BaseTest.java` - ссылка на JDIExsamlpeSite
```java
@BeforeSuite(alwaysRun = true)
public static void setUp(){
    WebSite.init(JDIExsampleSite.class);
}
```
- `blazedemo.JDIExsampleSite.java` - указания главное страницы и инициализация страниц page
```java
@JSite(value = "http://blazedemo.com/")

@JPage
public static SelectPage selectPage;
```
- `blazedemo.NavigationSite.java` - обращения к методам страниц и передача им переменных

##Homework 8
Задание:
Добавить логирование, запись видео, траффика, снятие скриншотов в свой проект

Решение:

#####Log4J

- Настраиваем зависимости Log4j:
```java
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```
- Создаем Listener через создание класса и наследуем из `ITestListener`: 
```java
public class TestListener implements ITestListener
```
- Вызываем log4j
```java
private Logger logger = Logger.getLogger((TestListener.class));
logger.info("Поехали!");
logger.error("Пичаль!!! " + result.getTestClass() + " " + result.getTestName());
```
- Создаем src/recources/log4j.properties
- Иногда требуется обозначение конфигурации:
```java
BasicConfigurator.configure();
```
- Чтобы выдавал развернутое сообщение об ошибке:
```java
StringWriter stringWriter = new StringWriter();
PrintWriter printWriter = new PrintWriter(stringWriter);
Throwable cause = result.getThrowable();
cause.printStackTrace(printWriter);
logger.error(stringWriter.getBuffer().toString());
```

#####Скриншоты

- Создаем метод:
```java
File scrFile = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
try {
    FileUtils.copyFile(scrFile, new File("target/screenshot/screenshot.png"));
} catch (IOException e) {
}
```
- Вызываем метод через:
```java
takeSrceenShot(WebDriverManager.getInstance());
```

#####Запись трафика

- При вызове драйвера передаем ему ряд настроек:
```java
DesiredCapabilities caps = DesiredCapabilities.chrome();
LoggingPreferences logs = new LoggingPreferences();
logs.enable(LogType.PERFORMANCE, Level.INFO);
caps.setCapability(CapabilityType.LOGGING_PREFS, logs);
driver = new ChromeDriver(caps);
```
- Оформляем цикл для запись информации в консоль 
```java
LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
for(LogEntry entry : logEntries) {
    System.out.println(entry.getLevel() + " " + entry.getMessage());
}
```

Главноей сложностью тут было, чтобы всегда использовался один и тот же вызываемый webdriver ,а не пытался каждый раз запускаться какой-то новый, тут отлично сработал синглтон.

---
Homework 8
---
Selenide

Задание:
Необходимо реализовать тест с использованием Selenide, Кейс:
1. Открыть страницу artlebedev.ru, 
2. Перейти на страницу Инвентарь,
3. Выбрать Полезные штуки "Матрица идей", 
4. Выполнить поиск любого запроса,
Проверить, что результаты поиска отображаются.

Решение:
- Создал: Сделал PageObject из страниц - HomePage, InventoryPage, MatrixPage
- Создал: Их вызывает тест - Homework8Test
- Для открытия страницы браузера использует конструкция:
```java
public static HomePage enterToHomePage() {
    open("https://www.artlebedev.ru/");
    return page(HomePage.class);
    }
```
- Для поиска элемента делаем:
`x("//button[@type=\"submit\"]");`
- Для работы с элементами перечисляем операции через точку:
```java
.setValue(String);
.click();
.should(text(String)); // Содержит текст
```

##Homework 7
Serenity + Cucumber

Задание:
1. Написать Feature для реализации поиска в поисковой системе Спутник
2. Создать сценарий поиска любого запроса в Спутник
3. Убедиться, что результаты поиска присутствуют на странице.
4. Реализовать с помощью Serenity в связке с Cucumber.

Решение:
- В репозитории - https://github.com/Nefariusmag/testcucumber/tree/Serenity

##Homework 6
Behavior Driven Development

Задание:
1. Установить Cucumber как новый проект,
2. Написать два любых сценария (features) в новом проекте и реализовать их,
3. Запустить Selenium Grid на локальной машине с 1 node,
4. Запустить сценарии с использованием mvn test -Dbrowser=remotewebdriver.

Дополнительное задание:
- Внедрить Cucumber в созданный ранее проект и реализовать feature для определения результатов поиска T-shirts предыдущего домашнего задания.

Решение:
- BDD в репозитории - https://github.com/Nefariusmag/testcucumber
- Создал: добавил selenium-server в lib
- Создал: запустил hun `java -jar selenium-server-standalone-3.12.0.jar -role hub`
- Создал: запустил ноду `java -jar selenium-server-standalone-3.12.0.jar -role node -hub http://127.0.0.1:4444/grid/register/ -port 5555`
- Создал: настроил в настройках webdriver позсожность подключения через RemoteDriver

##Homework 5
Разные браузеры

Задание:

- Добавить запуск теста через Internet Explorer/Edge/Safari
- Создать автоматический тест по следующему сценарию:
1. Открыть сайт http://automationpractice.com/index.php
2. Навести указатель мыши на Women
3. Дождаться появление меню c помощью ExpectedConditions
4. Выбрать в меню T-Shirts
5. Проверить, что результаты появились на странице

Задание нужно сделать на любом из четырех браузеров на выбор:
InternetExplorer,
Edge,
Opera,
Safari

Дополнительное задание:
- Сделать параметр запуска headless, по которому Google Chrome запускается в headless режиме
Рекомендации:
- Применить паттерн PageObject, вынести Menu в отдельный компонент

Решение:
- Создал: синглтон с методом с switch case для вызова нужного браузера (chrome, firefox, opera), опера - глючит
- Создал: HomePage c ожиданем элемента в течении 10 секунд, через ExpectedConditions вида `new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(optionValue));`
- Создал: Выывающией HomePage класс Homework5Test

Для запуска в скрытом режиме добавил для хрома `.addArguments("--headless");`

##Homework 4
Работа со свойствами элементов

Задание:

Сайт: blazedemo.com/login
Описать новый Page Object на страницу Login(если не реализован)
Навести указатель мыши на кнопку login
- Проверить, что размер кнопки не поменялся
- Проверить, что цвет кнопки в наведенном состоянии - rgba(37, 121, 169, 1)

Решение:
- Создал: LoginPage который находит кнопку "Login" по `"//button[@type='submit']"` и выполняет операцию сравнения через `assertEquals`
- Создал: Homework4Text который вызывает LoginPage, берет из него данные о кнопке и передает их вновь для сравнения LoginPage

##Homework 3
Page Object & Singleton

Задание:

1. Воспользоваться двумя паттернами на выбор (например, Page Object и Singleton)
2. Добавить maven surefire plugin и добавить тест в suite TestNG (осуществить запуск теста командой mvn test)
3. Проект должен находиться на GitHub/BitBucket
4. (не обязательное):
- Добавить библиотеку lombok к проекту,
- воспользоваться фильтрацией из JDK 8,
- добавить Profiles к maven,
- добавить дополнительный TestNG suite и запускать suite командой mvn test -Dsuite=suite_name

Решение:
- Создал WebDriverManager.java для предварительного определения WebDriver, потом на него в классах будем ссылаться (демонстрируем, что разобрался как-то в Singleton)
- Создал Homework3.java, который немного показывает Page Object, в части определения передаваемых переменных заранее.
- Создал testng.xml, testng-2.xml, testng-3.xml для управления какие классы будут запущены.
- В pom.xml настроил ссылку на эти .xml и параметризовал, чтобы вызывая через mvn можно было выбрать профиль используя команду:
`mvn test -Pthree`

##Homework 2
TestNG

Задание:

1) На странице результатов поиска показаны рейсы из/в город, которые были выбраны
2) На странице заполнения данных пассажира необходимо проверить
а. номер выбранного рейса, название авиакомпании, цена из результатов поиска рейса
б. конечную цену(Total price) которая считается по формуле Total price= Price + Arbitrary Fee and Taxes
3) Заполнить любыми данными поля
4) Покупка билета завершена(есть ID, Status, Amount , последние 4 цифры введенной карты и expiration date карты)

Также необходимо:
1. Добавить @After и @Before в тест
2. Установить implicit wait
3. Добавить Expected Conditions в тех местах, где они нужны

Необходимо использовать ТОЛЬКО xpath и/или css селекторы.
Сдача задания архивом или ссылкой на github

Решение:
- Используя поиск xpath и cssSelector нашел основыне элементы
```
WebElement findselect_1 = driver.findElement(By.xpath("//select[@name='fromPort']"));
WebElement find_button = driver.findElement(By.cssSelector("input[type='submit']"));
```
- Для проверки переменной на нужное содержимое понял, что ее необходимо привести к текстовому виду:
```
WebElement find_from_to = driver.findElement((By.xpath("//h3")));
String find_from_to_text = find_from_to.getText();
assertEquals("Flights from San Diego to Berlin:", find_from_to_text, "Error!!");
```
- Перед функцией и после можно использовать @BeforeClass и @AfterClass, для ликвидации повторов, если несколько методов в классе используется.

##Homework 1
Selenium

Задание:

Написать первый тест, позволяющий нажимать на кнопку Find Flights в приложении BlazeDemo.com
Сценарий:
1. Открыть страницу BlazeDemo.com
2. Нажать на кнопку FindFlights
Ожидаемый результат: открылась страница с результатами поиска

Решение:
- Вопроизвел из лекции установку IDEA, установил Java, скачал WebDriver.
- Настроил их взаимосвязь между собой.
- Создал class Homework1:
```
WebDriver driver = new ChromeDriver();
driver.get("http://blazedemo.com/");
WebElement findbutton = driver.findElement(By.cssSelector("input[type='submit']"));
findbutton.click();
driver.quit();
```
- Добавил поиск класса таблица на открывшейся странице для проверки.
```
WebElement findnewopen = driver.findElement(By.className("table"));
assertTrue(findnewopen.isDisplayed());
```
- P.S. так какэ то было мое первое знакомство с Java было тяжко, если бы не лекция я бы точно не справился.
