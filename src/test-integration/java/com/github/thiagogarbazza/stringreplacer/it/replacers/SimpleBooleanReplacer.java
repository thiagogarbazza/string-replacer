package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;

import java.util.Map;

import static com.github.thiagogarbazza.stringreplacer.it.replacers.DefaultValue.defaultValue;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.upperCase;

public class SimpleBooleanReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final String token, final Map<String, String> args, final DataProcessor data) {
    return "simple-boolean".equals(token);
  }

  @Override
  public String toReplace(final Map<String, String> args, final DataProcessor data) {
    final String text = data.getABoolean()
      ? defaultValue(args.get("true-text"), "true")
      : defaultValue(args.get("false-text"), "false");

    final String textCase = upperCase(args.get("case"));

    if (isNotBlank(textCase)) {
      return Case.valueOf(textCase).parser(text);
    }

    return text;
  }
}
