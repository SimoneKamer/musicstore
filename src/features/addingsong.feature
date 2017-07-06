Feature: Add track to the database

  In order to being able to sell more music
  As an employee
  I want to add a track to an album


  All tracks have a name, id, mediatypeId, milliseconds and price assigned to them


Scenario: Add a track to an existing album

  Given the album "Kinderliedjes" is registered
   When John adds "Vader Jacob" to the album "Kinderliedjes"
   Then customers should be able to buy "Vader Jacob"

