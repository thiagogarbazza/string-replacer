package com.github.thiagogarbazza.stringreplacer.it;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleBooleanReplacerIntegrationTest extends AbstractTestIntegration {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-boolean}!";
    String expected = "Simple example true!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-boolean | case: 'upper'}!";
    String expected = "Simple example TRUE!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-boolean | true-text: 'yes', false-text: 'no'}!";
    String expected = "Simple example yes!";

    assertEquals(expected, replacer(templateText));
  }
}
