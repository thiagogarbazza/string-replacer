package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.Token;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SimpleNumberReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final Token token, final DataProcessor data) {
    return "simple-number".equals(token.getName());
  }

  @Override
  public String toReplace(final Token token, final DataProcessor data) {
    final String format = token.getArg("format", "#,##0");
    final String roundingMode = token.getArg("rounding-mode");

    BigDecimal aNumber = data.getANumber();

    final DecimalFormat decimalFormat = new DecimalFormat(format, new DecimalFormatSymbols(Locale.ENGLISH));
    if (roundingMode != null) {
      decimalFormat.setRoundingMode(RoundingMode.valueOf(roundingMode.toUpperCase()));
    }

    return decimalFormat.format(aNumber);
  }
}
