package com.github.thiagogarbazza.stringreplacer.ta.replacers;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.BooleanUtils;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@UtilityClass
class DefaultValue {

  public static String defaultValue(String value, String defaultValue) {
    return isNotBlank(value) ? value : defaultValue;
  }

  public static boolean defaultValue(String value, boolean defaultValue) {
    return isNotBlank(value) ? BooleanUtils.toBoolean(value) : defaultValue;
  }
}
