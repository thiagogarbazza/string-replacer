package com.github.thiagogarbazza.stringreplacer.at;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@Ignore
@RunWith(Cucumber.class)
@CucumberOptions(
  features = "classpath:com/github/thiagogarbazza/stringreplacer/at/ReplacerAcceptanceTest.feature",
  glue = {"classpath:com/github/thiagogarbazza/stringreplacer/at/steps/"}
)
public class ReplacerAcceptanceTest {}
