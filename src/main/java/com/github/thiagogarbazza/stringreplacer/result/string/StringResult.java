package com.github.thiagogarbazza.stringreplacer.result.string;

import com.github.thiagogarbazza.stringreplacer.OutputType;
import com.github.thiagogarbazza.stringreplacer.result.Result;

public class StringResult implements Result {

  private final String value;

  public StringResult(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  @Override
  public String output(final OutputType type, final String token) {
    return this.value;
  }
}
