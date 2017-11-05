package com.github.thiagogarbazza.stringreplacer.result.string;

import com.github.thiagogarbazza.stringreplacer.result.OutputType;
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
  public String output(final OutputType type) {
    return this.value;
  }
}
