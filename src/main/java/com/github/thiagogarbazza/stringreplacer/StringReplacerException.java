package com.github.thiagogarbazza.stringreplacer;

public class StringReplacerException extends RuntimeException {

  public StringReplacerException(String key) {
    super(key);
  }

  public StringReplacerException(String key, Throwable cause) {
    super(key, cause);
  }
}
