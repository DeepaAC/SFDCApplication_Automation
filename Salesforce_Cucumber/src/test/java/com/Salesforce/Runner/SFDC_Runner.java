package com.Salesforce.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber", "json:target/cucumber-report.json" }, 
glue = { "com.Salesforce.Steps" }, 
features = { "src\\test\\resources\\features\\SFDC.feature" }, 
tags = {})

public class SFDC_Runner {

}
