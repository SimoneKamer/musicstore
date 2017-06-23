package com.github.shmvanhouten.musicstore.Artist;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/artist")
public class ArtistResource {
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistResource(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @RequestMapping(method= GET)
    @ApiOperation(value = "getArtists", nickname = "getArtists")
    public List<Artist> getAll(){
        return artistRepository.getAll();
    }

    @RequestMapping(method = POST)
    public Long addArtist(String name){
        return artistRepository.addArtist(name);
    }
}
