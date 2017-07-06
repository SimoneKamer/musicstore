Feature: Add track to the database
  All tracks have a name, id, mediatypeId, milliseconds and price assigned to them

Scenario: Add a Track
  As An employee
  Given I have a new track I need to add to the database
  When I enter the track into the MusicStoreWebApplication with the necessary properties included
  Then The track should be added to the database