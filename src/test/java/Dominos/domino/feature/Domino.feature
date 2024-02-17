Feature: checkout the products from Dominos

  Scenario Outline: Add and remove products from the cart
    Given user opens the "<browser>" and Login to the Dominos website
    When user enter the address and select the first suggestion
    And user add the Farmhouse "<pizza1>" and count "<count1>" in the cartitems
    And user add the Margherita "<pizza2>" and count "<count2>" in the cartitems
    And user add the Peppy Paneer "<pizza3>" and count "<count3>" in the cartitems
    Then user check the cart subtotal
    And  user add the beverage "<beverage>" and count "<count>" in the cartitems
    Then user check the cart subtotal
    And user remove "<remove count of pizza>" the qty of Margherita "<pizza2>"
    And user remove "<remove count of beverage>" the qty of beverage "<beverage>"
    Then user check the cart subtotal
    And user get the subtotal and click checkout

    Examples:
      | browser | pizza1    | count1 | pizza2     | count2 | pizza3       | count3 | beverage  | count | remove count of pizza | remove pizza type | remove count of beverage | remove beverage type |
      | chrome  | Farmhouse | 1      | Margherita | 2      | Peppy Paneer | 1      | 7Up 475ml | 11    | 1                     | Margherita        | 6                        | 7Up 475ml            |
      | firefox | Farmhouse | 1      | Margherita | 2      | Peppy Paneer | 1      | 7Up 475ml | 11    | 1                     | Margherita        | 6                        | 7Up 475ml            |
      | edge    | Farmhouse | 1      | Margherita | 2      | Peppy Paneer | 1      | 7Up 475ml | 11    | 1                     | Margherita        | 6                        | 7Up 475ml            |
