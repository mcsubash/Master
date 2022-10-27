package org.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
   glue="org.stepdefinition",
   dryRun = false,
  plugin= {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}//to check the mapping is proper between feature file and step def file
   
// tags= {"@Login, @OPI"}
  ) 
public class TestRunner {
	
	
	
}
