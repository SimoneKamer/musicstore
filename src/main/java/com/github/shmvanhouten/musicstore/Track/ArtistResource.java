package com.github.shmvanhouten.musicstore.Track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArtistResource {
    private final TrackRepositoryJdbcTemplateImpl trackRepository;

    @Autowired
    public ArtistResource(TrackRepositoryJdbcTemplateImpl trackRepository) {
        this.trackRepository = trackRepository;
    }

    public void printTracks() {
        List<Track> trackList = trackRepository.getTracksForArtist("Metallica");
        for (Track track : trackList) {
            System.out.println(track.getTrackId() + " -- " + track.getName() + " . . . " + track.getAlbumTitle());
        }
    }

}
