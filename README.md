# OmgeoDemo
Author: Yawo Amegadje
####Overview:
This project implements an the Omgeo Exercise.

###Project install Prerequisites:
Must have the following software installed on your machine
- Git Bash
- Java:  1.7 or higher
- Web browser: Firefox ( Version 45.x recommanded), or Chrome/IE
- Maven ( Version 3.3.9 recommended )

###Install instructions:
- Step 1: Start Git Bash and go to the Git Bash command prompt
- Step 2: On Git Bash prompt type the following command in order to get a clone from GitHub (without the quotes):  
"git clone https://github.com/KingOfZamunda/OmgeoDemo.git"
- Step 3: Type the comamnd  "pwd" to get the path where the project folder is located ( take a note of that folder )

###Run Instructions 
( must have completed the installation prior to RUN. But install is only needed once)
- Step A: Open a DOS terminal
- Step B: Change directory (cd) to the folder from Step3 of installation
- Step C: Navigate to the folder OmgeoDemo 
- Step D: Generate the build & run test in Maven using the commands below

For Windows:
          mvn clean test -DtestSuiteXmlFile=src\test\resources\myTestNG.xml

For Mac/Linux:
           mvn clean test -DtestSuiteXmlFile='src/test/resources/myTestNG.xml'

#####Notes: 
- While test is runing please do not interfere with browser as this may cause unexpected behaviors
- RESULTS: Once test completed, TestNG reports can be seen in subfolder  OmgeoDemo\target\surefire-reports

