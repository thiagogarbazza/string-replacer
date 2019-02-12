package com.github.thiagogarbazza.stringreplacer.it;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManyTokensReplacerIntegrationTest extends AbstractTestIntegration {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-boolean} = ${simple-number}!";
    String expected = "Simple example true = 3!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-boolean | case: 'upper'} = ${simple-number | format: '#,##0.000'}!";
    String expected = "Simple example TRUE = 3.142!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-boolean | true-text: 'yes', false-text: 'no'} = ${simple-number | format: '#,##0.000', rounding-mode: 'floor'}!";
    String expected = "Simple example yes = 3.141!";

    assertEquals(expected, replacer(templateText));
  }
}
