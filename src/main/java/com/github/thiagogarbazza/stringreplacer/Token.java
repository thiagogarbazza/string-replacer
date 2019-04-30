package com.github.thiagogarbazza.stringreplacer;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString(of = {"full"})
public class Token {

  private final Map<String, String> args;
  private final String full;
  private final String name;

  public Token(final String full, final String name, final Map<String, String> args) {
    this.full = full;
    this.name = name;
    this.args = args;
  }

  public String getArg(final String argName) {
    return args.get(argName);
  }

  public String getArg(final String argName, final String defaultValue) {
    final String argValue = getArg(argName);

    return argValue == null ? defaultValue : argValue;
  }
}
