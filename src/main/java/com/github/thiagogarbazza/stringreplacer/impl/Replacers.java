package com.github.thiagogarbazza.stringreplacer.impl;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacerException;

import java.util.Collection;
import java.util.TreeMap;

import static com.github.thiagogarbazza.stringreplacer.impl.ResourceBundleUtils.property;

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
      throw new StringReplacerException(property("string-replacer.replacer-not-found", token));
    }

    return replacer;
  }
}
