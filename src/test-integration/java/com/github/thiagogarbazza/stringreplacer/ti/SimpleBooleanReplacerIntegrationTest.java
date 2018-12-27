package com.github.thiagogarbazza.stringreplacer.ti;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore("Specifying")
public class SimpleBooleanReplacerIntegrationTest {

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example ${simple-boolean}!";
    String expected = "Simple example true!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example ${simple-boolean | format: 'upper'}!";
    String expected = "Simple example TRUE!";

    assertEquals(expected, replacer(templateText));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example ${simple-boolean | true-text: 'Yes', false-text 'No'}!";
    String expected = "Simple example Yes!";

    assertEquals(expected, replacer(templateText));
  }

  private String replacer(final String templateText) {
    return null;
  }
}
