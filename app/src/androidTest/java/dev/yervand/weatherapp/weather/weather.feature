Feature: Weather

Weather App get 5 days weather data for selected city from list, and show 3 hour forecast


 Scenario: Select city from list, load and show data
      Given list of cities and user should be selecting city,
      when city selected, data received from public Weather API should be shown.

