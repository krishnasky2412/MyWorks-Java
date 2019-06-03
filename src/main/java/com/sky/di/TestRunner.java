package com.sky.di;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features/Data-Ingest.feature", glue = "com.sky.di")
public class TestRunner {

}
