package com.github.shmvanhouten.musicstore.Track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("/track")
public class TrackResource {
    private final TrackRepository trackRepository;
    private final TrackService trackService;

    @Autowired
    public TrackResource(TrackRepositoryJdbcTemplateImpl trackRepository, TrackService trackService) {
        this.trackRepository = trackRepository;
        this.trackService = trackService;
    }

    @RequestMapping(method = GET, path = "/byId/{trackId}")
    public Track getById(@PathVariable("trackId")Long trackId){
        return trackRepository.getById(trackId);
    }

    @RequestMapping(method=GET, path="/{artistName}")
    public List<Track> getByArtistName(@PathVariable("artistName")String artistName){
        return trackRepository.getTracksForArtist(artistName);
    }

    @RequestMapping(method=GET, path="/{artistName}/{albumName}")
    public List<Track> getByArtistAndAlbum(@PathVariable("artistName") String artistName, @PathVariable("albumName") String albumName){
        return trackRepository.getTracksForAlbum(artistName, albumName);
    }

    @RequestMapping(method = POST)
    public Long addTrack(@RequestBody Track track){
        return trackService.setTrack(track);
    }
}
