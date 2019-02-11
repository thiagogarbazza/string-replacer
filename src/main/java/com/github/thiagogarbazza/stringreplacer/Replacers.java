package com.github.thiagogarbazza.stringreplacer;

import java.util.Collection;
import java.util.TreeMap;

import static com.github.thiagogarbazza.stringreplacer.ResourceBundleUtils.property;

class Replacers extends TreeMap<String, Replacer> {

  public <T extends Replacer> Replacers(final Collection<T> replacers) {
    super();

    for (Replacer replacer : replacers) {
      this.put(replacer.fromToken(), replacer);
    }
  }

  @Override
  public Replacer get(final Object token) {
    final Replacer replacer = super.get(token);

    if (replacer == null) {
      throw new StringReplacerException(property("string-replacer.validation.replacer.not-found", token));
    }

    return replacer;
  }
}
