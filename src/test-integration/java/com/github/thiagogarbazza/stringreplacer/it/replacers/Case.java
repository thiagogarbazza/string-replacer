package com.github.thiagogarbazza.stringreplacer.it.replacers;

import org.apache.commons.lang3.StringUtils;

public enum Case {
  UPPER(){
    @Override
    public String parser(final String text) {
      return StringUtils.upperCase(text);
    }
  },

  LOWER(){
    @Override
    public String parser(final String text) {
      return StringUtils.lowerCase(text);
    }
  };


  public abstract String parser(String text);
}
