package com.github.shmvanhouten.musicstore;

import com.github.shmvanhouten.musicstore.Track.FindTracksForArtistController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TrackFinderApp implements CommandLineRunner {

    private final FindTracksForArtistController controller;

    @Autowired
    public TrackFinderApp(FindTracksForArtistController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(TrackFinderApp.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        // controller.printTracks();
    }
}
