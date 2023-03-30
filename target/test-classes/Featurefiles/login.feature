Feature:Login Functionality
 Scenario Outline: Login validation with valid inputs
   Given The user has launched the application
   When the user enters "<username>" and "<password>"
   Then user lands on homepage
  # And user logsout
   
   Examples:
   |username|password|
   |standard_user|secret_sauce|
   
   Scenario Outline: Login validation with invalid inputs
      Given The user has launched the application
      When the user enters "<username>" and "<password>"
      Then user shown appropriate "<error message>"
      
     Examples:
     |username|password|error message|
     |locked_out_user|secret_sauce|Sorry, this user has been locked out.|
     |user|secret_sauce|Username and password do not match any user in this service|
     |standard_user|sauce|Username and password do not match any user in this service|
     ||secret_sauce|Username is required|
     |standard_user||Password is required|