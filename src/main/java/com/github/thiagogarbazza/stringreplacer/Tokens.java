package com.github.thiagogarbazza.stringreplacer;

import lombok.Getter;
import lombok.ToString;

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

  @Getter
  @ToString(of = {"full"})
  class Token {

    private final Map<String, String> args;
    private final String full;
    private final String name;

    private Token(final String full, final String name, final Map<String, String> args) {
      this.full = full;
      this.name = name;
      this.args = args;
    }

    void setResult(String result) {
      replace(result);
    }
  }
}
