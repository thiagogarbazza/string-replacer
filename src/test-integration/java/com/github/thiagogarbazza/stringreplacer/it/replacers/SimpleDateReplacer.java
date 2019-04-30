package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.Token;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.apache.commons.lang3.BooleanUtils.toBoolean;

public class SimpleDateReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final Token token, final DataProcessor data) {
    return "simple-date".equals(token.getName());
  }

  @Override
  public String toReplace(final Token token, final DataProcessor data) {
    final String format = token.getArg("format", "yyyy-MM-dd");
    final String maxDayOfMonth = token.getArg("max-day-of-month", "false");

    final Calendar aDate = data.getADate();

    if (toBoolean(maxDayOfMonth)) {
      aDate.set(Calendar.DAY_OF_MONTH, aDate.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.format(aDate.getTime());
  }
}
