package com.github.shmvanhouten.musicstore;

public class DatabaseStructure {

    public class Table {
        public static final String GENRE = "genre";
        public static final String TRACK = "Track";
        public static final String ALBUM = "Album";
        public static final String ARTIST = "Artist";
    }

    public class TrackColumns {
        public static final String TRACK_ID = "Track.TrackId";
        public static final String TRACK_NAME = "Track.Name";
        public static final String TRACK_ALBUM_ID = "Track.AlbumId";
    }

    public class AlbumColumns {
        public static final String ALBUM_TITLE ="Album.Title";
        public static final String ALBUM_ALBUM_ID ="Album.AlbumId";
        public static final String ALBUM_ARTIST_ID ="Album.ArtistId";
    }

    public class ArtistColumns {
        public static final String ARTIST_ID = "Artist.ArtistId";
        public static final String ARTIST_NAME = "Artist.Name";

    }

    public class GenreColumns {
        public static final String ID = "GenreId";
        public static final String NAME = "Name";
    }

}
