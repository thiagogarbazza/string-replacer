package com.github.thiagogarbazza.stringreplacer.ti;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore("Specifying")
public class SimpleTextReplacerIntegrationTest {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-text}!";
    String expected = "Simple example any text!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-text | format: 'upper'}!";
    String expected = "Simple example ANY TEXT!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-text | format: 'UPPER', space-to-underscored: 'true'}!";
    String expected = "Simple example ANY_TEXT";

    assertEquals(expected, replacer(templateText));
  }

  private String replacer(final String templateText) {
    return null;
  }
}
