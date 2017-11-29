package com.github.thiagogarbazza.stringreplacer.integrationtest.outputtype;

import com.github.thiagogarbazza.stringreplacer.StringReplacer;
import com.github.thiagogarbazza.stringreplacer.impl.StringReplacerFactory;
import com.github.thiagogarbazza.stringreplacer.integrationtest.data.Replacers;
import com.github.thiagogarbazza.stringreplacer.integrationtest.data.UserVO;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.github.thiagogarbazza.stringreplacer.OutputType.HTML;
import static com.github.thiagogarbazza.stringreplacer.OutputType.MARKDOWN;
import static com.github.thiagogarbazza.stringreplacer.OutputType.PLAIN_TEXT;
import static com.github.thiagogarbazza.stringreplacer.integrationtest.data.UserVO.buildThiagoGarbazza;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;

public class OutputTypePlainTextTest {

  private static final UserVO DATA = buildThiagoGarbazza();

  private StringReplacer stringReplacer;

  @Before
  public void beforeTest() {
    stringReplacer = StringReplacerFactory.newStringReplacer(new Replacers());
  }

  @Test
  public void verifyHtml() {
    final String textIn = getText("html-in.html");
    final String textOut = getText("html-out.html");
    final String textResult = stringReplacer.replace(textIn, DATA, HTML);

    assertEquals(textOut, textResult);
  }

  @Test
  public void verifyPlainMarkdown() {
    final String textIn = getText("markdown-in.md");
    final String textOut = getText("markdown-out.md");
    final String textResult = stringReplacer.replace(textIn, DATA, MARKDOWN);

    assertEquals(textOut, textResult);
  }

  @Test
  public void verifyPlainText() {
    final String textIn = getText("plain-text-in.txt");
    final String textOut = getText("plain-text-out.txt");
    final String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);

    assertEquals(textOut, textResult);
  }

  static String getText(String fileName) {
    final InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

    BufferedInputStream bis = new BufferedInputStream(resource);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    int result = 0;
    try {
      result = bis.read();

      while (result != -1) {
        buf.write((byte) result);
        result = bis.read();
      }

      return buf.toString(UTF_8.name());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
