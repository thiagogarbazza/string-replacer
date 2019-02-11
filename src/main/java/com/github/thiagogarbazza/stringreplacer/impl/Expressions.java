package com.github.thiagogarbazza.stringreplacer.impl;

import lombok.Getter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Expressions implements Iterator<Expressions.Expression>, Iterable<Expressions.Expression> {

  private static final String ARGS_SEPARATOR = ",";
  private static final String GROUP_ARGS = "args";
  private static final String GROUP_TOKEN = "token";

  private final StringBuffer buffer;
  private final Matcher matcher;
  private final Pattern patternArgs;

  public Expressions(final Pattern pattern, Pattern patternArgs, String text) {
    this.patternArgs = patternArgs;
    this.buffer = new StringBuffer();
    this.matcher = pattern.matcher(text);
  }

  @Override
  public boolean hasNext() {
    return matcher.find();
  }

  @Override
  public Expression next() {
    final String token = matcher.group(GROUP_TOKEN);
    final String args = matcher.group(GROUP_ARGS);
    final HashMap<String, String> argss = new HashMap<>();

    if(args != null) {
      final Matcher matcherArgs = patternArgs.matcher(matcher.group(GROUP_ARGS));
      while (matcherArgs.find()) {
        argss.put(matcherArgs.group("key"), matcherArgs.group("value"));
      }
    }

    return new Expression(token, argss);
  }

  @Override
  public void remove() {
    // Do nothing here...
  }

  @Override
  public Iterator<Expression> iterator() {
    return this;
  }

  public String result() {
    matcher.appendTail(buffer);

    return buffer.toString();
  }

  void replace(String value) {
    matcher.appendReplacement(buffer, Matcher.quoteReplacement(value));
  }

  @Getter
  class Expression {

    private final Map<String, String> args;
    private final String token;

    private Expression(final String token, final Map<String, String> args) {
      this.token = token;
      this.args = args;
    }

    public void setResult(String result) {
      replace(result);
    }
  }
}
