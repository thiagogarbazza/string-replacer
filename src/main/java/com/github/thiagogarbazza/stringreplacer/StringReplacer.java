package com.github.thiagogarbazza.stringreplacer;

import com.github.thiagogarbazza.stringreplacer.result.OutputType;

public interface StringReplacer {

  String replace(final String text, final Object data, final OutputType type);
}
