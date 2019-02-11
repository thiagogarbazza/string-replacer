package com.github.thiagogarbazza.stringreplacer.it.replacers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class DataProcessor {

  private Boolean aBoolean;
  private Calendar aDate;
  private BigDecimal aNumber;
  private String aText;
}
