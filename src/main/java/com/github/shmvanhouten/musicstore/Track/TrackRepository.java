package com.github.shmvanhouten.musicstore.Track;

import java.util.List;

public interface TrackRepository {
    List<Track> getTracksForArtist(String name);

    List<Track> getTracksForAlbum(String artistName, String albumName);

    void setTrack(Long id, String name, Long albumId);

    Long getNextTrackId();
}
