package org.runnerclass;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilies.JVMReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@src\\test\\resources\\Rerun\\failed.txt", glue = "org.stepdefinitions", dryRun = false, plugin = {
		"json:target\\Report\\fblogin.json", "rerun:src\\test\\resources\\Rerun\\failed.txt" })
public class TestRerunner {
	@AfterClass
	public static void report() {
		JVMReports.generateTheJVMReport(
				"C:\\Users\\Star\\eclipse-workspace\\CucumberProjects\\target\\Report\\fblogin.json");

	}
}
