package com.github.shmvanhouten.musicstore;

import java.util.List;

public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbumsForArtist(Artist artist){
        return albumRepository.getAllAlbumsForArtist(artist);
    }
}
