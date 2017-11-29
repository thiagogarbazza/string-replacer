package com.github.thiagogarbazza.stringreplacer.result;

import com.github.thiagogarbazza.stringreplacer.OutputType;

public interface Result {

  String output(OutputType type, String token);
}
