package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;

import static com.github.thiagogarbazza.stringreplacer.it.replacers.DefaultValue.defaultValue;

public class SimpleNumberReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final String token, final Map<String, String> args, final DataProcessor data) {
    return "simple-number".equals(token);
  }

  @Override
  public String toReplace(final Map<String, String> args, final DataProcessor data) {
    final DecimalFormat decimalFormat = new DecimalFormat(defaultValue(args.get("format"), "#,##0"), new DecimalFormatSymbols(Locale.ENGLISH));

    final String roundingMode = args.get("rounding-mode");

    BigDecimal aNumber = data.getANumber();

    if (roundingMode != null) {
      decimalFormat.setRoundingMode(RoundingMode.valueOf(roundingMode.toUpperCase()));
    }

    return decimalFormat.format(aNumber);
  }
}
