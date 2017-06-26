package com.github.shmvanhouten.musicstore.Track;

import com.github.shmvanhouten.musicstore.Album.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {
    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository, AlbumRepository albumRepository) {
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
    }

    public Long setTrack(Track track) {
        Long id = trackRepository.getNextTrackId();
        Long albumId = albumRepository.getIdByTitleAndArtist(track.getAlbumTitle(), track.getArtistName());
        trackRepository.setTrack(id, track, albumId);
        return id;
    }
}
