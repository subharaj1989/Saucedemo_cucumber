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
   