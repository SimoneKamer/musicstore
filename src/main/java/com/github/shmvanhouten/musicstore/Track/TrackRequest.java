package com.github.shmvanhouten.musicstore.Track;

public class TrackRequest {

    private String name;
    private String albumTitle;
    private String artistName;
    private Long mediaTypeId;
    private Integer milliseconds;
    private Double unitPrice;

    public TrackRequest(String name, String albumTitle, String artistName, Long mediaTypeId, Integer milliseconds, Double unitPrice) {
        this.name = name;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.mediaTypeId = mediaTypeId;
        this.milliseconds = milliseconds;
        this.unitPrice = unitPrice;
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

    public Long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public Integer getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
