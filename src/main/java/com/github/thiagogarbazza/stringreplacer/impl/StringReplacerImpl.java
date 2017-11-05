package com.github.thiagogarbazza.stringreplacer.impl;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacer;
import com.github.thiagogarbazza.stringreplacer.result.OutputType;
import com.github.thiagogarbazza.stringreplacer.result.Result;

import java.util.Collection;
import java.util.regex.Pattern;

class StringReplacerImpl implements StringReplacer {

  private final Pattern pattern;
  private final StringReplacerMap replacers;

  public <T extends Replacer> StringReplacerImpl(final Pattern pattern, final Collection<T> replacers) {
    this.pattern = pattern;
    this.replacers = new StringReplacerMap(replacers);
  }

  @Override
  public String replace(final String text, final Object data, final OutputType type) {
    final Expressions expressions = new Expressions(pattern, text, type);

    for (Expressions.Expression expression : expressions) {
      final Replacer replacer = replacers.get(expression.getToken());
      final Result result = replacer.toReplace(data, expression.getArgs());

      expression.setResult(result);
    }

    return expressions.result();
  }
}
