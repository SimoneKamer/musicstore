package com.github.shmvanhouten.musicstore.Track;

public class TrackRequest {

    private String name;
    private String albumTitle;
    private String artistName;

    public TrackRequest(String name, String albumTitle, String artistName) {
        this.name = name;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
    }

    public TrackRequest() {
    }

    public String getName() {
        return name;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
