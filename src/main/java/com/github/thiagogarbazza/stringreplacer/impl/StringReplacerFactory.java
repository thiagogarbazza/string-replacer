package com.github.thiagogarbazza.stringreplacer.impl;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacer;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@UtilityClass
public class StringReplacerFactory {

  private static final Pattern PATTERN_DEFAULT = compile("\\$\\{[\\s]*?(?<token>[\\w.-]+)([\\s]*?[|][\\s]*(?<args>.*))?[\\s]*?}");
  private static final Pattern PATTERN_DEFAULT_ARGS = compile("(?<key>[\\w\\d-_]*)[\\s]*?:[\\s]*?'(?<value>[^']*)'");

  public static <T extends Replacer> StringReplacer newStringReplacer(Collection<T> replacers) {
    return newStringReplacer(replacers, PATTERN_DEFAULT);
  }

  public static <T extends Replacer> StringReplacer newStringReplacer(String pattern, Collection<T> replacers) {
    return newStringReplacer(replacers, compile(pattern));
  }

  public static <T extends Replacer> StringReplacer newStringReplacer(Collection<T> replacers, Pattern pattern) {
    return new StringReplacerImpl(replacers, pattern, PATTERN_DEFAULT_ARGS);
  }

  public static <T extends Replacer> StringReplacer newStringReplacer(Collection<T> replacers, Pattern pattern, Pattern patternArgs) {
    return new StringReplacerImpl(replacers, pattern, patternArgs);
  }
}
