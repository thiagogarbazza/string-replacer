package com.github.thiagogarbazza.stringreplacer;

import lombok.extern.apachecommons.CommonsLog;

import java.util.Collection;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;

@CommonsLog
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
        LOGGER.trace(format("Before calling the replacer {0} of the token {1}.", replacer.getClass().getSimpleName(), token));
        final String result = replacer.toReplace(token.getArgs(), data);
        LOGGER.info(format("After calling the replacer {0} of the token {1} with result {2}.", replacer.getClass().getSimpleName(), token, result));
        token.setResult(result);
      } else {
        LOGGER.info(format("The {0} token will not be replaced.", token));
      }
    }

    return tokens.result();
  }
}
