package com.github.thiagogarbazza.stringreplacer.it;

import com.github.thiagogarbazza.stringreplacer.StringReplacerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ReplacerNotFoundIntegrationTest extends AbstractTestIntegration {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void verify() {
    expectedException.expect(StringReplacerException.class);
    expectedException.expectMessage("Not found implementation for the \"any-token-nonexistent\" token.");

    String templateText = "Simple example ${ any-token-nonexistent }!";

    replacer(templateText);
  }
}
