Feature: login

@pos
  Scenario Template: logging in using valid user name and password
    Given user go to the login page of the site "http://www.demo.guru99.com/V4/"
    When user enters the user name "<name>" and password "<password>"
    And clicks the login Button
    Then a "Login successful" message is displayed
  Examples:
    |name|password|
    |mngr516921|zYgegAs|
@nega
  Scenario Outline: invalid enteries
  Given user go to the login page of the site "http://www.demo.guru99.com/V4/"
  When user enters the user name "<name>" and password "<password>"
  And clicks the login Button
  Then a "User or Password is not valid" popup message is displayed
  Examples:
  |name|password|
  |  mngr516921  |    ayklam    |
  |5altybtslm3lek|   zYgegAs    |
  |lehbydarykda  |koldahkanleh  |