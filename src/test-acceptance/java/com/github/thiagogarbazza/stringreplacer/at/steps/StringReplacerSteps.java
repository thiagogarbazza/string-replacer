package com.github.thiagogarbazza.stringreplacer.at.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class StringReplacerSteps {

  private String expectedText;
  private String templateText;

  @Before
  public void before() {
    this.templateText = null;
    this.expectedText = null;
  }

  @Given("that I have the following template:")
  public void given(String template) {
    System.out.println("given");
    this.templateText = template;
  }

  @Then("I will receive the following tokens:")
  public void then(DataTable dataTable) {
    System.out.println("then");
  }

  @When("to ask what tokens are in the text?")
  public void when() {
    System.out.println("when");
  }
}
