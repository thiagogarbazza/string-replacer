package com.github.thiagogarbazza.stringreplacer.it;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ReplacerNotFoundIntegrationTest extends AbstractTestIntegration {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${any-token}!";
    String expected = "Simple example ${any-token}!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${any-token | case: 'upper'}!";
    String expected = "Simple example ${any-token | case: 'upper'}!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${any-token | true-text: 'yes', false-text: 'no'}!";
    String expected = "Simple example ${any-token | true-text: 'yes', false-text: 'no'}!";

    assertEquals(expected, replacer(templateText));
  }
}
