package com.github.shmvanhouten.musicstore.album;

import com.github.shmvanhouten.musicstore.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> getAllAlbumsForArtist(Artist artist){
        List<Album> albums = new ArrayList<>();

        Album album = new Album("Kinderliedjes");
        albums.add(album);
        // do sql queries etc.
        return albums;
    }
}
