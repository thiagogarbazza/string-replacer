package com.github.thiagogarbazza.stringreplacer;

public interface Replacer<T> {

  boolean fromToken(Token token, T data);

  String toReplace(Token token, T data);
}
