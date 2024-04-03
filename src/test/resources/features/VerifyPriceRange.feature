Feature:
  Scenario: Verify USD price against the AED and make sure the prices are in range on 3.6 – 3.7
    When  Fetch response by hitting api with endpoint "v6/latest/USD"
    Then  I receive the price against the AED on range 3.6 - 3.7