package com.github.thiagogarbazza.stringreplacer.it.replacers;

import org.apache.commons.lang3.StringUtils;

public enum Case {

  LOWER() {
    @Override
    public String parser(final String text) {
      return StringUtils.lowerCase(text);
    }
  },

  UPPER() {
    @Override
    public String parser(final String text) {
      return StringUtils.upperCase(text);
    }
  };

  public abstract String parser(String text);
}
