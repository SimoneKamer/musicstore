package com.github.shmvanhouten.musicstore.tests;

import com.github.shmvanhouten.musicstore.Album.AlbumRepositoryJdbcTemplateImpl;
import com.github.shmvanhouten.musicstore.Track.Track;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.GsonBuilder;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;

import static java.math.BigDecimal.ONE;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class CucumberSteps {


    @Given("^the album \"([^\"]*)\" is registered$")
    public void the_album_is_registered(String albumName) throws Throwable {


        // Skip: Done manually


        // INSERT INTO ALBUM albumName




    }

    @When("^John adds \"([^\"]*)\" to the album \"([^\"]*)\"$")
    public void johnAddsToTheAlbum(String trackName, String albumTitle) throws Throwable {

        // Simuleer wat de gebruiker echt doet.
        Track newTrack = Track.TrackBuilder.aTrack()
                .withAlbumTitle(albumTitle)
                .withArtistName("Marco Beelen")
                .withName(trackName)
                .withMediaTypeId(1L)
                .withMilliseconds(187300)
                .withPrice(ONE)
                .build();


        String trackAsJson = new GsonBuilder().create().toJson(newTrack);
        System.out.println(trackAsJson);


        String s = Request.Post("http://localhost:8080/track")
                .bodyString(trackAsJson, APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();

        System.out.println(s);



    }



    @Then("^customers should be able to buy \"([^\"]*)\"$")
    public void customers_should_be_able_to_buy(String trackName) throws Throwable {

        // SELECT FROM DB
        // Controleer dat


        //

    }


}
