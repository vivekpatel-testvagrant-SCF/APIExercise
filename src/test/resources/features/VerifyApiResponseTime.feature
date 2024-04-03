Feature:
  Scenario: Verify the API response Ɵme is not less then 3 seconds then current Ɵme in second.
    When  Fetch response by hitting api with endpoint "v6/latest/USD"
    Then  Response time is less than 3 seconds