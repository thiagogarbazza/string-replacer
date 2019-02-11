package com.github.thiagogarbazza.stringreplacer;

import java.util.Map;

public interface Replacer<T extends Object> {

  boolean fromToken(String token, Map<String, String> args, T data);

  String toReplace(Map<String, String> args, T data);
}
