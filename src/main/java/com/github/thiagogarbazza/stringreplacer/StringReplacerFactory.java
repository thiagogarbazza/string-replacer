package com.github.thiagogarbazza.stringreplacer;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@UtilityClass
public class StringReplacerFactory {

  private static final Pattern PATTERN_DEFAULT_ARGS = compile("(?<key>[\\w\\d-_]*)[\\s]*?:[\\s]*?'(?<value>[^']*)'");
  private static final Pattern PATTERN_DEFAULT_TOKEN = compile("\\$\\{[\\s]*?(?<tokenName>[\\w.-]+)([\\s]*?[|][\\s]*(?<args>.*))?[\\s]*?}");

  public static StringReplacer newStringReplacer(final Collection<? extends Replacer> replacers) {
    return newStringReplacer(replacers, PATTERN_DEFAULT_TOKEN);
  }

  public static StringReplacer newStringReplacer(final Collection<? extends Replacer> replacers, final Pattern patternToken) {
    return newStringReplacer(replacers, patternToken, PATTERN_DEFAULT_ARGS);
  }

  public static StringReplacer newStringReplacer(final Collection<? extends Replacer> replacers, final String patternToken) {
    return newStringReplacer(replacers, Pattern.compile(patternToken), PATTERN_DEFAULT_ARGS);
  }

  public static StringReplacer newStringReplacer(final Collection<? extends Replacer> replacers, final Pattern patternToken, final Pattern patternArgs) {
    return new StringReplacerImpl(replacers, patternToken, patternArgs);
  }

  public static StringReplacer newStringReplacer(final Collection<? extends Replacer> replacers, final String patternToken, final String patternArgs) {
    return newStringReplacer(replacers, Pattern.compile(patternToken), Pattern.compile(patternArgs));
  }
}
