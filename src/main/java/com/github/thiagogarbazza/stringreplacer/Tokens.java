package com.github.thiagogarbazza.stringreplacer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Tokens {

  private static final String GROUP_ARGS = "args";
  private static final String GROUP_TOKEN_NAME = "tokenName";

  private final StringBuffer buffer;
  private final Matcher matcher;
  private final String originalText;
  private final Pattern patternArgs;

  public Tokens(final Pattern pattern, Pattern patternArgs, String text) {
    this.originalText = text;
    this.buffer = new StringBuffer();
    this.patternArgs = patternArgs;
    this.matcher = pattern.matcher(text);
  }

  public boolean hasNext() {
    return matcher.find();
  }

  public Token next() {
    final String token = matcher.group(GROUP_TOKEN_NAME);
    final String args = matcher.group(GROUP_ARGS);
    final HashMap<String, String> argss = new HashMap<>();

    if (args != null) {
      final Matcher matcherArgs = patternArgs.matcher(matcher.group(GROUP_ARGS));
      while (matcherArgs.find()) {
        argss.put(matcherArgs.group("key"), matcherArgs.group("value"));
      }
    }

    return new Token(this.originalText.substring(matcher.start(), matcher.end()), token, argss);
  }

  public String result() {
    matcher.appendTail(buffer);

    return buffer.toString();
  }

  void replace(String value) {
    matcher.appendReplacement(buffer, Matcher.quoteReplacement(value));
  }

  class Token extends com.github.thiagogarbazza.stringreplacer.Token {

    public Token(final String full, final String name, final Map<String, String> args) {
      super(full, name, args);
    }

    void setResult(String result) {
      replace(result);
    }
  }
}
