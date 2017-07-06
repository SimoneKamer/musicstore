package com.github.shmvanhouten.musicstore.Album;

import com.github.shmvanhouten.musicstore.Album.Album;
import com.github.shmvanhouten.musicstore.Album.AlbumService;
import com.github.shmvanhouten.musicstore.Artist.Artist;
import com.github.shmvanhouten.musicstore.Artist.ArtistService;

import java.util.List;

public class FindAlbumsForArtistController {

    private final ArtistService artistService;
    private final AlbumService albumService;

    public FindAlbumsForArtistController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }


    public List<Album> getAlbumsForArtist(String artistName){
        Artist artist = artistService.getArtistByName(artistName);
        return albumService.getAllAlbumsForArtist(artist);
    }
}
