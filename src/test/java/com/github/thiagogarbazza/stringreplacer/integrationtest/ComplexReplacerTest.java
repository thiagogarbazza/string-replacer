package com.github.thiagogarbazza.stringreplacer.integrationtest;

import com.github.thiagogarbazza.stringreplacer.StringReplacer;
import com.github.thiagogarbazza.stringreplacer.impl.StringReplacerFactory;
import com.github.thiagogarbazza.stringreplacer.integrationtest.data.Replacers;
import com.github.thiagogarbazza.stringreplacer.integrationtest.data.UserVO;
import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.stringreplacer.integrationtest.data.UserVO.buildThiagoGarbazza;
import static com.github.thiagogarbazza.stringreplacer.result.OutputType.PLAIN_TEXT;
import static org.junit.Assert.assertEquals;

public class ComplexReplacerTest {

  private static final UserVO DATA = buildThiagoGarbazza();
  private StringReplacer stringReplacer;

  @Before
  public void beforeTest() {
    stringReplacer = StringReplacerFactory.newStringReplacer(new Replacers());
  }

  @Test
  public void verifyMultipleReplacerInText() {
    final String textIn = "My name is '{{user.name}}' and I was born on '{{user.creationDate|YYYY-MM-dd}}'";
    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);

    assertEquals("My name is 'Thiago Garbazza' and I was born on '1984-07-20'", textResult);
  }

  @Test
  public void verifyUniqueReplacerInText() {
    final String textIn = "My name is {{user.name}}";
    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);

    assertEquals("My name is Thiago Garbazza", textResult);
  }
}
