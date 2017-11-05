package com.github.thiagogarbazza.stringreplacer.integrationtest.data;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.result.Result;
import com.github.thiagogarbazza.stringreplacer.result.string.StringResult;

class ReplacerUserName implements Replacer<UserVO> {

  @Override
  public String fromToken() {
    return "user.name";
  }

  @Override
  public Result toReplace(final UserVO data, final String[] args) {
    return new StringResult(data.getName());
  }
}
