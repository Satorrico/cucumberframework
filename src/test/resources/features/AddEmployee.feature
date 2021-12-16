Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button


  @1027
  Scenario: first scenario of adding employee
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @1027
  Scenario: second scenario of adding the employee
    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

  @1027
  Scenario: third scenario of adding the employee
    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully

  @1028
  Scenario: adding an employee from feature file
    And user enters "mike34" "drew" and "lopez"
    And user clicks on save button
    Then employee added successfully


  @examples
  Scenario Outline: adding an employee from feature file
    And user enters "<firstName>" "<middleName>" and "<lastName>" for an employee
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | hello890  | love       | smith    |
      | taliya    | may        | lopez    |
      | steph     | sandy      | drew     |

  @datatable
  Scenario: adding an employee using data table
    When I add mulitple employees and verify them user has been added successfully
      | firstName | middleName | lastName |
      | hello890  | love       | smith    |
      | taliya    | may        | lopez    |
      | steph     | sandy      | drew     |
      | dddd      | kkk        | llll     |
      | kkkkf     | llll       | kkkk     |

  Scenario:  adding an employee using data table
    When I add mulitple employees and verify them user has been added successfully in application
      | firstName | middleName | lastName |
      | hello890  | love       | smith    |
      | taliya    | may        | lopez    |
      | steph     | sandy      | drew     |

    @excel
    Scenario: Adding an employee from excel file
      When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee



