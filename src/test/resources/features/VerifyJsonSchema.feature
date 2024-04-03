Feature:
  Scenario: Verify API response matches the Json schema
    When  Fetch response by hitting api with endpoint "v6/latest/USD"
    Then  Json schema matches API response