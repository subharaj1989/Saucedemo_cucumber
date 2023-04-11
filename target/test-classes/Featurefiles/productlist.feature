Feature: Product List Validation
 Scenario Outline: Check whether the sort functionality is working as expected
   Given the user is on the product list page
   When the user selects "<SortBY>" from the Sort dropdown
   Then the product list should be sorted according to the selelction made
   
  Examples:
  |SortBY|
  |Name (A to Z)|
  |Name (Z to A)|
  |Price (low to high)|
  |Price (high to low)|
  
  Scenario Outline: Verify the count in the Cart icon is displaying correctly 
    Given the user is on the product list page
    When the user clicks on the add to cart for "<Product Names>" 
    Then the count displayed in the Cart icon should be equal to the number of products added
    
    Examples:
    |Product Names|
    |Sauce Labs Onesie|
    |Sauce Labs Bike Light|
    |Sauce Labs Bolt T-Shirt|
  
   