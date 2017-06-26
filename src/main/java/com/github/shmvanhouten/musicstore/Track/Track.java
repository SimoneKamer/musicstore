package com.github.shmvanhouten.musicstore.Track;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Track {
    private final int trackId;
    private final String name;
    private final String albumTitle;
    private final String artistName;
    private final Long mediaTypeId;
    private final Integer milliseconds;
    private final BigDecimal price;

    public Track(@JsonProperty("id") int trackId, @JsonProperty("name") String name, @JsonProperty("albumTitle") String albumTitle,
                 @JsonProperty("artistName") String artistName, @JsonProperty("mediaTypeId") Long mediaTypeId,
                 @JsonProperty("milliseconds") Integer milliseconds, @JsonProperty("price") BigDecimal price){
        this.trackId = trackId;
        this.name = name;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.mediaTypeId = mediaTypeId;
        this.milliseconds = milliseconds;
        this.price = price;
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

    public String getArtistName() {
        return artistName;
    }

    public Long getMediaTypeId() {
        return mediaTypeId;
    }

    public Integer getMilliseconds() {
        return milliseconds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static final class TrackBuilder {
        private int trackId;
        private String name;
        private String albumTitle;
        private String artistName;
        private BigDecimal price;
        private Long mediaTypeId;
        private Integer milliseconds;

        private TrackBuilder() {
        }

        public static TrackBuilder aTrack() {
            return new TrackBuilder();
        }

        public TrackBuilder withTrackId(int trackId) {
            this.trackId = trackId;
            return this;
        }

        public TrackBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TrackBuilder withAlbumTitle(String albumTitle) {
            this.albumTitle = albumTitle;
            return this;
        }

        public TrackBuilder withArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public TrackBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public TrackBuilder withMediaTypeId(Long mediaTypeId) {
            this.mediaTypeId = mediaTypeId;
            return this;
        }

        public TrackBuilder withMilliseconds(Integer milliseconds) {
            this.milliseconds = milliseconds;
            return this;
        }

        public Track build() {
            Track track = new Track(trackId, name, albumTitle, artistName, mediaTypeId, milliseconds, price);
            return track;
        }
    }
}
