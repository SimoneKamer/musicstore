package com.github.shmvanhouten.musicstore.Track;

import java.math.BigDecimal;

public class Track {
    private final int trackId;
    private final String name;
    private final String albumTitle;
    private final String artistName;
    private final BigDecimal price;

    public Track(int trackId, String name, String albumTitle, String artistName, BigDecimal price){
        this.trackId = trackId;
        this.name = name;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
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

    public BigDecimal getPrice() {
        return price;
    }

    public static final class TrackBuilder {
        private int trackId;
        private String name;
        private String albumTitle;
        private String artistName;
        private BigDecimal price;

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

        public Track build() {
            Track track = new Track(trackId, name, albumTitle, artistName, price);
            return track;
        }
    }
}
