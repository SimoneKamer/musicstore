package com.github.shmvanhouten.musicstore.Artist;


public class Artist {
    private final Integer artistId;
    private final String name;

    public Artist(Integer artistId, String name){
        this.artistId = artistId;
        this.name = name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }


    public static final class ArtistBuilder {
        private Integer artistId;
        private String name;

        private ArtistBuilder() {
        }

        public static ArtistBuilder anArtist() {
            return new ArtistBuilder();
        }

        public ArtistBuilder withArtistId(Integer artistId) {
            this.artistId = artistId;
            return this;
        }

        public ArtistBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Artist build() {
            Artist artist = new Artist(artistId, name);
            return artist;
        }
    }
}
