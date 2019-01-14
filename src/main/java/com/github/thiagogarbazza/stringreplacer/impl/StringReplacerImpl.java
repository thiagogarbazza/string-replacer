package com.github.thiagogarbazza.stringreplacer.impl;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacer;

import java.util.Collection;
import java.util.regex.Pattern;

class StringReplacerImpl implements StringReplacer {

  private final Pattern pattern;
  private final Pattern patternArgs;
  private final Replacers replacers;

  public <T extends Replacer> StringReplacerImpl(final Collection<T> replacers, final Pattern pattern, final Pattern patternArgs) {
    this.replacers = new Replacers(replacers);
    this.pattern = pattern;
    this.patternArgs = patternArgs;
  }

  @Override
  public String replace(final String text, final Object data) {
    final Expressions expressions = new Expressions(pattern, patternArgs, text);

    for (Expressions.Expression expression : expressions) {
      final Replacer replacer = replacers.get(expression.getToken());
      final String result = replacer.toReplace(data, expression.getArgs());

      expression.setResult(result);
    }

    return expressions.result();
  }
}
