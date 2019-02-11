package com.github.thiagogarbazza.stringreplacer;

import java.util.Collection;
import java.util.regex.Pattern;

class StringReplacerImpl implements StringReplacer {

  private final Pattern pattern;
  private final Pattern patternArgs;
  private final Replacers replacers;

  public StringReplacerImpl(final Collection<? extends Replacer> replacers, final Pattern pattern, final Pattern patternArgs) {
    this.replacers = new Replacers(replacers);
    this.pattern = pattern;
    this.patternArgs = patternArgs;
  }

  @Override
  public String replace(final String text, final Object data) {
    final Expressions expressions = new Expressions(pattern, patternArgs, text);

    for (Expressions.Expression expression : expressions) {
      final Replacer replacer = replacers.find(expression.getToken(), expression.getArgs(), data);

      if (replacer != null) {
        final String result = replacer.toReplace(expression.getArgs(), data);

        expression.setResult(result);
      }
    }

    return expressions.result();
  }
}
