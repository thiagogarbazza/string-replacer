package com.github.thiagogarbazza.stringreplacer;

import java.util.Collection;
import java.util.Map;

class Replacers {

  private final Collection<? extends Replacer> replacers;

  public Replacers(final Collection<? extends Replacer> replacers) {
    this.replacers = replacers;
  }

  public Replacer find(final String token, final Map<String, String> args, final Object data) {
    for (final Replacer replacer : this.replacers) {
      if (replacer.fromToken(token, args, data)) {
        return replacer;
      }
    }

    return null;
  }
}
