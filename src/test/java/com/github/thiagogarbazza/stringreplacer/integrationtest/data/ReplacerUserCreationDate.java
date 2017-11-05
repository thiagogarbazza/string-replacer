package com.github.thiagogarbazza.stringreplacer.integrationtest.data;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.result.Result;
import com.github.thiagogarbazza.stringreplacer.result.string.StringResult;

import java.text.SimpleDateFormat;

class ReplacerUserCreationDate implements Replacer<UserVO> {

  public static final String DEFAULT_FORMAT = "YYYYMMddHHmmssSSS";

  @Override
  public String fromToken() {
    return "user.creationDate";
  }

  @Override
  public Result toReplace(final UserVO data, final String[] args) {
    SimpleDateFormat ft = new SimpleDateFormat(args != null ? args[0] : DEFAULT_FORMAT);

    return new StringResult(ft.format(data.getCreationDate().getTime()));
  }
}
