package com.github.thiagogarbazza.stringreplacer;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TokenTest {

  @Test
  public void verifyDefaultValueGetArg() {
    Token token = new Token("${simple-boolean | case: 'upper'}", "simple-boolean", new HashMap<String, String>() {{put("case", "upper");}});

    assertEquals("upper", token.getArg("case", "lower"));
  }

  @Test
  public void verifyDefaultValueGetArgNonexistent() {
    Token token = new Token("${simple-boolean | case: 'upper'}", "simple-boolean", new HashMap<String, String>() {{put("case", "upper");}});

    assertEquals("lower", token.getArg("nonexistent", "lower"));
  }

  @Test
  public void verifyDefaultValueGetArgWithValueEmpty() {
    Token token = new Token("${simple-boolean | case: ''}", "simple-boolean", new HashMap<String, String>() {{put("case", "  ");}});

    assertEquals("lower", token.getArg("case", "lower"));
  }

  @Test
  public void verifyDefaultValueGetArgWithValueNull() {
    Token token = new Token("${simple-boolean | case: ''}", "simple-boolean", new HashMap<String, String>() {{put("case", null);}});

    assertEquals("lower", token.getArg("case", "lower"));
  }

  @Test
  public void verifyDefaultValueGetArgWithValueSpace() {
    Token token = new Token("${simple-boolean | case: ''}", "simple-boolean", new HashMap<String, String>() {{put("case", " a ");}});

    assertEquals(" a ", token.getArg("case", "lower"));
  }

  @Test
  public void verifyGetArg() {
    Token token = new Token("${simple-boolean | case: 'upper'}", "simple-boolean", new HashMap<String, String>() {{put("case", "upper");}});

    assertEquals("upper", token.getArg("case"));
  }

  @Test
  public void verifyGetArgNonexistent() {
    Token token = new Token("${simple-boolean | case: 'upper'}", "simple-boolean", new HashMap<String, String>() {{put("case", "upper");}});

    assertEquals(null, token.getArg("nonexistent"));
  }

  @Test
  public void verifyGetArgWithValueEmpty() {
    Token token = new Token("${simple-boolean | case: ''}", "simple-boolean", new HashMap<String, String>() {{put("case", "");}});

    assertEquals("", token.getArg("case"));
  }

  @Test
  public void verifyGetArgWithValueNull() {
    Token token = new Token("${simple-boolean | case: ''}", "simple-boolean", new HashMap<String, String>() {{put("case", null);}});

    assertEquals(null, token.getArg("case"));
  }
}
