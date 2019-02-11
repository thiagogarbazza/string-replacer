package com.github.thiagogarbazza.stringreplacer;

import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

import static java.text.MessageFormat.format;

@UtilityClass
class ResourceBundleUtils {

  private static final ResourceBundle APPLICATION_BUNDLE = ResourceBundle.getBundle("string-replacer");

  public static String property(String key, Object... args) {
    if (args == null) {
      return property(key);
    }

    return format(property(key), args);
  }

  public static String property(String key) {
    return APPLICATION_BUNDLE.getString(key);
  }
}
