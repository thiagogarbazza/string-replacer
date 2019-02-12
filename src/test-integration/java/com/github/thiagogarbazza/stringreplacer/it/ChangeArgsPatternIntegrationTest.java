package com.github.thiagogarbazza.stringreplacer.it;

import com.github.thiagogarbazza.stringreplacer.StringReplacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeArgsPatternIntegrationTest extends AbstractTestIntegration {

  private static final String NEW_PATTERN_ARGS = "(?<key>[\\w\\d-_]*)[\\s]*?==[\\s]*?'(?<value>[^']*)'";
  private static final String NEW_PATTERN_TOKEN = "@\\{\\{[\\s]*?(?<tokenName>[\\w.-]+)([\\s]*?[|][\\s]*(?<args>[^}]*))?[\\s]*?}}";
  private StringReplacer stringReplacer;

  @Before
  public void before() {
    stringReplacer = StringReplacerFactory.newStringReplacer(REPLACERS, NEW_PATTERN_TOKEN, NEW_PATTERN_ARGS);
  }

  @Test
  public void vefiryNoParameterUsage() {
    String templateText = "Simple example @{{simple-text}}!";
    String expected = "Simple example any text!";

    assertEquals(expected, stringReplacer.replace(templateText, dataProcessor));
  }

  @Test
  public void vefiryWithParameterUsage() {
    String templateText = "Simple example @{{simple-text | case== 'upper'}}!";
    String expected = "Simple example ANY TEXT!";

    assertEquals(expected, stringReplacer.replace(templateText, dataProcessor));
  }

  @Test
  public void vefiryWithUseOfParameters() {
    String templateText = "Simple example @{{simple-text | case == 'UPPER', space-to-underscored == 'true'}}!";
    String expected = "Simple example ANY_TEXT!";

    assertEquals(expected, stringReplacer.replace(templateText, dataProcessor));
  }
}
