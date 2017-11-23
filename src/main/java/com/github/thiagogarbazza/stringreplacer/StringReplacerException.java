package com.github.thiagogarbazza.stringreplacer;

public class StringReplacerException extends RuntimeException {

  public StringReplacerException(String message) {
    super(message);
  }

  public StringReplacerException(String message, Throwable cause) {
    super(message, cause);
  }
}
