package com.github.thiagogarbazza.stringreplacer.impl;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacer;

import java.util.Collection;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public final class StringReplacerFactory {

  private static final Pattern PATTERN_DEFAULT = compile("\\{\\{[ ]*?(?<token>[\\w.-]+)[| ]*?(?<args>[\\w,.-]+)?[ ]*?\\}\\}");

  private StringReplacerFactory() {
    throw new UnsupportedOperationException("This is a factory class and cannot be instantiated");
  }

  public static <T extends Replacer> StringReplacer newStringReplacer(Collection<T> replacers) {
    return newStringReplacer(PATTERN_DEFAULT, replacers);
  }

  public static <T extends Replacer> StringReplacer newStringReplacer(String pattern, Collection<T> replacers) {
    return newStringReplacer(compile(pattern), replacers);
  }

  public static <T extends Replacer> StringReplacer newStringReplacer(Pattern pattern, Collection<T> replacers) {
    return new StringReplacerImpl(pattern, replacers);
  }
}
