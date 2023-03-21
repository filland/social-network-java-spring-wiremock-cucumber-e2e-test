package org.example;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber") // tell JUnit 5 to use  Cucumber test engine to run features
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example") // specify path to steps definitions
// specify path to feature files
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features/")
public class EndToEndCucumberTestConfiguration {
}