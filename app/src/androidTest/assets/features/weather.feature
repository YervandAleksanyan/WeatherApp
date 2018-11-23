Feature: weather

  Scenario: WeatherActvity
    Given I have navigated to Weather screen
    When  List of cities will  created
    And   A cities list first item should be the same the entered data set first item

      #   When  User select city from list
      #   Then  City is selected label should be updated and loading started
      #
      #   When  Loading is complete
      #   Then  All data should be shown on a screen
