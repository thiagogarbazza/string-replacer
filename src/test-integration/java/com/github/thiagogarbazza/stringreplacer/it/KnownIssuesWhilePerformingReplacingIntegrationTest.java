package com.github.thiagogarbazza.stringreplacer.it;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnownIssuesWhilePerformingReplacingIntegrationTest extends AbstractTestIntegration {

  @Test
  public void verifyReplacementWithTextContainCharacter$() {
    String templateText = "Simple example ${simple-number | format: '$ #,##0.000', rounding-mode: 'floor'}!";
    String expected = "Simple example $ 3.141!";

    assertEquals(expected, replacer(templateText));
  }
}
