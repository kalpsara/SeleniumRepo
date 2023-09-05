package week7.day1.assignments.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
		"src/test/java/week7/day1/assignments/features" }, glue = "week7/day1/assignments/stepDefinitions", monochrome = true, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}