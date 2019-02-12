package com.github.thiagogarbazza.stringreplacer.at;

import com.github.thiagogarbazza.stringreplacer.it.AbstractTestIntegration;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class FullAcceptanceTest extends AbstractTestIntegration {

  @Test
  public void runVerify() throws IOException, URISyntaxException {
    String templateText = readFile("at-template.md");
    String expected = readFile("at-expected.md");

    final String actual = replacer(templateText);

    assertEquals(expected, actual);
  }

  static String readFile(String file) throws URISyntaxException, IOException {
    final URL url = Thread.currentThread().getContextClassLoader().getResource(file);

    byte[] encoded = Files.readAllBytes(Paths.get(url.toURI()));
    final String text = new String(encoded, Charset.forName("UTF-8"));
    return text;
  }
}
