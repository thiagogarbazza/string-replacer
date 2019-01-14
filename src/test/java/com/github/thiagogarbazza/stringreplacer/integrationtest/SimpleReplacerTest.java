package com.github.thiagogarbazza.stringreplacer.integrationtest;

public class SimpleReplacerTest {

//  private static final UserVO DATA = buildThiagoGarbazza();
//
//  @Rule
//  public ExpectedException expectedException = ExpectedException.none();
//  private StringReplacer stringReplacer;
//
//  @Before
//  public void beforeTest() {
//    stringReplacer = StringReplacerFactory.newStringReplacer(new Replacers());
//  }
//
//  @Test
//  public void verifyNotFindReplacerForToken() {
//    expectedException.expect(StringReplacerException.class);
//    expectedException.expectMessage("Not found implementation Relpacer interface for the \"TOKEN_REPLACER_NOT_FOUND\" token");
//
//    final String textIn = "{{TOKEN_REPLACER_NOT_FOUND}}";
//    stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//  }
//
//  @Test
//  public void verifySimpleReplacer() {
//    final String textIn = "{{user.name}}";
//    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//
//    assertEquals("Thiago Garbazza", textResult);
//  }
//
//  @Test
//  public void verifySimpleReplacerUsingSpaces() {
//    final String textIn = "{{  user.creationDate  |  YYYY-MM-dd  }}";
//    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//
//    assertEquals("1984-07-20", textResult);
//  }
//
//  @Test
//  public void verifySimpleReplacerWithParametersPassingComplexValue() {
//    final String textIn = "{{user.creationDate|YYYY-MM-dd}}";
//    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//
//    assertEquals("1984-07-20", textResult);
//  }
//
//  @Test
//  public void verifySimpleReplacerWithParametersPassingSimpleValue() {
//    final String textIn = "{{user.creationDate|YYYYMMdd}}";
//    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//
//    assertEquals("19840720", textResult);
//  }
//
//  @Test
//  public void verifySimpleReplacerWithParametersUsingDefault() {
//    final String textIn = "{{user.creationDate}}";
//    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//
//    assertEquals("19840720054500000", textResult);
//  }
//
//  @Test
//  public void verifyWhenThereIsNoTokenInTheText() {
//    final String textIn = "My name is Thiago Garbazza";
//    String textResult = stringReplacer.replace(textIn, DATA, PLAIN_TEXT);
//
//    assertEquals("My name is Thiago Garbazza", textResult);
//  }
}
