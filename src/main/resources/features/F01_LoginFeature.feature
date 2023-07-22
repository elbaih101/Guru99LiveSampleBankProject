Feature: login


 #pos
  Scenario: logging in using valid user name and password
    Given user go to the login page of the site "http://www.demo.guru99.com/V4/"
    When user enters the valid user name "mngr516921" and password "zYgegAs"
    And clicks the login Button
    Then a "Login successful" message is displayed

