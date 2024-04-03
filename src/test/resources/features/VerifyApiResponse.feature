Feature:
  Scenario: Verify the api code and status returned
    When  Fetch response by hitting api with endpoint "v6/latest/USD"
    Then  Success code 200