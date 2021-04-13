# README

This project will utilize Java to ingest a CSV file, parse it, convert to usable format (XML) and output usable data to a file. Other functionalities will be added at later phase.

## Scope

This project will use the following:
- Java
- HTML, CSS, Javascript
- Gradle 
- Tomcat
- JUnit
- Spring/Spring boot?
- Postgresql
- [Heroku](https://devcenter.heroku.com/categories/java-support)/AWS deployment
- Authentication? (API Key, encryption)
- Base64 encoding?

## Phases

1. Create basic Java backend to ingest CSV file and output to XML, save locally, send to outside server, receive response
2. Create basic frontend for submitting CSV file, downloading XML output
3. Create reverse function

## Tasks for Phase 1

1. CSV file format:
```
quantity,amount, currency, itemID, category, item, description
```
quantity - int
amount in minor units
currency in [ISO_4217](https://en.wikipedia.org/wiki/ISO_4217) format
category - ENUM (Fruit, Vegetable, Snacks, )
itemID - 9 digit int (randomly generate for now)
item - string
description - string
2. [XML](https://www.w3schools.com/xml/default.asp)
```
<?xml version="1.0" encoding="UTF-8"?>
<inventory>
	<shopItem category="">
		<quantity></quantity>
		<amount></amount>
		<currency></currency>
		<itemID></itemID>
		<item></item>
		<description></description>
	</shopItem>
</inventory>
```
3. [Java.io.File](https://www.w3schools.com/java/java_files.asp)
4. Java HttpUrlConnection/Java HttpClient
5. ...

## Future Functionalities

- Create randomly generated CSV file, use different sorting algorithms to sort information based on different criteria
- Visualize different sorting algorithms on front-end