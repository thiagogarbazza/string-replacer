package com.github.thiagogarbazza.stringreplacer;

import java.util.Collection;

class Replacers {

  private final Collection<? extends Replacer> itens;

  public Replacers(final Collection<? extends Replacer> itens) {
    this.itens = itens;
  }

  public Replacer find(final Token token, final Object data) {
    for (final Replacer replacer : this.itens) {
      if (replacer.fromToken(token, data)) {
        return replacer;
      }
    }

    return null;
  }
}
