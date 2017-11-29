package com.github.thiagogarbazza.stringreplacer.integrationtest;

import com.github.thiagogarbazza.stringreplacer.StringReplacer;
import com.github.thiagogarbazza.stringreplacer.impl.StringReplacerFactory;
import com.github.thiagogarbazza.stringreplacer.integrationtest.data.Replacers;
import com.github.thiagogarbazza.stringreplacer.integrationtest.data.UserVO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.regex.Pattern;

import static com.github.thiagogarbazza.stringreplacer.OutputType.PLAIN_TEXT;
import static com.github.thiagogarbazza.stringreplacer.integrationtest.data.UserVO.buildThiagoGarbazza;
import static org.junit.Assert.assertEquals;

public class ChangePatternReplacerTest {

  private static final UserVO DATA = buildThiagoGarbazza();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();
  private StringReplacer stringReplacer;

  @Test
  public void verifySendNewInvalidPatternWithoutNamedGroup() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("No group with name <token>");

    final Pattern myPattern = Pattern.compile("@\\{([\\w.]+)[|]*?([\\w,.-]+)?\\}");
    stringReplacer = StringReplacerFactory.newStringReplacer(myPattern, new Replacers());
    stringReplacer.replace("@{user.name}", DATA, PLAIN_TEXT);
  }

  @Test
  public void verifySendNewInvalidPatternWithoutNamedGroupArgs() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("No group with name <args>");

    final Pattern myPattern = Pattern.compile("@\\{(?<token>[\\w.]+)[|]*?([\\w,.-]+)?\\}");
    stringReplacer = StringReplacerFactory.newStringReplacer(myPattern, new Replacers());
    stringReplacer.replace("@{user.name}", DATA, PLAIN_TEXT);
  }

  @Test
  public void verifySendNewInvalidPatternWithoutNamedGroupToken() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("No group with name <token>");

    final Pattern myPattern = Pattern.compile("@\\{([\\w.]+)[|]*?(?<args>[\\w,.-]+)?\\}");
    stringReplacer = StringReplacerFactory.newStringReplacer(myPattern, new Replacers());
    stringReplacer.replace("@{user.name}", DATA, PLAIN_TEXT);
  }

  @Test
  public void verifySendNewPatternToReplacer() {
    final Pattern myPattern = Pattern.compile("@\\{(?<token>[\\w.]+)[|]*?(?<args>[\\w,.-]+)?\\}");
    stringReplacer = StringReplacerFactory.newStringReplacer(myPattern, new Replacers());
    String textResult = stringReplacer.replace("@{user.name}", DATA, PLAIN_TEXT);

    assertEquals("Thiago Garbazza", textResult);
  }

  @Test
  public void verifySendNewStringPatternToReplacer() {
    String myPattern = "#(?<token>[\\w.]+)[|]*?(?<args>[\\w,.-]+)?#";
    stringReplacer = StringReplacerFactory.newStringReplacer(myPattern, new Replacers());
    String textResult = stringReplacer.replace("#user.name#", DATA, PLAIN_TEXT);

    assertEquals("Thiago Garbazza", textResult);
  }
}
