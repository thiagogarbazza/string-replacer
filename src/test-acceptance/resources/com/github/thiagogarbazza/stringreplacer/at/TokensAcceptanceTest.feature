Feature: All tokens in template

  ${{ token-name | arg-name-01 = 'arg-value-01' }}
  ${{ token-name | arg-name-01 : 'arg-value-01' }}

  ${{ token-name | arg-name-01='arg-value-01', arg-name-02='arg-value-02' }}
  ${{ token-name | arg-name-01:'arg-value-01', arg-name-02:'arg-value-02' }}

  ${{ token-name | arg-name-01 = 'arg-value-01', arg-name-02 = 'arg-value-02' }}
  ${{ token-name | arg-name-01 : 'arg-value-01', arg-name-02 : 'arg-value-02' }}

  Scenario: 01-01. One token without arguments
    Given that I have the following template:
      """
      Lorem ipsum dolor sit amet ${{token-example}} consectetur adipiscing elit.
      Duis yes elit sollicitudin nisl faucibus tempus $55.55 aenean.
      Sed quam quam, commodo sed ipsum eget, porta maximus leo 25/12/2018.
      Quisque consequat magna true interdum malesuada et at erat.
      """
    When to ask what tokens are in the text?
    Then I will receive the following tokens:
      | Position   | Token         | Args |
      | 1:27, 1:45 | token-example |      |

  Scenario: 01-02. One token with one argument
    Given that I have the following template:
      """
      Lorem ipsum dolor sit amet ${{token-example | arg='value'}} consectetur adipiscing elit.
      Duis yes elit sollicitudin nisl faucibus tempus $55.55 aenean.
      Sed quam quam, commodo sed ipsum eget, porta maximus leo 25/12/2018.
      Quisque consequat magna true interdum malesuada et at erat.
      """
    When to ask what tokens are in the text?
    Then I will receive the following tokens:
      | Position   | Token         | Args      |
      | 1:27, 1:59 | token-example | arg=value |

  Scenario: 01-03. One token with arguments
    Given that I have the following template:
      """
      Lorem ipsum dolor sit amet ${{token-example | arg0='value0', arg1='value1', arg2='value2', arg3='value3'}} consectetur adipiscing elit.
      Duis yes elit sollicitudin nisl faucibus tempus $55.55 aenean.
      Sed quam quam, commodo sed ipsum eget, porta maximus leo 25/12/2018.
      Quisque consequat magna true interdum malesuada et at erat.
      """
    When to ask what tokens are in the text?
    Then I will receive the following tokens:
      | Position    | Token         | Args                                               |
      | 1:27, 1:106 | token-example | arg0=value0, arg1=value1, arg2=value2, arg3=value3 |

  Scenario: 02-01. Many token without arguments
    Given that I have the following template:
      """
      Lorem ipsum dolor sit amet ${{token-example-00}} consectetur adipiscing elit.
      Duis ${{token-example-01}} elit sollicitudin nisl faucibus tempus ${{token-example-00}} aenean.
      Sed quam quam, commodo sed ipsum eget, porta maximus leo ${{token-example-02}}.
      Quisque consequat magna true interdum malesuada et at erat.
      """
    When to ask what tokens are in the text?
    Then I will receive the following tokens:
      | Position   | Token            | Args |
      | 1:27, 1:45 | token-example-00 |      |
      | 2:5, 1:26  | token-example-01 |      |
      | 2:66, 2:87 | token-example-00 |      |
      | 3:57, 2:87 | token-example-02 |      |

  Scenario: 02-02. Many token with one argument
    Given that I have the following template:
      """
      Lorem ipsum dolor sit amet ${{token-example-00 | arg='value'}} consectetur adipiscing elit.
      Duis ${{token-example-01 | arg01='value'}} elit sollicitudin nisl faucibus tempus ${{token-example-00 | arg00='value'}} aenean.
      Sed quam quam, commodo sed ipsum eget, porta maximus leo ${{token-example-02 | arg02='value'}}.
      Quisque consequat magna true interdum malesuada et at erat.
      """
    When to ask what tokens are in the text?
    Then I will receive the following tokens:
      | Position    | Token            | Args          |
      | 1:27, 1:62  | token-example    | arg=value     |
      | 2:5, 1:42   | token-example-01 | arg01=value   |
      | 2:82, 2:119 | token-example-00 | arg00-1=value |
      | 3:57, 2:94  | token-example-02 | arg02=value   |

  Scenario: 02-03. Many token with arguments
    Given that I have the following template:
      """
      Lorem ipsum dolor sit amet ${{token-example | arg0='value0', arg1='value1', arg2='value2', arg3='value3'}} consectetur adipiscing elit.
      Duis ${{token-example-01 | arg01='value'}} elit sollicitudin nisl faucibus tempus ${{token-example | arg1='value1', arg3='value3'}} aenean.
      Sed quam quam, commodo sed ipsum eget, porta maximus leo ${{token-example-02 | arg02-01='value01', arg02-02='value02'}}.
      Quisque consequat magna ${{token-example-3}} interdum malesuada et at erat.
      """
    When to ask what tokens are in the text?
    Then I will receive the following tokens:
      | Position    | Token            | Args                                               |
      | 1:27, 1:106 | token-example-00 | arg0=value0, arg1=value1, arg2=value2, arg3=value3 |
      | 2:5, 1:42   | token-example-01 | arg01=value                                        |
      | 2:82, 2:131 | token-example-00 | arg1=value1, arg3=value3                           |
      | 3:57, 2:119 | token-example-02 | arg02-01=value01, arg02-02=value02                 |
      | 4:24, 4:44  | token-example-03 |                                                    |
