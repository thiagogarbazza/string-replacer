package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.Token;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.upperCase;

public class SimpleBooleanReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final Token token, final DataProcessor data) {
    return "simple-boolean".equals(token.getName());
  }

  @Override
  public String toReplace(final Token token, final DataProcessor data) {
    final String textCase = upperCase(token.getArg("case"));
    final String trueText = token.getArg("true-text", "true");
    final String falseText = token.getArg("false-text", "false");

    final String text = data.getABoolean()
      ? trueText
      : falseText;

    if (isNotBlank(textCase)) {
      return Case.valueOf(textCase).parser(text);
    }

    return text;
  }
}
