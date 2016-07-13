
# FRAMEWORKIUM & CUCUMBER-JVM

This is a demo/poc project demonstrating integration of Frameworkium with Cucumber-JVM using the Page Object model With Page Factory pattern

## Test Execution:
There is a test that fails so that reports with a failure can be seen, to runn only passing tests use the cucumber tag
`@pass`

###### **Concurrent**
- run all tests from command line:
`mvn clean test`
- run specific tagged tests (eg @test1) from command line:
`mvn clean test -DCucumber.options="--tags @test1`
- run tests from within IDE by running the RunCukesTest.class as a Junit test, to run specific tags change the
tag in the 'tags = "~@ignore"' part of the @CucumberOptions parameter at the top of the class

###### **Parallel**
parallel execution is done at the feature level, feature files are run in Parallel not Scenarios
first you will need the selenium grid up and running and a node, I did it with chrome by running these commands in
separate terminal windows on a windows machine:

Hub:
`java -jar path\\to\\selenium-server-standalone-2.48.2.jar -role hub`
Node:
`java -jar path\\to\\selenium_grid\\selenium-server-standalone-2.48.2.jar -role webdriver -browser "browserName=chrome, version=45, maxInstances=5, platform=windows" -port 5555 -Dwebdriver.chrome.driver=path\\to\\chromedriver.exe`

Now add the **__-Dgrid-test__** argument to the previously seen command line command:
`mvn clean test -Dgrid-test`

## Reports
- There will be cucumber html reports generated in `taget\cucumber`  for parallel execution there will be a
separate report generated for each feature
- For allure reports run `mvn site` and open the `target\site\allure-maven-plugin\index.html` file


## Further Documentation
Please Refer to documentation for information on the following:
- [Frameworkium](https://github.com/Frameworkium/frameworkium/wiki)
- [Allure Reporting](https://github.com/allure-framework/allure-core/wiki)
- [Cucumber-JVM](https://cucumber.io/docs/reference/jvm#java)

## Other Points
- All Page object classes with containing Page Objects are initialised before the tests by using the selenium Page
Factory - this avoids the need for declaring in step classes the PO classes then initialising them from within steps
which can get very messy or having to use `new` everytime you make a call to a page object class from within steps.
After the PO are initially initialised the Frameworkium PageFactory DI is used (using @Inject on PO class constructors)
 which makes sure all pages are loaded as we move from page to page etc
-  for parallel execution we generate a separate runner class for each feature file using a [plugin](https://github.com/temyers/cucumber-jvm-parallel-plugin)
- the standard cucumberjvm.AllureRunListener for the allure reports is not compatible with TestNG so the TestNG
dependency from frameworkium has been excluded and Junit has been used
- WebdriverUtils class is used to wrap all webdriver functionality which is then in turn called by all PO classes

