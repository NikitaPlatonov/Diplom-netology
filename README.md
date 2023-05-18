# Поиск слова в pdf-файле

**Поиск слова в pdf-файле** - это серверное Java-приложение позволяющее искать необходимое слово в pdf-файлах.

## Структура работы

![diagram (1)](https://github.com/NikitaPlatonov/Diplom-netology/assets/124439125/0fc151c9-540e-4bdb-bd04-e2a431808a2c)

## Установка

Установка в Intellij IDEA:

1. Клонируйте репозиторий:

```git
git clone https://github.com/NikitaPlatonov/Diplom-netology.git
```

2. Перейдите в каталог проекта:

```git
cd Diplom-netology
```

3. Соберите проект с помощью инструмента сборки, такого как Apache Maven:

```git
mvn clean install
```

4. После успешной сборки проекта вы можете запустить его с помощью команды:

```git
java -jar target/название_файла.jar
```
> Замените название_файла.jar на фактическое имя JAR-файла, сгенерированного в результате сборки проекта.

## Требования

Для успешной установки и работы данного проекта необходимо удовлетворять следующим требованиям:

* Java Development Kit (JDK) версии 11 или выше. Вы можете [скачать JDK](https://www.oracle.com/java/technologies/downloads/#java11) с официального веб-сайта Oracle или использовать другой надежный источник.

* Установленная среда разработки (например, IntelliJ IDEA, Eclipse и т. д.) для открытия проекта и удобного разработки.

* Apache Maven для сборки проекта и управления зависимостями. Вы можете [скачать Apache Maven](https://maven.apache.org/download.cgi) и следовать инструкциям по его установке.

* Библиотека iTextPDF для работы с файлами PDF. Вы можете добавить зависимость в файле pom.xml вашего проекта:
```xml
<dependencies>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>itextpdf</artifactId>
        <version>5.5.13</version>
    </dependency>
</dependencies>
```

* Библиотека GSON для работы с json. Вы можете добавить зависимость в файле pom.xml вашего проекта:
```xml
<dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version>
        </dependency>
```
