package com.github.thiagogarbazza.stringreplacer.ta;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleNumberReplacerIntegrationTest extends AbstractTestIntegration {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-number}!";
    String expected = "Simple example 3!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-number | format: '#,##0.000'}!";
    String expected = "Simple example 3.142!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-number | format: '#,##0.000', rounding-mode: 'floor'}!";
    String expected = "Simple example 3.141!";

    assertEquals(expected, replacer(templateText));
  }
}
