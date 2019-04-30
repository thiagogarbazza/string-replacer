package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.Token;

import static org.apache.commons.lang3.BooleanUtils.toBoolean;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.upperCase;

public class SimpleTextReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final Token token, final DataProcessor data) {
    return "simple-text".equals(token.getName());
  }

  @Override
  public String toReplace(final Token token, final DataProcessor data) {
    final String spaceToUnderscored = token.getArg("space-to-underscored", "false");
    final String textCase = upperCase(token.getArg("case"));

    String text = !toBoolean(spaceToUnderscored)
      ? data.getAText()
      : data.getAText().replace(" ", "_");

    if (isNotBlank(textCase)) {
      return Case.valueOf(textCase).parser(text);
    }

    return text;
  }
}
