Feature: CIB Digital Tech User List Table

  Background:
    Given browser is launched
    And User List table "http://www.way2automation.com/angularjs-protractor/webtables/" page is open
    Then Validate user list table
    And click on add user

  Scenario Outline: Test if user can be added to the table
    When enters  <firstName> and <lastName> and <userName> then <password>
    And select <customer> and <role> and <email> also <cellPhone>
    Then click on save

    Examples:
      | firstName | lastName | userName | password | customer    | role     | email             | cellPhone |
      | FName1    | LName1   | User1    | Pass1    | Company AAA | Admin    | admin@mail.com    | 082555    |
      | FName2    | LName2   | User2    | Pass2    | Company BBB | Customer | cusomter@mail.com | 083444    |

