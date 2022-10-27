package org.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\Features",
   glue={"org.stepdefinition", "org.baseClass"},
   dryRun = false,
  plugin= {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}) 
public class TestRunner {
	
	
	
}
