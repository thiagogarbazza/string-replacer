package com.github.thiagogarbazza.stringreplacer;

import java.util.Collection;
import java.util.Map;

class Replacers {

  private final Collection<? extends Replacer> itens;

  public Replacers(final Collection<? extends Replacer> itens) {
    this.itens = itens;
  }

  public Replacer find(final String token, final Map<String, String> args, final Object data) {
    for (final Replacer replacer : this.itens) {
      if (replacer.fromToken(token, args, data)) {
        return replacer;
      }
    }

    return null;
  }
}
