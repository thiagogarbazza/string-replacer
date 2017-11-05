package com.github.thiagogarbazza.stringreplacer;

import com.github.thiagogarbazza.stringreplacer.result.Result;

public interface Replacer<T extends Object> {

  String fromToken();

  Result toReplace(T data, String[] args);
}
