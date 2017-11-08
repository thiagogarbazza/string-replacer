package com.github.thiagogarbazza.stringreplacer.impl;

import com.github.thiagogarbazza.stringreplacer.result.OutputType;
import com.github.thiagogarbazza.stringreplacer.result.Result;
import lombok.Getter;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Expressions implements Iterator<Expressions.Expression>, Iterable<Expressions.Expression> {

  private static final String ARGS_SEPARATOR = ",";
  private static final String GROUP_ARGS = "args";
  private static final String GROUP_TOKEN = "token";

  private final StringBuffer buffer;
  private final Matcher matcher;
  private final OutputType type;

  public Expressions(Pattern pattern, String text, final OutputType type) {
    this.buffer = new StringBuffer();
    this.matcher = pattern.matcher(text);
    this.type = type;
  }

  @Override
  public boolean hasNext() {
    return matcher.find();
  }

  @Override
  public Expression next() {
    String token = matcher.group(GROUP_TOKEN);
    String args = matcher.group(GROUP_ARGS);

    return new Expression(token, args == null ? null : args.split(ARGS_SEPARATOR));
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
    matcher.appendReplacement(buffer, value);
  }

  @Getter
  class Expression {

    private final String[] args;
    private final String token;

    private Expression(final String token, final String[] args) {
      this.token = token;
      this.args = args;
    }

    public void setResult(Result result) {
      replace(result.output(type, token));
    }
  }
}
