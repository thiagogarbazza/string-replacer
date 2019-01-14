package com.github.thiagogarbazza.stringreplacer.ta;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTextReplacerIntegrationTest extends AbstractTestIntegration {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-text}!";
    String expected = "Simple example any text!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-text | case: 'upper'}!";
    String expected = "Simple example ANY TEXT!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-text | case: 'UPPER', space-to-underscored: 'true'}!";
    String expected = "Simple example ANY_TEXT!";

    assertEquals(expected, replacer(templateText));
  }
}
