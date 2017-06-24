package com.github.shmvanhouten.musicstore.Album;

import com.github.shmvanhouten.musicstore.Artist.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface AlbumRepository {
    public List<Album> getAllAlbumsForArtist(Artist artist);

    public Long getIdByTitleAndArtist(String title, String artistName);

}
