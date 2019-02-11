package com.github.thiagogarbazza.stringreplacer.it.replacers;

import com.github.thiagogarbazza.stringreplacer.Replacer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class SimpleDateReplacer implements Replacer<DataProcessor> {

  @Override
  public boolean fromToken(final String token, final Map<String, String> args, final DataProcessor data) {
    return "simple-date".equals(token);
  }

  @Override
  public String toReplace(final Map<String, String> args, final DataProcessor data) {
    final Calendar aDate = data.getADate();

    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DefaultValue.defaultValue(args.get("format"), "yyyy-MM-dd"));
    final boolean maxDayOfMonth = DefaultValue.defaultValue(args.get("max-day-of-month"), false);

    if (maxDayOfMonth) {
      aDate.set(Calendar.DAY_OF_MONTH, aDate.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    return simpleDateFormat.format(aDate.getTime());
  }
}
