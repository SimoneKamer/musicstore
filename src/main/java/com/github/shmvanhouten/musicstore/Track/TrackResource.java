package com.github.shmvanhouten.musicstore.Track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/track")
public class TrackResource {
    private final TrackRepository trackRepository;

    @Autowired
    public TrackResource(TrackRepositoryJdbcTemplateImpl trackRepository) {
        this.trackRepository = trackRepository;
    }

    @RequestMapping(method=GET, path="/{artistName}")
    public List<Track> getByArtistName(@PathVariable("artistName")String artistName){
        return trackRepository.getTracksForArtist(artistName);
    }

    @RequestMapping(method=GET, path="/{artistName}/{albumName}")
    public List<Track> getByArtistAndAlbum(@PathVariable("artistName") String artistName, @PathVariable("albumName") String albumName){
        return trackRepository.getTracksForAlbum(artistName, albumName);
    }
}
