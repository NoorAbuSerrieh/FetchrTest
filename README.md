# FetchrTest
Fetchr Website Testing

How to run the code:
First make sure that you have an IDE on your compter such as(eclipse), then make sure that TestNg is downloaded and configured on your IDE and finally make sure maven is 
installed and configured on your computer.

Please follow those steps to install TestNg to eclipse https://www.guru99.com/install-testng-in-eclipse.html

Follow this Link to download maven https://maven.apache.org/download.cgi

Follow this link to configure Maven to Windows https://howtodoinjava.com/maven/how-to-install-maven-on-windows/

After configuring the tools navigate to repository link and download the "FetchrWebsiteTest" Folder open it with your IDE and you can run it in two ways:

First way:
1. Expand the project folder 
2. Double click on testng.xml file
3. Right click on the opened testng file then choose run as "TestNg Suite"

Second Way:
1. Open cmd 
2. Navigate to the path pf the project > cd project folder path
3. in cmd enter> mvn clean then > mvn compile then > mvn test

After the run is completed you can check to reports and check TestReport folder to see extent reports and screenshots related to test cases.

In this assignment I built the test under maven framework to manage and control the project and the dependencies in pom.xml file also I used TestNg tool to write and manage the test cases. As you can see the design pattern used to build the framework is Page object design as I started testing the main page(Tracking page) then to the other pages user can navigate to from tracking screen. Each page is separated in class and the elements of this page is separated in another class. Also I used external tool to create extra report (Extent report) and screenshots to track and troubleshoot if any failure happened. 

The problem that I actually faced is that the provided tracking number statuses kept changing so some cases will fail if it's dependent on order that it's status is changed.
So please note that the tests wrote based on the tracking status at the time I wrote the test cases if status is changed some cases may be failed.
