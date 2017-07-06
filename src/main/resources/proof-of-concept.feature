Feature: Show that Cucumber Works

  Scenario: Run some scenario

    Given the chinook database is loaded
     When the artist with id 1 is requested
     Then the name should be "AC/DC"