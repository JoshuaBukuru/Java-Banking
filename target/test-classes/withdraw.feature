Feature: Withdraw amount safely by not crossing the minimum balance in account requirement
  Scenario: Withdraw amount safely
    Given Account balance is "1000"
    When Minimum account balance to maintain is "500"
    Then Successfully withdraw "100"

