package com.github.thiagogarbazza.stringreplacer.it;

import com.github.thiagogarbazza.stringreplacer.Replacer;
import com.github.thiagogarbazza.stringreplacer.StringReplacerFactory;
import com.github.thiagogarbazza.stringreplacer.it.replacers.DataProcessor;
import com.github.thiagogarbazza.stringreplacer.it.replacers.SimpleBooleanReplacer;
import com.github.thiagogarbazza.stringreplacer.it.replacers.SimpleDateReplacer;
import com.github.thiagogarbazza.stringreplacer.it.replacers.SimpleNumberReplacer;
import com.github.thiagogarbazza.stringreplacer.it.replacers.SimpleTextReplacer;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.GregorianCalendar;

import static java.util.Arrays.asList;

public abstract class AbstractTestIntegration {

  protected static final Collection<Replacer<DataProcessor>> REPLACERS = asList(
    new SimpleBooleanReplacer(),
    new SimpleDateReplacer(),
    new SimpleNumberReplacer(),
    new SimpleTextReplacer());

  protected DataProcessor dataProcessor;

  @Before
  public void beforeAbstract() {
    dataProcessor = DataProcessor.builder()
      .aBoolean(Boolean.TRUE)
      .aDate(new GregorianCalendar(2018, 11, 25))
      .aNumber(new BigDecimal("3.14159265359"))
      .aText("any text")
      .build();
  }

  protected String replacer(final String templateText) {
    return replacer(templateText, dataProcessor);
  }

  protected String replacer(final String templateText, final DataProcessor dataProcessor) {
    return StringReplacerFactory.newStringReplacer(REPLACERS).replace(templateText, dataProcessor);
  }
}
