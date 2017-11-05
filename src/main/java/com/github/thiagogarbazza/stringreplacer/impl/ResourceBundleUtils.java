package com.github.thiagogarbazza.stringreplacer.impl;

import java.util.ResourceBundle;

import static java.text.MessageFormat.format;

final class ResourceBundleUtils {

  private static final ResourceBundle APPLICATION_BUNDLE = ResourceBundle.getBundle("string-replacer");

  private ResourceBundleUtils() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  static String property(String key, Object... args) {
    if (args == null) {
      return property(key);
    }
    return format(property(key), args);
  }

  static String property(String key) {
    return APPLICATION_BUNDLE.getString(key);
  }
}
