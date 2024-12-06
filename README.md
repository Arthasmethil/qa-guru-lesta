# Проект по автоматизации тестовых сценариев для SauceDemo
## **Содержание:**
* <a href="#tools">Использованный стек технологий</a> 
* <a href="#launchAutotest">Запуск автотестов</a>
* <a href="#jenkinsBuild">Сборка в Jenkins</a>
* <a href="#allureReport">Пример Allure-отчета</a>
* <a href="#telegramNotification">Уведомления в Telegram с использованием бота</a>
* <a href="#testExampleGif">Видео примера запуска тестов в Selenoid</a>

<a id="tools"></a>
## Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

<a id="launchAutotest"></a>
## Запуск автотестов

### Запуск тестов из терминала
```
gradle clean test
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

### Запуск тестов на удаленном браузере
```
gradle clean test -Denv=main
```
При необходимости также можно переопределить параметры запуска

```
clean
${TASK}
-DremoteHost=https://${REMOTE_LOGIN}:${REMOTE_PASSWORD}@${REMOTE_URL}/wd/hub
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
```

### Параметры сборки
* <code>TASK</code> – Команда запуска тестов. По-умолчанию - <code>smoke_test</code>.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>125</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1920x1080</code>.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.


## <img src="images/logo/Jenkins.svg" id="jenkinsBuild" title="Jenkins" width="4%"/> Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="images/screens/JenkinsBuild.png">
</p>

## <img src="images/logo/Allure_Report.svg" id="allureReport" title="Allure Report" width="4%"/> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="images/screens/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Allure" src="images/screens/ResultTest.png">
</p>

## <img width="4%" style="vertical-align:middle" id="telegramNotification" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screens/telegramPush.png">
</p>

## Видео примера запуска тестов в Selenoid
<a id="testExampleGif"></a>
К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="images/screens/testLaunch.gif">
</p>