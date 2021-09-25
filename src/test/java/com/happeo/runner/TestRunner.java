package com.happeo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFile",
        glue = {"classpath:com.happeo.stepDefinitions", "classpath:com.happeo.driverInit"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@test"
        
)
public class TestRunner {

		
	
}
