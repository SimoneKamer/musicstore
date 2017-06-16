package com.github.shmvanhouten.musicstore;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumRepository {
    public List<Album> getAllAlbumsForArtist(Artist artist){
        List<Album> albums = new ArrayList<>();

        Album album = new Album("Kinderliedjes");
        albums.add(album);
        // do sql queries etc.
        return albums;
    }
}
