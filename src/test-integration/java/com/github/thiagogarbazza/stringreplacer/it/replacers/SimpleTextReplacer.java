package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.upperCase;

public class SimpleTextReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final String token, final Map<String, String> args, final DataProcessor data) {
    return "simple-text".equals(token);
  }

  @Override
  public String toReplace(final Map<String, String> args, final DataProcessor data) {
    final boolean spaceToUnderscored = DefaultValue.defaultValue(args.get("space-to-underscored"), false);
    final String textCase = upperCase(args.get("case"));

    String text = !spaceToUnderscored
      ? data.getAText()
      : data.getAText().replace(" ", "_");

    if (isNotBlank(textCase)) {
      return Case.valueOf(textCase).parser(text);
    }

    return text;
  }
}
