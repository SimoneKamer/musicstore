package com.github.shmvanhouten.musicstore.Track;

public class Track {
    private final int trackId;
    private final String name;
    private final String albumTitle;

    public Track(int trackId, String name, String albumTitle) {
        this.trackId = trackId;
        this.name = name;
        this.albumTitle = albumTitle;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getName() {
        return name;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }
}
