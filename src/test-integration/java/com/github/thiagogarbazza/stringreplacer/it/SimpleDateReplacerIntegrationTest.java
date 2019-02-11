package com.github.thiagogarbazza.stringreplacer.it;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleDateReplacerIntegrationTest extends AbstractTestIntegration {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-date}!";
    String expected = "Simple example 2018-12-25!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-date | format: 'dd/MM/yyyy'}!";
    String expected = "Simple example 25/12/2018!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-date | format: 'dd/MM/yyyy', max-day-of-month: 'true'}!";
    String expected = "Simple example 31/12/2018!";

    assertEquals(expected, replacer(templateText));
  }
}
