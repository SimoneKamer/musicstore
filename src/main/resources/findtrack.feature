Feature: finding a track in the database

Scenario: finding a track
  As a customer
  Given I have access to the MusicStoreWebApplication
  When I enter the name of the track i need
  Then I will be return the track with its properties