package com.github.thiagogarbazza.stringreplacer;

import java.util.Map;

public interface Replacer<T extends Object> {

  String fromToken();

  String toReplace(T data, Map<String, String> args);
}
