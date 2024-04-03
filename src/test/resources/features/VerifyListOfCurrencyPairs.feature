Feature:
  Scenario: Verify that 162 currency pairs are returned by the API
    When  Fetch response by hitting api with endpoint "v6/latest/USD"
    Then  Total currency pairs returned are 162