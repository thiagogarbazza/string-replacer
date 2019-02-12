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
    final Tokens tokens = new Tokens(pattern, patternArgs, text);

    while (tokens.hasNext()) {
      Tokens.Token token = tokens.next();
      final Replacer replacer = replacers.find(token.getName(), token.getArgs(), data);

      if (replacer != null) {
        final String result = replacer.toReplace(token.getArgs(), data);
        token.setResult(result);
      }
    }

    return tokens.result();
  }
}
